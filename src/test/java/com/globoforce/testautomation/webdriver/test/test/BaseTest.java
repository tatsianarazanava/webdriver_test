package com.globoforce.testautomation.webdriver.test.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver webdriver;
    private static final int IMPLICIT_TIMEOUT = 10;

    @BeforeClass
    public void startDriver() {
        String driverName = System.getProperty("webdriver.browser");
        System.out.println("Browser in use: " + driverName);
        System.setProperty("webdriver." + driverName + ".driver", "src/test/resources/drivers/" + driverName + "driver.exe");

        switch (driverName) {
            case "chrome":
                webdriver = new ChromeDriver();
                break;
            case "gecko":
                webdriver = new FirefoxDriver();
                break;
            case "edge":
                webdriver = new EdgeDriver();
                break;
            default:
                Assert.fail("Invalid webdriver: " + driverName);
                break;
        }

        webdriver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        webdriver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        webdriver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (webdriver != null) {
            webdriver.quit();
        }
        webdriver = null;
    }

//    @AfterClass
//    LogOutPage

    protected WebDriver getWebDriver() {
        return this.webdriver;
    }
}
