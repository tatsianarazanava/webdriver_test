package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends BasePage {

    private static final String URL = "https://test-auto1-15.corp.globoforce.com/microsites/t/home?client=testclient5015&setCAG=true";

    @Name("username")
    @FindBy(name = "username")
    private TextInput usernamefield;

    @Name("password")
    @FindBy(name = "password")
    private TextInput passwordfield;

    @Name("signIn")
    @FindBy(id = "signIn-button")
    private Button signIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        getWebDriver().get(URL);
        return this;
    }

    public LoginPage setUsername(String usernameText) {
        usernamefield.sendKeys(usernameText);
        return this;
    }

    public LoginPage setPassword(String passwordText) {
        passwordfield.sendKeys(passwordText);
        return this;
    }

    public HomePage clickOnLoginButton() {
        signIn.click();
        return new HomePage(getWebDriver());
    }
}


