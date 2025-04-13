package org.testing.testScripts;

import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import URI.properties.PropertiesFile;
import org.testing.Base.Base;

public class TC4_likeLinkClick extends Base {

    @Test
    public void likeLinkClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on guide button
        String guideButtonXpath = PropertiesFile.getProperty("guideButtonXpath");
        WebElement guideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(guideButtonXpath)));
        guideButton.click();
        Thread.sleep(2000);

        // Click on News link
        String newsLinkXpath = PropertiesFile.getProperty("newsLinkXpath");
        driver.findElement(By.xpath(newsLinkXpath)).click();
        Thread.sleep(4000);

        // Click on first video
        String thumbnailXpath = PropertiesFile.getProperty("firstVideoThumbnailXpath");
        driver.findElement(By.xpath(thumbnailXpath)).click();

        // Wait and click the like button
        String likeButtonXpath = PropertiesFile.getProperty("likeButtonXpath");
        WebElement likedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(likeButtonXpath)));
        likedButton.click();

        // Assertion
        assertNotNull(likedButton, "The 'Like' button was not clicked successfully.");
    }
}
