package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectAwardPage extends BasePage {

    @Name("awardButton")
    @FindBy(id = "awardType-74103")
    private HtmlElement awardButton;

    public SelectAwardPage(WebDriver driver) {
        super(driver);
    }

    public SelectAwardPage setAwardValue() {
        waitElementToBeClickable(webdriver, awardButton).click();
        return this;
    }
}
