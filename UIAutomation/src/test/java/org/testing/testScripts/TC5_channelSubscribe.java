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

public class TC5_channelSubscribe extends Base {

    @Test
    public void channelSubscribe() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Guide button
        String guideButtonXpath = PropertiesFile.getProperty("guideButtonXpath");
        WebElement guideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(guideButtonXpath)));
        guideButton.click();

        // Click News menu
        String newsMenuXpath = PropertiesFile.getProperty("newsMenuXpath");
        driver.findElement(By.xpath(newsMenuXpath)).click();
        Thread.sleep(4000);

        // Click on a video
        String videoLinkXpath = PropertiesFile.getProperty("videoLinkXpath");
        WebElement videoElement = driver.findElement(By.xpath(videoLinkXpath));
        videoElement.click();
        Thread.sleep(2000);

        // Click Subscribe button
        String subscribeBtnCss = PropertiesFile.getProperty("subscribeButtonCss");
        WebElement subscribeBtn = driver.findElement(By.cssSelector(subscribeBtnCss));
        subscribeBtn.click();

        // Validate toast message
        String toastMsgCss = PropertiesFile.getProperty("subscribeToastMessageCss");
        WebElement toastMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(toastMsgCss)));
        String actualText = toastMsg.getText();
        System.out.println("Toast Message: " + actualText);

        String expectedText = PropertiesFile.getProperty("expectedSubscribeToast");
        Assert.assertEquals(actualText.trim(), expectedText, "Toast message is not as expected.");
    }
}
