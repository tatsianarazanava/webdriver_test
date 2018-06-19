package com.globoforce.testautomation.webdriver.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BrowserTest {

    private WebDriver driver;
    private static final String URL = "https://test-auto1-15.corp.globoforce.com/microsites/t/home?client=testclient5015&setCAG=true";
    private static final String USER_NAME = "norma_nominator";
    private static final String PASSWORD = "norma_nominator1";
    private static final String RECIPIENT = "Adam Admin";
    private static final String AWARD_TITLE = "Test award title";
    private static final String AWARD_MESSAGE = "Test award message";
    private static final String MESSAGE_FOR_APPROVAL = "Test award message for approval";
    private static final int IMPLICIT_TIMEOUT = 15;

    @BeforeClass
    public void startDriver() {
        String driverName = System.getProperty("webdriver.browser");
        System.out.println("Browser in use: " + driverName);
        System.setProperty("webdriver." + driverName + ".driver", "src/test/resources/drivers/" + driverName + "driver.exe");
        switch (driverName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "gecko":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                Assert.fail("Invalid webdriver: " + driverName);
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void verifyLogin() {
        driver.navigate().to(URL);
        driver.findElement(By.name("username")).sendKeys(USER_NAME);
        driver.findElement(By.name("PASSWORD")).sendKeys(PASSWORD);
        driver.findElement(By.id("signIn-button")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='relative']//*[contains(text(), 'Norma Nominator')]")).size() > 0,
                "Login failed:");
    }

    @Test(dependsOnMethods = "verifyLogin")
    public void verifyNomination() {
        driver.findElement(By.id("giveAward-button")).click();
        //set timeout = 30 sec
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitElementToBeClickable(By.id("np-RECIPIENT-search-field")).sendKeys(RECIPIENT);
        waitElementIsVisible(By.xpath("//p[contains(@class, 'np-RECIPIENT-list-name')]"));
        waitElementToBeClickable(By.xpath("//button[@class='np-RECIPIENT-action']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'js-np-next')]")).click();
        waitElementToBeClickable(By.xpath("//*[contains(text(), 'testclient5015 program')]")).click();
        waitElementToBeClickable(By.xpath("//*[contains(@title, 'REASON2')]")).click();
        waitElementToBeClickable(By.id("awardType-74103")).click();
        waitElementToBeClickable(By.id("np_awardTitle")).sendKeys(AWARD_TITLE);
        waitElementToBeClickable(By.id("np_awardMessage")).sendKeys(AWARD_MESSAGE);
        waitElementToBeClickable(By.id("np_messageForApproval")).sendKeys(MESSAGE_FOR_APPROVAL);
        waitElementToBeClickable(By.xpath("//*[contains(@class, 'send-award')]")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(@class, 'confirmation-close')]")).size() > 0,
                "Nomination failed.");
    }

    private WebElement waitElementToBeClickable(By by) {
        return new WebDriverWait(driver, 60)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement waitElementIsVisible(By by) {
        return new WebDriverWait(driver, 60)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @AfterClass(alwaysRun = true)
    public void logout() {
    }

    @AfterClass(dependsOnMethods = "logout",
            alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }
}
