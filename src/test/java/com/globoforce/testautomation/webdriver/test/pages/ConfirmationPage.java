package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementIsDisplayed;

public class ConfirmationPage extends BasePage {

    @Name("confirmationMessage")
    @FindBy(xpath = "//*[@class='np-confirmation-message']")
    private TextInput confirmationMessage;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNominationCompleted() {
        return waitElementIsDisplayed(webdriver, confirmationMessage).isDisplayed();
    }
}