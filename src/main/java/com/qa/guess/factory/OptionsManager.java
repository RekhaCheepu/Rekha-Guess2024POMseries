package com.qa.guess.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

    private Properties prop;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(prop.getProperty("remote"))) {
            options.setCapability("platformName", "linux");
            // options.setCapability("browserVersion", prop.getProperty("browserversion"));
        }

        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
            System.out.println(".....Running the test in Headless mode.......");
            options.addArguments("--headless");
        }
        return options;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        if (Boolean.parseBoolean(prop.getProperty("remote"))) {
            options.setCapability("platformName", "linux");
            // options.setCapability("browserVersion", prop.getProperty("browserversion"));
        }

        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
            System.out.println(".....Running the test in Headless mode.......");
            options.addArguments("--headless");
        }
        return options;
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();

        if (Boolean.parseBoolean(prop.getProperty("remote"))) {
            options.setCapability("platformName", "linux");
            // options.setCapability("browserVersion", prop.getProperty("browserversion"));
        }

        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
            System.out.println(".....Running the test in Headless mode.......");
            options.addArguments("--headless");
        }
        if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
            System.out.println(".....Running the test in Incognito mode.......");
            options.addArguments("--incognito");
        }
        return options;
    }
}
