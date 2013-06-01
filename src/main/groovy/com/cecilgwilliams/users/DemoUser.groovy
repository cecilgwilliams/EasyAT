package com.cecilgwilliams.users

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.environments.Environment
import com.cecilgwilliams.pages.WebPage

public class DemoUser {

    private Environment env
    private Browser browser
    private WebPage currentPage

    @Delegate
    private DoctorMitchell doctor
    @Delegate
    private SupervisorOliver supervisor

    DemoUser(Browser browser, Environment env) {
        this.browser = browser
        this.env = env
        doctor = new DoctorMitchell(browser, env)
        supervisor = new SupervisorOliver(browser, env)
    }

    public navigateToDemoSite() {
        currentPage = new WebPage(browser)
        currentPage.navigateTo(env.url)
    }

    public logout(){
        currentPage.findElementById("btnLogout_CD").click()
    }

    public closeBrowser(){
        browser.quit()
    }

    public sleep(){
        sleep(10000)
    }
}
