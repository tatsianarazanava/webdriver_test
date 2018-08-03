package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementIsDisplayed;
import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectRecipientPage extends BasePage {

    @Name("recipientSearchField")
    @FindBy(id = "np-recipient-search-field")
    private TextInput recipientSearchField;

    @Name("searchResultText")
    @FindBy(xpath = "//p[contains(@class, 'np-recipient-list-name')]")
    private TextBlock searchResultText;

    @Name("addRecipientButton")
    @FindBy(xpath = "//button[@class='np-recipient-action']")
    private Button addRecipientButton;

    @Name("nextButton")
    @FindBy(xpath = "//*[contains(@class, 'js-np-next')]")
    private Button nextButton;

    public SelectRecipientPage(WebDriver driver) {
        super(driver);
    }

    public SelectProgramPage setRecipient(String recipient) {
        waitElementIsDisplayed(webdriver, recipientSearchField).sendKeys(recipient);
        waitElementIsDisplayed(webdriver, searchResultText);
        waitElementToBeClickable(webdriver, addRecipientButton).click();
        waitElementToBeClickable(webdriver, nextButton).click();
        return new SelectProgramPage(webdriver);
    }
}
