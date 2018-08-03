package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.globoforce.testautomation.webdriver.test.utils.WaitUtils.waitElementToBeClickable;

public class SelectProgramPage extends BasePage {

    @Name("selectProgramButton")
    @FindBy(xpath = "//div[contains(@class, 'np-award-program-default')]")
    private Button selectProgramButton;

    public SelectProgramPage(WebDriver driver) {
        super(driver);
    }

    public SelectReasonPage setProgram() {
        waitElementToBeClickable(webdriver, selectProgramButton).click();
        return new SelectReasonPage(webdriver);
    }
}


