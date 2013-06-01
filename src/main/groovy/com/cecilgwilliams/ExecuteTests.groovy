package com.cecilgwilliams

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.browsers.BrowserFactory
import com.cecilgwilliams.environments.EnvironmentFactory
import com.cecilgwilliams.scenarios.DemoScenarioRunner

try {
    def demoEnv = EnvironmentFactory.getDemo()
    def runner = new DemoScenarioRunner()
    runner.run "scenarios/demo/viewPatientFromSchedule", getBrowser(), demoEnv
    runner.run "scenarios/demo/viewPatientsReport", getBrowser(), demoEnv

} catch (Exception e) {
    println e.message
} finally {
    BrowserFactory.killAll()
}

private Browser getBrowser() {
//    def chrome = BrowserFactory.getChrome()
//    chrome.manage().window().maximize()
//    new DemoScenarioRunner().run "scenarios/demo/demoScenario", chrome, demoEnv

    def firefox = BrowserFactory.getFirefox()
    firefox.manage().window().maximize()
    firefox
}



