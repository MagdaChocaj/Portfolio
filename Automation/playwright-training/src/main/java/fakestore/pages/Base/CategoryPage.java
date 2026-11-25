package fakestore.pages.Base;

import com.microsoft.playwright.Page;

public class CategoryPage extends BasePage {

    private final String SELECTOR_HEADER                        = "//header[@class='woocommerce-products-header']/h1";
    private final String SELECTOR_PRODUCT                       = "//ul[@class='products columns-3']//h2[contains(text(), '%s')]/parent::a";
    private final String SELECTOR_PRODUCT_INDEX                 = "//ul[@class='products columns-3']//a[%s]";

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getCategoryPage(){
        return getCurrentPage();
    }

    public void selectProduct(String productName) {
        String productTitle = productName.replaceAll("\\p{Pd}", "–");
        clickElement(String.format(SELECTOR_PRODUCT,productTitle));
    }

    public String getProductName(String productIndex) {
        return getTextFromElement(String.format(SELECTOR_PRODUCT_INDEX, productIndex));
    }
}
