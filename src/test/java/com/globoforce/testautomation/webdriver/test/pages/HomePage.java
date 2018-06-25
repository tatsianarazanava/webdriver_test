package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.time.Duration;
import java.util.NoSuchElementException;

public class HomePage extends BasePage {

    @Name("recognizeButton")
    @FindBy(id = "giveAward-button")
    private Button recognize;

    @Name("searchField")
    @FindBy(id = "np-recipient-search-field")
    private TextInput searchfield;

    @Name("recipientResult")
    @FindBy(xpath = "//p[contains(@class, 'np-recipient-list-name')]")
    private HtmlElement recipientResult;

    @Name("recipientName")
    @FindBy(xpath = "//button[@class='np-recipient-action']")
    private Button recipientName;

    @Name("next")
    @FindBy(xpath = "//*[contains(@class, 'js-np-next')]")
    private Button next;

    @Name("program")
    @FindBy(xpath = "//*[contains(text(), 'testclient5015 program')]")
    private Button program;

    @Name("reason")
    @FindBy(xpath = "//*[contains(@title, 'REASON2')]")
    private HtmlElement reason;

    @Name("award")
    @FindBy(id = "awardType-74103")
    private HtmlElement award;

    @Name("awardTitle")
    @FindBy(id = "np_awardTitle")
    private TextInput awardTitle;

    @Name("awardMessage")
    @FindBy(id = "np_awardMessage")
    private TextInput awardMessage;

    @Name("awardMessage2")
    @FindBy(id = "np_messageForApproval")
    private TextInput awardMessage2;

    @Name("sendButton")
    @FindBy(xpath = "//*[contains(@class, 'send-award')]")
    private Button send;

    @Name("closeButton")
    @FindBy(xpath = "//*[contains(@class, 'confirmation-close')]")
    private Button close;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnRecognize() {
        recognize.click();
        return this;
    }

    public WebElement waitElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(webdriver, 60)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public HomePage setRecipient(String recipient) {
        waitElementToBeClickable(searchfield);
        searchfield.sendKeys(recipient);
        waitElementToBeClickable(recipientResult);
        waitElementToBeClickable(recipientName);
        recipientName.click();
        waitElementToBeClickable(next);
        next.click();
        return this;
    }

    public HomePage setProgram() {
        waitElementToBeClickable(program);
        program.click();
        return this;
    }

    public HomePage setReason() {
        waitElementToBeClickable(reason);
        reason.click();
        return this;
    }

    public HomePage setAwardValue() {
        waitElementToBeClickable(award);
        award.click();
        return this;
    }

    public HomePage setAwardTitle(String awardTitleText) {
        waitElementToBeClickable(awardTitle);
        awardTitle.sendKeys(awardTitleText);
        return this;
    }

    public HomePage setAwardMessage(String awardMessageText) {
        waitElementToBeClickable(awardMessage);
        awardMessage.sendKeys(awardMessageText);
        return this;
    }

    public HomePage setAwardMessage2(String awardMessageText2) {
        waitElementToBeClickable(awardMessage2);
        awardMessage2.sendKeys(awardMessageText2);
        return this;
    }

    public HomePage sendAward() {
        waitElementToBeClickable(send);
        send.click();
        return this;
    }

    public boolean isNominationCompleted() {
        waitElementToBeClickable(close);
        return isNominationCompleted();
    }
}
