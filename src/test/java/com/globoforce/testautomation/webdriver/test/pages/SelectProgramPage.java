package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectProgramPage extends BasePage {

    @Name("programButton")
    @FindBy(xpath = "//*[contains(text(), 'testclient5015 program')]")
    private Button programButton;

    public SelectProgramPage(WebDriver driver) {
        super(driver);
    }

    public SelectProgramPage setProgram() {
        waitElementToBeClickable(webdriver, programButton).click();
        return this;
    }
}


