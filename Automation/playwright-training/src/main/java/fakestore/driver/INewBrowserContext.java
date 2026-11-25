package fakestore.driver;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public interface INewBrowserContext extends BrowserContext {
    Page currentPage();

    void setCurrentPage(Page var1);
}