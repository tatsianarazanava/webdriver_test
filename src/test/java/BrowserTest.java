import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BrowserTest {

    private WebDriver driver;

    @Test
    public void testBrowser() {
        String val = System.getProperty("webdriver.browser");
        System.out.println("Browser in use: " + val);
        System.setProperty("webdriver." + val + ".driver", "src/test/resources/" + val + "driver");

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

        driver.navigate().to("http://google.com");
    }

}
