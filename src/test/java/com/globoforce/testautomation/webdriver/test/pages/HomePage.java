package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class HomePage extends BasePage {

    @Name("recognizeButton")
    @FindBy(id = "giveAward-button")
    private Button recognizeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SelectRecipientPage clickOnRecognize() {
        waitElementToBeClickable(webdriver, recognizeButton).click();
        return new SelectRecipientPage(webdriver);
    }
}
