package fakestore.actions;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import fakestore.driver.DriverManager;
import fakestore.driver.INewBrowserContext;

import java.util.Objects;

public class Actions {

    private static DriverManager driverManager = null;
    public FrameLocator frameLocator;

    public static INewBrowserContext getDriver() {
        if (Objects.isNull(driverManager)) {
            driverManager = new DriverManager();
        }

        return DriverManager.getDriver();
    }

    public void loadUrl(String url) {
        getDriver().currentPage().navigate(url);
        getDriver().currentPage().waitForLoadState(LoadState.LOAD);
    }

    public String getUrl() {
        return getDriver().currentPage().url();
    }

    public Page getCurrentPage() {
        return getDriver().currentPage();
    }

    public void closeBrowser() {
        getDriver().currentPage().context().close();
    }

    public Locator getElement(String selector) {
        getDriver().currentPage().waitForLoadState(LoadState.LOAD);
        return getDriver().currentPage().locator(selector);
    }

    public String getTextFromElement(String selector) {
        return getElement(selector).innerText();
    }

    public String getValueFromElement(String selector) {
        return getElement(selector).inputValue();
    }

    public void waitForPage(String url) {
        getDriver().currentPage().waitForURL(url);
        getDriver().currentPage().waitForLoadState(LoadState.LOAD);
    }

    public void verifyIfVisible(String selector){
        getElement(selector).isVisible();
    }

    public void clickElement(String selector) {
        getElement(selector).click();
    }

    public void hoverOverElement(String selector){
        getElement(selector).hover();
    }

    public void inputTextToElement(String selector, String text) {
        getElement(selector).fill(text);
    }

    public void scrollToElement(String selector) {
        getElement(selector).scrollIntoViewIfNeeded();
    }

    public void fillInputWithText(String selector, String text) {
        getElement(selector).fill(text);
    }

    public void pressKeyOnKeyboard(String selector, String key) {
        getElement(selector).press(key);
    }

    public void focusOnElement(String selector) {
        getElement(selector).focus();
    }

    public void selectValueFromDropdown(String selector, String optionName) {
        getElement(selector).selectOption(optionName);
    }

    public void gotToFrame(String selector) {
        this.frameLocator = getDriver().currentPage().frameLocator(selector);

    }

    public FrameLocator getFrameLocator() {
        return this.frameLocator;
    }
}
