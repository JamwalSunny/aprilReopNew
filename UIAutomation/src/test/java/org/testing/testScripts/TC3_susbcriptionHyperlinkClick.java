package org.testing.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import URI.properties.PropertiesFile;
import org.testing.Base.Base;

public class TC3_susbcriptionHyperlinkClick extends Base {

    @Test
    public void subscriptionHyperlinkClick() {
        // Get XPath from config.properties
        String subscriptionXpath = PropertiesFile.getProperty("subscriptionLinkXpath");

        // Click on the Subscriptions link
        WebElement subscriptionLink = driver.findElement(By.xpath(subscriptionXpath));
        subscriptionLink.click();
    }
}
