package com.cecilgwilliams.browsers

import org.openqa.selenium.WebDriver


public interface Browser extends WebDriver {

    String name
    long delay
}