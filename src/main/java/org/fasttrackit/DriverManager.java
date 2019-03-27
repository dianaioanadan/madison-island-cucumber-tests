package org.fasttrackit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver initDriver(String browser){

        switch (browser.toLowerCase()){

            default:
                System.out.println("Creating default driver for Chrome...");

               // if (System.setProperty("os.name").toLowerCase().contains("windows"))

            case "chrome":System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case  "firefox":System.setProperty("webdriver.gecko.driver", AppConfig.getGeckoDriverPath());
                driver = new FirefoxDriver();
                break;
            case  "ie":System.setProperty("webdriver.ie.driver", AppConfig.getIeDriverPath());
                driver = new InternetExplorerDriver();
                break;
    }
        driver.manage().timeouts().implicitlyWait(AppConfig.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(AppConfig.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(), TimeUnit.SECONDS);

        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
