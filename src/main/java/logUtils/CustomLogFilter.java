package logUtils;

import core.ApplicationProperties;
import io.qameta.allure.model.Attachment;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import static io.qameta.allure.Allure.getLifecycle;

@Log4j2
public class CustomLogFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append("\n");
        requestBuilder.append("Headers - ").append(filterableRequestSpecification.getHeaders().toString());
        requestBuilder.append("\n");
        requestBuilder.append("REQUEST:");
        requestBuilder.append("\n");
        requestBuilder.append("Method - ").append(filterableRequestSpecification.getMethod());
        requestBuilder.append("\n");
        requestBuilder.append("Endpoint - ").append(filterableRequestSpecification.getURI());
        requestBuilder.append("\n");
        if (filterableRequestSpecification.getBody() != null) {
            if (ApplicationProperties.getInstance().getLogs()) {
                requestBuilder.append("Body - ").append(stringPrettyFormat(filterableRequestSpecification.getBody().toString()));
            } else {
                requestBuilder.append("Body - ").append(filterableRequestSpecification.getBody().toString());
            }
            requestBuilder.append("\n");
        }
        requestBuilder.append("*****************************************************************");
        log.info(String.valueOf(requestBuilder));  //Log your request where you need it
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("\n");
        responseBuilder.append("RESPONSE:");
        responseBuilder.append("\n");
        responseBuilder.append("Status code - ").append(response.getStatusCode());
        responseBuilder.append("\n");
        if (filterableRequestSpecification.getBody() != null) {
            if (ApplicationProperties.getInstance().getLogs()) {
                responseBuilder.append("Body - ").append(stringPrettyFormat(response.body().asString()));
            } else {
                responseBuilder.append("Body - ").append(response.body().asString());
            }
            responseBuilder.append("\n");
        }
        responseBuilder.append("*****************************************************************");
        log.info(String.valueOf(responseBuilder)); //Log your response where you need it
        putAttachLog(requestBuilder.toString());
        putAttachLog(responseBuilder.toString());
        return response;
    }

    /**
     * Метод для печати json запросов и ответов в отформатированном виде под стиль json
     * @param text
     * @return
     */
    public static String stringPrettyFormat(String text) {
        try {
            text = new JSONObject(text).toString(4);
        } catch (JSONException ex) {
            try {
                text = new JSONArray(text).toString(4);
            } catch (JSONException ex1) {
                return text;
            }
        }
        return text;
    }

    public static void appendToFile(String fileName, String text) {
        try {
            Files.createDirectories(Paths.get(fileName).getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void putAttachLog(String text) {
        String stepId = getLifecycle().getCurrentTestCaseOrStep().orElse(null);
        if (stepId == null)
            return;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
        String source = stepId + "-attachment.txt";
        appendToFile("target/allure-results/" + source,
                formatter.format(new Date(System.currentTimeMillis())) + text);
        Attachment attachment = new Attachment().setSource(source).setName("log-step.log");
        getLifecycle().updateStep(stepId, s -> s.setAttachments(Collections.singletonList(attachment)));
    }
}