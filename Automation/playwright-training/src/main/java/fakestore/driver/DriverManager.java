package fakestore.driver;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Objects;

public class DriverManager {

    private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD_LOCAL = new ThreadLocal<>();

    public static BrowserType.LaunchOptions getLaunchOptions() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);
        options.setSlowMo(100);
        return options;
    }

    public static INewBrowserContext getDriver() {
        return getDriver(getLaunchOptions());
    }

    public static INewBrowserContext getDriver(BrowserType.LaunchOptions launchOptions) {
        if (Objects.isNull(BROWSER_CONTEXT_THREAD_LOCAL.get())) {
            PLAYWRIGHT_THREAD_LOCAL.set(Playwright.create());
            BrowserType browserType = (PLAYWRIGHT_THREAD_LOCAL.get()).chromium();
            NewBrowser browser = new NewBrowser(browserType.launch(launchOptions));
            BROWSER_CONTEXT_THREAD_LOCAL.set(browser.newContext());
        }
        return (INewBrowserContext) BROWSER_CONTEXT_THREAD_LOCAL.get();
    }
}
