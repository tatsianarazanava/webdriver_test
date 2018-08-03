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
    private static final String SERVER = "test-auto2-15.corp.globoforce.com";
    private static final String CLIENT_NAME = "testclient5015";
    private static final String REASON = "REASON2";
    private static final String AWARD_TYPE = "Award2";


    @Test
    public void verifyLogin() {
        new LogInPage(getWebDriver())
                .open(SERVER, CLIENT_NAME)
                .setUsername(USERNAME_TEXT)
                .setPassword(PASSWORD_TEXT)
                .clickLoginButton();
    }

    @Test(dependsOnMethods = "verifyLogin")
    public void verifyNomination() {
        new HomePage(getWebDriver())
                .clickOnRecognize()
                .setRecipient(RECIPIENT_NAME)
                .setProgram()
                .setReason(REASON)
                .setAwardType(AWARD_TYPE)
                .setAwardTitleInput(AWARD_TITLE)
                .setAwardMessageInput(AWARD_MESSAGE)
                .setAwardMessageForApproverInput(MESSAGE_FOR_APPROVAL)
                .sendAward();
        Assert.assertTrue(new ConfirmationPage(getWebDriver()).isNominationCompleted(),
                "Nomination was not completed. Please check the logs.");
    }
}





