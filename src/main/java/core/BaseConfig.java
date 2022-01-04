package core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import logUtils.CustomLogFilter;

public class BaseConfig {

    private final static String URL = ApplicationProperties.getInstance().getUrl();

    private final Filter logFilter = new CustomLogFilter();

    public RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addFilter(logFilter)
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
