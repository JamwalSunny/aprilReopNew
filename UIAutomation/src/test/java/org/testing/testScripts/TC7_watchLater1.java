package org.testing.testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import URI.properties.PropertiesFile;
import org.testing.Base.Base;

public class TC7_watchLater1 extends Base {

    @Test
    public void watchToastMessage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Guide button
        String guideButtonXpath = PropertiesFile.getProperty("guideButtonXpath");
        WebElement guideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(guideButtonXpath)));
        guideButton.click();
        Thread.sleep(4000);

        // Click News menu
        String newsMenuXpath = PropertiesFile.getProperty("newsMenuXpath");
        WebElement newsMenu = driver.findElement(By.xpath(newsMenuXpath));
        newsMenu.click();
        Thread.sleep(4000);

        // Hover over the video label and click
        String videoLabelXpath = PropertiesFile.getProperty("videoLabelXpath");
        WebElement videoElement = driver.findElement(By.xpath(videoLabelXpath));
        Actions action = new Actions(driver);
        action.moveToElement(videoElement).perform();
        Thread.sleep(2000);
        videoElement.click();

        // Wait for and verify toast message
        String toastCssSelector = PropertiesFile.getProperty("toastMessageCss");
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(toastCssSelector)));
        String actualMessage = toastMessage.getText();

        String expectedMessage = PropertiesFile.getProperty("expectedToastMessage");
        System.out.println("Toast Message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Toast message is not as expected!");
    }
}
