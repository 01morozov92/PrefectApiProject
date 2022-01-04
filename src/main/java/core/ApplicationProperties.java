package core;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class ApplicationProperties {

    private static ApplicationProperties applicationProperties;

    private static String url;
    private static Boolean logs;

    public ApplicationProperties() {
        try (InputStream fileInputStream = new FileInputStream("src/test/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            url = properties.getProperty("base.url");
            logs = Boolean.parseBoolean(properties.getProperty("logs.pretty.format"));
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static ApplicationProperties getInstance() {
        return ApplicationProperties.applicationProperties == null
                ? ApplicationProperties.applicationProperties = new ApplicationProperties()
                : ApplicationProperties.applicationProperties;
    }

    public String getUrl() {
        return url;
    }
    public Boolean getLogs() {
        return logs;
    }
}