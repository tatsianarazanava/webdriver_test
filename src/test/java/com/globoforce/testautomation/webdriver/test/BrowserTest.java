package com.globoforce.testautomation.webdriver.test;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BrowserTest {
    private WebDriver driver;
    //private static final String URL = "https://staging-web1.corp.globoforce.com/microsites/t/home?client=testclient5015";
    private static final String URL = "https://test-auto2-15.corp.globoforce.com/microsites/t/home?client=testclient5015&setCAG=true";
    private String userName = "norma_nominator";
    //private String password = "password1";
    private String password = "norma_nominator1";
    private String recipient = "Adam Admin";
    private String awardTitle = "Test award title";
    private String awardMessage = "Test award message";
    private String messageForApproval = "Test award message for approval";
    private static final int implicitTimeout = 15;
    private JavascriptExecutor jsExecutor;

    @BeforeClass
    public void startDriver() {
        String driverName = System.getProperty("webdriver.browser");
        System.out.println("Browser in use: " + driverName);
        System.setProperty("webdriver." + driverName + ".driver", "src/test/resources/" + driverName + "driver.exe");

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

        //set default timeout = 15 sec
        driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        //to maximize browser window
        //driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
    }


    @Test(priority = 1)
    public void verifyLogin() {
        driver.navigate().to(String.format(URL));
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("signIn-button")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='relative']//*[contains(text(), 'Norma Nominator')]")).size() > 0, "Login failed");
    }

    @Test(priority = 2)
    public void verifyNomination() {

        driver.findElement(By.id("giveAward-button")).click();

        //set timeout = 30 sec
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement search = waitElementToBeClickable(By.id("np-recipient-search-field"));
        search.sendKeys(recipient);
        WebElement user = waitElementToBeClickable(By.xpath("//button[@class='np-recipient-action']"));
        user.click();
        driver.findElement(By.xpath("//*[contains(@class, 'js-np-next')]")).click();
        WebElement program = waitElementToBeClickable(By.xpath("//*[contains(text(), 'testclient5015 program')]"));
        program.click();
        WebElement reason = waitElementToBeClickable(By.xpath("//*[contains(@title, 'REASON2')]"));
        reason.click();
        WebElement award = waitElementToBeClickable(By.id("awardType-74103"));
        award.click();
        //set timeout to default value = 15 sec
        //driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        WebElement awtitle = waitElementToBeClickable(By.id("np_awardTitle"));
        awtitle.sendKeys(awardTitle);
        WebElement awmessage = waitElementToBeClickable(By.id("np_awardMessage"));
        awmessage.sendKeys(awardMessage);
        WebElement awapmessage = waitElementToBeClickable(By.id("np_messageForApproval"));
        awapmessage.sendKeys(messageForApproval);
        WebElement sendbutton = waitElementToBeClickable(By.xpath("//*[contains(@class, 'send-award')]"));
        sendbutton.click();

        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(@class, 'confirmation-close')]")).size() > 0, "Nomination failed.");

        //to highlight element
        //jsExecutor.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//*[@class='np-confirmation-holder']")));

    }

    private WebElement waitElementToBeClickable(By by) {
        return new WebDriverWait(driver, 60)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(by));
    }


    //exit browser
    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

}