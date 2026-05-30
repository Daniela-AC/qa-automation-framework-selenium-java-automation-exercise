package com.test.automationexercise.utils.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            InputStream file = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (file == null) {
                throw new RuntimeException("Config file not found");
            }
            properties.load(file);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public String getBaseUrl () {
        return properties.getProperty("base_url");
    }

    public String getBrowser () {
        return properties.getProperty("browser");
    }

    public boolean isHeadless () {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }
}
