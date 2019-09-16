package com.mulberrybeacon.automation;

import java.lang.RuntimeException;

import org.apache.commons.lang3.SystemUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.After;
import org.junit.Before;

import com.mulberrybeacon.automation.OperatingSystem;

/**
 * Super test.
 */
public class SuperTest {

    protected WebDriver driver;

    @Before
    public void setup() {
        String location = getDriverLocation();
        if (location.isEmpty()) {
            throw new RuntimeException("Operating system is unsupported.");
        }

        String path = String.format("src/main/resources/chromedriver/%s/chromedriver", location);
        System.setProperty("webdriver.chrome.driver", path);

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");  // Run in headless mode, i.e., without a UI or display server dependencies.

        driver = new ChromeDriver(options);
    }

    @After
    public void teardown() {
        driver.close();
    }

    /**
     * Gets the location of the appropriate Chrome Web Driver for the operating system where the project is running.
     * 
     * @return The driver location
     */
    private String getDriverLocation() {
        OperatingSystem location = OperatingSystem.UNSUPPORTED;

        if (SystemUtils.IS_OS_WINDOWS) {
            location = OperatingSystem.WINDOWS;
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            location = OperatingSystem.MACOS;
        } else if (SystemUtils.IS_OS_LINUX) {
            location = OperatingSystem.LINUX;
        }

        return location.getDirectory();
    }
}
