package com.cecilgwilliams.users

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.environments.Environment
import com.cecilgwilliams.pages.WebPage
import org.openqa.selenium.Keys

public class SupervisorOliver {

    private Environment env
    private Browser browser
    private WebPage currentPage

    SupervisorOliver(Browser browser, Environment environment) {
        this.browser = browser
        this.env = environment
        currentPage = new WebPage(browser)
    }

    public loginAsSupervisor() {
       currentPage.findElementById("loginPhotoP_moliver").click()
        sleep(10000)
       currentPage.findElementById("Passwordmoliver_I").sendKeys(Keys.ENTER)
   }

    public viewPatientsReport() {
       currentPage.findElementByXpath("//a[@href='/RWA/ClinicalStudy/Analytics/Charts/PatientsPerVisit']", 5).click()
   }

}
