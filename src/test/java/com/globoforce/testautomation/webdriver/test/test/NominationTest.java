package com.globoforce.testautomation.webdriver.test.test;

import com.globoforce.testautomation.webdriver.test.pages.HomePage;
import com.globoforce.testautomation.webdriver.test.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NominationTest extends BaseTest {

    private static final String USERNAME_TEXT = "norma_nominator";
    private static final String PASSWORD_TEXT = "norma_nominator1";
    private static final String RECIPIENT_NAME = "Adam Admin";
    private static final String AWARD_TITLE = "Test award title";
    private static final String AWARD_MESSAGE = "Test award message";
    private static final String MESSAGE_FOR_APPROVAL = "Test award message for approval";

    @Test
    public void verifyLogin() {
        new LoginPage(getWebDriver())
                .open()
                .setUsername(USERNAME_TEXT)
                .setPassword(PASSWORD_TEXT)
                .clickOnLoginButton();
    }

    @Test(dependsOnMethods = "verifyLogin")
    public void verifyNomination() {
        new HomePage(getWebDriver())
                .clickOnRecognize()
                .setRecipient(RECIPIENT_NAME)
                .setProgram()
                .setReason()
                .setAwardValue()
                .setAwardTitle(AWARD_TITLE)
                .setAwardMessage(AWARD_MESSAGE)
                .setAwardMessage2(MESSAGE_FOR_APPROVAL)
                .sendAward();

//        Assert.assertFalse(new HomePage(getWebDriver()).isNominationCompleted(),
//                "Nomination was not completed. Please check the logs.");
    }
}


