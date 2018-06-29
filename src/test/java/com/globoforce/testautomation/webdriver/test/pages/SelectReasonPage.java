package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectReasonPage extends BasePage {

    @Name("reasonButton")
    @FindBy(xpath = "//*[contains(@title, 'REASON2')]")
    private HtmlElement reasonButton;

    public SelectReasonPage(WebDriver driver) {
        super(driver);
    }

    public SelectReasonPage setReason() {
        waitElementToBeClickable(webdriver, reasonButton).click();
        return this;
    }
}

