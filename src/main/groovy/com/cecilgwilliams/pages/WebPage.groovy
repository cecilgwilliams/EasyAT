package com.cecilgwilliams.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

public class WebPage {

    @Delegate
    protected WebDriver driver

    public WebPage(WebDriver driver) {
        this.driver = driver
    }

    public WebPage(WebPage webPage) {
        this.driver = webPage.driver
    }

    WebElement findElementByLinkText(String linkText) {
        findElement(By.linkText(linkText))
    }

    WebElement findElementByPartialLinkText(String linkText) {
        findElement(By.partialLinkText(linkText))
    }

    WebElement findElementById(String id) {
        findElement(By.id(id))
    }

    WebElement findElementByValue(String value) {
        findElement(By.xpath("//*[@value='" + value + "']"))
    }

    WebElement findElementByName(String name) {
        findElement(By.xpath("//*[@name='" + name + "']"))
    }

    WebElement findElementByTitle(String title) {
        findElement(By.xpath("//*[@title='" + title + "']"))
    }

    WebElement findElementByLinkText(String linkText, int timeoutInSeconds) {
        findElementBy(By.linkText(linkText), timeoutInSeconds)
    }

    WebElement findElementById(String id, int timeoutInSeconds) {
        findElementBy(By.id(id), timeoutInSeconds)
    }

    WebElement findElementByValue(String value, int timeoutInSeconds) {
        findElementBy(By.xpath("//*[@value='" + value + "']"), timeoutInSeconds)
    }

    WebElement findElementByName(String name, int timeoutInSeconds) {
        findElementBy(By.xpath("//*[@name='" + name + "']"), timeoutInSeconds)
    }

    WebElement findElementByXpath(String xpath, int timeoutInSeconds) {
        findElementBy(By.xpath(xpath), timeoutInSeconds)
    }

    WebElement findElementByPartialLinkText(String linkText, int timeoutInSeconds) {
        findElementBy(By.partialLinkText(linkText), timeoutInSeconds)
    }

    private WebElement findElementBy(By by, int timeoutInSeconds) {
        WebElement webElement = (new WebDriverWait(driver, timeoutInSeconds))
                .until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(by)
            }
        })
        webElement
    }

    void verifyTextPresent(String textToFind) {
        if (!isPresent(textToFind)) {
            throw new Exception("Could not find text '$textToFind'")
        }
    }

    void verifyTextPresent(String textToFind, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(
                new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver d) {
                        return d.getPageSource().contains(textToFind)
                    }
                }
        )
    }

    void verifyTextNotPresent(String textNotToFind) {
        if (isPresent(textNotToFind)) {
            throw new Exception("Found text '$textNotToFind'")
        }
    }

    def isPresent(String text) {
        getPageSource().contains(text)
    }

    WebPage navigateTo(String url) {
        get url
        new WebPage(driver)
    }

}
