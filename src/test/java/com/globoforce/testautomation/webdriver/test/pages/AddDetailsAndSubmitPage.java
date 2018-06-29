package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementIsDisplayed;
import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class AddDetailsAndSubmitPage extends BasePage {

    @Name("awardTitleInput")
    @FindBy(id = "np_awardTitle")
    private TextInput awardTitleInput;

    @Name("awardMessageInput")
    @FindBy(id = "np_awardMessage")
    private TextInput awardMessageInput;

    @Name("awardMessageForApproverInput")
    @FindBy(id = "np_messageForApproval")
    private TextInput awardMessageForApproverInput;

    @Name("sendAwardButton")
    @FindBy(xpath = "//*[contains(@class, 'send-award')]")
    private Button sendAwardButton;

    public AddDetailsAndSubmitPage(WebDriver driver) {
        super(driver);
    }

    public AddDetailsAndSubmitPage setAwardTitleInput(String awardTitleText) {
        waitElementIsDisplayed(webdriver, awardTitleInput).sendKeys(awardTitleText);
        return this;
    }

    public AddDetailsAndSubmitPage setAwardMessageInput(String awardMessageText) {
        waitElementIsDisplayed(webdriver, awardMessageInput).sendKeys(awardMessageText);
        return this;
    }

    public AddDetailsAndSubmitPage setAwardMessageForApproverInput(String awardMessageForApproverText) {
        waitElementIsDisplayed(webdriver, awardMessageForApproverInput).sendKeys(awardMessageForApproverText);
        return this;
    }

    public AddDetailsAndSubmitPage sendAward() {
        waitElementToBeClickable(webdriver, sendAwardButton).click();
        return this;
    }
}
