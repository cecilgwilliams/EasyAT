package com.cecilgwilliams

import com.cecilgwilliams.browsers.BrowserFactory
import com.cecilgwilliams.environments.EnvironmentFactory
import com.cecilgwilliams.scenarios.DemoScenarioRunner

try {
    def demoEnv = EnvironmentFactory.getDemo()

    def chrome = BrowserFactory.getChrome()
    chrome.manage().window().maximize();
    new DemoScenarioRunner().run "scenarios/demo/posScenario", chrome, demoEnv

//    def firefox = BrowserFactory.getFirefox()
//    new DemoScenarioRunner().run "scenarios/demo/posScenario", firefox, demoEnv

} catch (Exception e) {
    BrowserFactory.killAll()
}



