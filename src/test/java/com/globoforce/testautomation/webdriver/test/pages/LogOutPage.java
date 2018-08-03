package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementIsDisplayed;
import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementIsNotVisible;
import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class LogOutPage extends BasePage {

    @Name("closeButton")
    @FindBy(xpath = "//*[contains(@class, 'js-np-close')]")
    private Button closeButton;

    @Name("nomanationElement")
    @FindBy(xpath = "//*[contains(@class, 'gf-drawer-overlay')]")
    private HtmlElement nomanationElement;

    @Name("logOutLink")
    @FindBy(xpath = "//*[contains(@href, 'logout')]")
    private Link logOutLink;

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public LogOutPage clickClose() {
        waitElementToBeClickable(webdriver, closeButton).click();
        waitElementIsNotVisible(webdriver, nomanationElement);
        return this;
    }

    public LogOutPage clickLogOut() {
        waitElementToBeClickable(webdriver, logOutLink).click();
        return this;
    }
}
