package com.cecilgwilliams.users

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.environments.Environment
import com.cecilgwilliams.pages.PosLoginPage
import com.cecilgwilliams.pages.WebPage

public class DemoUser {

    private Environment env
    private Browser browser
    private WebPage currentPage
    private username = "demouser"
    private password = "openbravo"

    DemoUser(Browser browser, Environment environment) {
        this.browser = browser
        this.env = environment
    }

    public navigateToDemoSite() {
        currentPage = new WebPage(browser)
        currentPage.navigateTo(env.url)
    }

    public verifyMainWindow() {
        currentPage.verifyTextPresent("Welcome to Openbravo POS", 10)
    }

    public login() {
        currentPage = new PosLoginPage(currentPage).login(username, password)
    }
}