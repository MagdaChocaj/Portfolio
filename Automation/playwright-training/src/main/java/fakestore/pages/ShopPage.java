package fakestore.pages;


import fakestore.pages.Base.BasePage;

public class ShopPage extends BasePage {

    private final String SHOP_PAGE_URL                  = "https://fakestore.testelka.pl/shop/";
    private final String SELECTOR_HEADER                = "//main [@id = 'main']//h1";
    private final String SELECTOR_CATEGORY              = "//main[@id = 'main']//ul[@class='products columns-3']//a[contains(@aria-label, '%s')]";


    public ShopPage() {
        super();
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public void selectCategory(String categoryName) {
        clickElement(String.format(SELECTOR_CATEGORY, categoryName));

    }
}
