package org.testing.testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import URI.properties.PropertiesFile;
import org.testing.Base.Base;

public class TC2_YouTubeHomePageandHistoryIconclick extends Base {

    @Test
    public void YouTubeHomePageandHistoryIconclick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the Guide button
        String guideButtonXpath = PropertiesFile.getProperty("guideButtonXpath");
        WebElement guideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(guideButtonXpath)));
        guideButton.click();
        Thread.sleep(3000);

        // Click on the History link
        String historyLinkXpath = PropertiesFile.getProperty("historyLinkXpath");
        driver.findElement(By.xpath(historyLinkXpath)).click();
        Thread.sleep(5000);

        // Get the history message
        String messageXpath = PropertiesFile.getProperty("historyMessageXpath");
        WebElement messageElement = driver.findElement(By.xpath(messageXpath));
        String actualText = messageElement.getText();
        String expectedText = PropertiesFile.getProperty("expectedHistoryMessage");

        // Assert
        Assert.assertEquals(actualText, expectedText, "The heading text is not as expected!");
    }
}
