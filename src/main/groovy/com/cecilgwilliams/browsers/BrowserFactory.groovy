package com.cecilgwilliams.browsers

public class BrowserFactory {

    def static browsers = [:]

    public static Browser getFirefox() {
        def browser = browsers.get "Firefox"
        if (browser == null) {
            browser = new Firefox()
            browsers.put "Firefox", browser
        }
        browser
    }

    public static Browser getChrome() {
        def browser = browsers.get "Chrome"
        if (browser == null) {
            browser = new Chrome()
            browsers.put "Chrome", browser
        }
        browser
    }

    public static void killAll() {
        browsers.each { it.value.quit() }
    }
}
