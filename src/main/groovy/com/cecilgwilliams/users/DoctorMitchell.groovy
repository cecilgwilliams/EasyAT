package com.cecilgwilliams.users

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.environments.Environment
import com.cecilgwilliams.pages.WebPage
import org.openqa.selenium.Keys

public class DoctorMitchell {

    private Environment env
    private Browser browser
    private WebPage currentPage

    DoctorMitchell(Browser browser, Environment environment) {
        this.browser = browser
        this.env = environment
        currentPage = new WebPage(browser)
    }

    public loginAsDoctor() {
       currentPage.findElementById("loginPhotoP_dmitchell").click()
        sleep(10000)
       currentPage.findElementById("Passworddmitchell_I").sendKeys(Keys.ENTER)
   }

    public viewTodaysVisits() {
       currentPage.findElementByXpath("//a[@href='/RWA/ClinicalStudy/DataCapture/Schedule']", 5).click()
   }

   public viewSubjectCE(){
       currentPage.findElementByLinkText("CE").click()
   }

}
