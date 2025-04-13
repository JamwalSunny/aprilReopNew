package org.testing.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import URI.properties.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
    protected WebDriver driver;
    protected ChromeOptions options;

    public Base() {
    	WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headed");
        driver = new ChromeDriver(options);  	
    }

    @BeforeMethod
    public void browserLaunch() {
        driver.manage().window().maximize();
        String url = PropertiesFile.getProperty("url");
        driver.get(url);
    }

    @AfterMethod
    public void browserClose() {
        if (driver != null) {
            driver.close();
        }
    }
}
