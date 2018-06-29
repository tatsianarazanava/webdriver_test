package com.globoforce.testautomation.webdriver.test.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitUtils {

    public static WebElement waitElementToBeClickable(WebDriver webdriver, WebElement webElement) {
        return new WebDriverWait(webdriver, 60)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitElementIsDisplayed(WebDriver webdriver, WebElement webElement) {
        return new WebDriverWait(webdriver, 60)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
