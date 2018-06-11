import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BrowserTest {
    private WebDriver driver;

    private static final String URL = "https://test-auto2-15.corp.globoforce.com/microsites/t/home?client=testclient5015&setCAG=true";
    private String userName = "norma_nominator";
    private String password = "norma_nominator1";
    private String recipient = "Adam Admin";

    @BeforeClass
    public void startDriver() {
        String val = System.getProperty("webdriver.browser");
        System.out.println("Browser in use: " + val);
        System.setProperty("webdriver." + val + ".driver", "src/test/resources/" + val + "driver.exe");

        switch (val) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "gecko":
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Invalid webdriver: " + val);
                break;
        }
    }

    @Test
    public void verifyLogin() {
        driver.navigate().to(String.format(URL));
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("signIn-button")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='relative']//*[contains(text(), 'Norma Nominator')]")).size() > 0, "Login failed");
    }

    @Test
    public void verifyNomination(){
        driver.findElement(By.id("giveAward-button")).click();
        driver.findElement(By.id("np-recipient-search-field")).sendKeys(recipient);
        //driver.findElement(By.xpath("//*[@id=\"np-recipient-search-field\"]")).isEnabled();

    }


//    @AfterClass(alwaysRun = true)
//    public void closeDriver() {
//        if (driver != null)
//            driver.quit();
//    }


}

