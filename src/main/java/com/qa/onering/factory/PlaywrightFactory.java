package com.qa.onering.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class PlaywrightFactory {
    Properties prop;

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static  Browser getBrowser() {
        return tlBrowser.get();
    }
    public static BrowserContext getContext() {
        return tlContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    /**
     * this method is used to init the browser
     * @param prop
     * @return page
     */
    public Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        System.out.println("browser name is: " + browserName);

        //playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "chromium":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(tlPlaywright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(tlPlaywright.get().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                tlBrowser.set(tlPlaywright.get().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            case "safari":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(tlPlaywright.get().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            default:
                System.out.println("Please, user proper browser name!");
                break;
        }

        //context = browser.newContext();
        tlContext.set(tlBrowser.get().newContext());
        //page = context.newPage();
        tlPage.set(tlContext.get().newPage());
        //page.navigate(prop.getProperty("url").trim());
        getPage().navigate(prop.getProperty("url").trim());

        return getPage();
    }

    /**
     * this file is used to init
     * the properties from the config file
     */
    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }
}
