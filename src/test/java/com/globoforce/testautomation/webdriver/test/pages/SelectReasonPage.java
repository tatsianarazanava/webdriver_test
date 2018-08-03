package com.globoforce.testautomation.webdriver.test.pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectReasonPage extends BasePage {

    @Name("reasonButton")
    @FindBy(xpath = "//div[contains(@class, 'np-award-reason-item')]")
    private List<HtmlElement> reasonButtonsList;

    public SelectReasonPage(WebDriver driver) {
        super(driver);
    }

    public HtmlElement getReasonByName(String reasonName) {
        HtmlElement targetReasonButton = null;
        for (HtmlElement reasonButton : reasonButtonsList) {
            if (StringUtils.deleteWhitespace(reasonButton.getAttribute("innerText")).equals(reasonName)) {
                targetReasonButton = reasonButton;
                break;
            }
        }
        return targetReasonButton;
    }

    public SelectAwardPage setReason(String reasonName) {
        waitElementToBeClickable(webdriver, getReasonByName(reasonName)).click();
        return new SelectAwardPage(webdriver);
    }
}

