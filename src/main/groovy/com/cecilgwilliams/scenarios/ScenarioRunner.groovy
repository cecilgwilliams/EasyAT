package com.cecilgwilliams.scenarios

import com.cecilgwilliams.browsers.Browser
import com.cecilgwilliams.environments.Environment


public abstract class ScenarioRunner {

    public run(String scenario, Browser browser, Environment env) {
        def closureToRun = createClosureFor scenario
        executeClosure closureToRun, browser, env
    }

    private void executeClosure(Closure closureToRun, Browser browser, Environment env) {
        closureToRun browser, env
    }

    private Closure createClosureFor(String scenario) {
        def steps = parse scenario
        def codeBlock = convertToCodeBlock steps
        def gshel = new GroovyShell()
        gshel.evaluate codeBlock
    }

    private String[] parse(xmlName) {
        def steps = []
        URL url = Thread.currentThread().getContextClassLoader().getResource(xmlName + ".xml");
        def scenario = new XmlSlurper().parse(url.openStream());
        scenario.childNodes().each {
            steps << it.text()
        }
        steps
    }

    protected abstract String convertToCodeBlock(String[] steps)
}
