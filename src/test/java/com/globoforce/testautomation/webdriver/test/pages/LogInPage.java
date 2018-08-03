package com.globoforce.testautomation.webdriver.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LogInPage extends BasePage {

    private static final String URL = "https://%s/microsites/t/home?client=%s&setCAG=true";

    @Name("username")
    @FindBy(name = "username")
    private TextInput usernameField;

    @Name("password")
    @FindBy(name = "password")
    private TextInput passwordField;

    @Name("signInButton")
    @FindBy(id = "signIn-button")
    private Button signInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage open(String server, String clientName) {
        getWebDriver().get(String.format(URL, server, clientName));
        return this;
    }

    public LogInPage setUsername(String usernameText) {
        usernameField.sendKeys(usernameText);
        return this;
    }

    public LogInPage setPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
        return this;
    }

    public HomePage clickLoginButton() {
        signInButton.click();
        return new HomePage(getWebDriver());
    }
}

