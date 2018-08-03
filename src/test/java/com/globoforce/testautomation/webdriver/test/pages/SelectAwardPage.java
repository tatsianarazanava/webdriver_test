package com.globoforce.testautomation.webdriver.test.pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectAwardPage extends BasePage {

    @Name("selectAwardButton")
    @FindBy(xpath = "//div[contains(@class, 'np-award-value-item')]")
    private List<HtmlElement> awardTypeButtonsList;

    public SelectAwardPage(WebDriver driver) {
        super(driver);
    }

    public HtmlElement getAwardTypeByName(String awardType) {
        HtmlElement targetAwardTypeButton = null;
        for (HtmlElement awardTypeButton : awardTypeButtonsList) {
            if (awardTypeButton.getAttribute("innerText").contains(awardType)){
                targetAwardTypeButton = awardTypeButton;
                break;
            }
        }
        return targetAwardTypeButton;
    }

    public AddDetailsAndSubmitPage setAwardType(String awardType) {
        waitElementToBeClickable(webdriver, getAwardTypeByName(awardType)).click();
        return new AddDetailsAndSubmitPage(webdriver);
    }
}
