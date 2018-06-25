package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected final WebDriver webdriver;
    private static final int IMPLICITLY_WAIT_TIMEOUT = 10;

    protected BasePage(WebDriver driver) {
        this.webdriver = driver;
        this.webdriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
        HtmlElementLoader.populatePageObject(this, this.webdriver);
    }

    public WebDriver getWebDriver() {
        return this.webdriver;
    }
}
