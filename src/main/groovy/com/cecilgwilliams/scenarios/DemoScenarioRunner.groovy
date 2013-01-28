package com.cecilgwilliams.scenarios

public class DemoScenarioRunner extends ScenarioRunner {


    protected String convertToCodeBlock(String[] steps) {

        def sb = new StringBuffer()
        steps.each {
            sb.append("demoUser.${it}()")
            sb.append("\n")
        }

        def codeBlock =
            """
                import com.cecilgwilliams.browsers.Browser
                import com.cecilgwilliams.environments.Environment
                import com.cecilgwilliams.users.DemoUser

                { Browser browser, Environment environment ->
                    def demoUser = new DemoUser(browser, environment)
                    ${sb.toString()}
                    browser.quit()
                }

            """
        codeBlock
    }

}
