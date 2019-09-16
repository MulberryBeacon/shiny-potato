package com.mulberrybeacon.automation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Test;

/**
 * Test for the landing page.
 */
public class LandingPageTest extends SuperTest {
    
    @Test
    public void testLandingPage() {

        // Opens the main page
        driver.get(Environment.PRODUCTION.getUrl());
        new WebDriverWait(driver, 30)
            .until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(Locators.DUMMY_LOCATOR_HEADER),
                ExpectedConditions.visibilityOfElementLocated(Locators.DUMMY_LOCATOR_FOOTER)
            ));
    }
}
