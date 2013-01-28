package com.cecilgwilliams.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

public class PosLoginPage extends WebPage {

    public PosLoginPage(WebDriver driver) {
        super(driver)
    }

    public WebPage login(String username, String password) {
        WebElement usernameElement = findElementById("terminal_containerWindow_login_username", 5)
        usernameElement.sendKeys username
        WebElement passwordElement = findElementById("terminal_containerWindow_login_password", 1)
        passwordElement.sendKeys password
        findElementById("loginaction").click()
        new WebPage(driver)
    }
}
