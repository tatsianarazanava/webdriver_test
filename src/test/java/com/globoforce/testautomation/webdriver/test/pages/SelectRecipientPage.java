package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementIsDisplayed;
import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectRecipientPage extends BasePage {

    @Name("searchField")
    @FindBy(id = "np-recipient-search-field")
    private TextInput searchField;

    @Name("addRecipientButton")
    @FindBy(xpath = "//button[@class='np-recipient-action']")
    private Button addRecipientButton;

    @Name("nextButton")
    @FindBy(xpath = "//*[contains(@class, 'js-np-next')]")
    private Button nextButton;

    public SelectRecipientPage(WebDriver driver) {
        super(driver);
    }

    public SelectRecipientPage setRecipient(String recipient) {
        waitElementIsDisplayed(webdriver, searchField).sendKeys(recipient);
        waitElementToBeClickable(webdriver, addRecipientButton).click();
        waitElementToBeClickable(webdriver, nextButton).click();
        return this;
    }
}
