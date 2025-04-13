package org.testing.testScripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testing.Base.Base;
import URI.properties.PropertiesFile;

public class TC6_videoPlayComment extends Base {

    @Test
    public void commentVideo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Guide button
        String guideButtonXpath = PropertiesFile.getProperty("guideButtonXpath");
        WebElement guideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(guideButtonXpath)));
        guideButton.click();
        Thread.sleep(2000);

        // Click News menu
        String newsLinkXpath = PropertiesFile.getProperty("newsMenuXpath");
        driver.findElement(By.xpath(newsLinkXpath)).click();
        Thread.sleep(4000);

        // Click a video
        String videoLinkXpath = PropertiesFile.getProperty("videoLinkXpath");
        WebElement videoElement = driver.findElement(By.xpath(videoLinkXpath));
        videoElement.click();
        Thread.sleep(5000);

        // Scroll down to comment section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(3000);

        // Click comment box
        String commentBoxXpath = PropertiesFile.getProperty("commentBoxXpath");
        WebElement commentBox = driver.findElement(By.xpath(commentBoxXpath));
        commentBox.click();
        Thread.sleep(6000);

        // Enter comment
        String expectedComment = PropertiesFile.getProperty("expectedComment");
        commentBox.sendKeys(expectedComment);

        String actualText = commentBox.getAttribute("textContent");
        System.out.println("Entered Comment: " + actualText);
        Assert.assertEquals(actualText.trim(), expectedComment, "Comment text does not match expected.");
    }
}
