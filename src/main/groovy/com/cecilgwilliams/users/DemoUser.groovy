package com.cecilgwilliams.users

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.environments.Environment
import com.cecilgwilliams.pages.WebPage
import org.openqa.selenium.Keys

public class DemoUser {

    private Environment env
    private Browser browser
    private WebPage currentPage

    DemoUser(Browser browser, Environment environment) {
        this.browser = browser
        this.env = environment
    }

    public navigateToDemoSite() {
        currentPage = new WebPage(browser)
        currentPage.navigateTo(env.url)
    }

     public loginAsDoctor() {
        currentPage.findElementById("loginPhotoP_dmitchell").click()
         sleep(1000)
        currentPage.findElementById("Passworddmitchell_I").sendKeys(Keys.ENTER)
    }
}
