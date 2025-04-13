package org.testing.testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import URI.properties.PropertiesFile;


public class TC1_loginYoutubeTrendingClick extends Base {
    
    @Test(priority = 0)
    public void testTrendingLink() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement guideButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(PropertiesFile.getProperty("guideButtonXpath"))
        ));
        guideButton.click();

        Thread.sleep(3000); // Optional: wait if page is slow to update

        driver.findElement(By.xpath(PropertiesFile.getProperty("trendingLinkXpath"))).click();

        WebElement headingText = driver.findElement(
            By.xpath(PropertiesFile.getProperty("trendingHeaderXpath"))
        );

        String text = headingText.getText();
        String expectedText = "Trending";
        Assert.assertEquals(text, expectedText, "The heading text is not as expected!");
    }

    public static String browser;

    public static void setBrowser() {
        browser = "Chrome";
    }
}
