package fakestore.pages;

import com.microsoft.playwright.*;
import fakestore.pages.Base.BasePage;

public class MainPage extends BasePage {

    private final String MAIN_PAGE_URL                          = "https://fakestore.testelka.pl/";
    private final String SELECTOR_HEADER                        = "//header[@class='entry-header']/h1";
    private final String SELECTOR_CATEGORY_SECTION              = "//main[@id = 'main']//section[@class='storefront-product-section storefront-product-categories']";
    private final String SELECTOR_SECTION                       = "//main[@id = 'main']//section/h2[text() = '%s']";
    private final String SELECTOR_SECTION_AND_PRODUCT           = "//main[@id = 'main']//section/h2[text() = '%s']/parent::section//h2[contains(text(), '%s')]";



    public MainPage() {
        super();
    }

    public void openBrowserAndLoadMainPage () {
        loadUrl(MAIN_PAGE_URL);
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getMainPage() {
        return getCurrentPage();
    }

    public Locator getProductCategorySection() {
        return getElement(SELECTOR_CATEGORY_SECTION);
    }

    public Locator getProductSection(String sectionName) {
        return getElement(String.format(SELECTOR_SECTION, sectionName));
    }

    public void selectProductFromSection(String sectionName, String productName) {
        clickElement(String.format(SELECTOR_SECTION_AND_PRODUCT,sectionName,productName));

    }

    public String getProductNameFromSection(String sectionName, String productName) {
        return getTextFromElement(String.format(SELECTOR_SECTION_AND_PRODUCT,sectionName, productName));
    }
}
