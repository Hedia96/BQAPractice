package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Playwright playwright = Playwright.create();
//        Browser browser = playwright.firefox().launch();
//        Browser browser = playwright.chromium().launch();
        Browser browser =playwright.chromium().
                launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        System.out.println(browser.version());
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.close();
        browser.close();
        playwright.close();
//
    }
}