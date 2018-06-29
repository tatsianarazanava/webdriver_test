package com.globoforce.testautomation.webdriver.test.test;

import com.globoforce.testautomation.webdriver.test.pages.*;
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
                .clickOnRecognize();
        new SelectRecipientPage(getWebDriver())
                .setRecipient(RECIPIENT_NAME);
        new SelectProgramPage(getWebDriver())
                .setProgram();
        new SelectReasonPage(getWebDriver())
                .setReason();
        new SelectAwardPage(getWebDriver())
                .setAwardValue();
        new AddDetailsAndSubmitPage(getWebDriver())
                .setAwardTitleInput(AWARD_TITLE)
                .setAwardMessageInput(AWARD_MESSAGE)
                .setAwardMessageForApproverInput(MESSAGE_FOR_APPROVAL)
                .sendAward()
        ;

        Assert.assertTrue(new ConfirmationPage(getWebDriver()).isNominationCompleted(),
                "Nomination was not completed. Please check the logs.");
    }
}





