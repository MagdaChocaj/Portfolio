package fakestore.pages.Base;

import fakestore.actions.Actions;

public class BasePage extends Actions {

    private final String SELECTOR_TAB                               = "//div[@class = 'primary-navigation']//a[text() = '%s']";
    private final String SELECTOR_CART_CONTENTS                     = "//a[@class = 'cart-contents']";
    private final String SELECTOR_REMOVE_PRODUCT_FROM_CART_BUTTON   = "//li [@class='woocommerce-mini-cart-item mini_cart_item']/a [@role = 'button']";
    private final String SELECTOR_GO_TO_PRODUCT_BUTTON              = "//li [@class='woocommerce-mini-cart-item mini_cart_item']/a [@href='https://fakestore.testelka.pl/product/windsurfing-w-lanzarote-costa-teguise/']";
    private final String SELECTOR_VIEW_CART_BUTTON                  = "//p[@class='woocommerce-mini-cart__buttons buttons']/a[@href='https://fakestore.testelka.pl/koszyk/']";
    private final String SELECTOR_CHECKOUT_BUTTON                   = "//p[@class='woocommerce-mini-cart__buttons buttons']/a[@href='https://fakestore.testelka.pl/zamowienie/']";
    private final String SELECTOR_SEARCH_FIELD_INPUT                = "//input[@id='woocommerce-product-search-field-0']";
    private final String SELECTOR_LOGO_BUTTON                       = "//a[@class='custom-logo-link']";
    private final String SELECTOR_BREADCRUMB_NAVIGATION_ITEM        = "//nav[@class = 'woocommerce-breadcrumb']/a[text() = '%s']";
    private final String SELECTOR_CATEGORY_NAME                     = "//main[@id = 'main']//section[@class='storefront-product-section storefront-product-categories']//a[contains(@aria-label, '%s')]";
    private final String SELECTOR_PRODUCT_CATEGORY_WIDGET           = "//div[@id='woocommerce_product_categories-3']//a[text() = '%s']";
    private final String SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET   = "//div[@id='woocommerce_recently_viewed_products-3']//span[text() = '%s']/parent::a";

    public BasePage() {
        super();
    }

    public void goToTab(String tabName) {

        clickElement(String.format(SELECTOR_TAB, tabName));
    }

    public void clickLogo() {
        clickElement(SELECTOR_LOGO_BUTTON);
    }

    public void goToCart() {
        clickElement(SELECTOR_CART_CONTENTS);
    }

    public void viewCartContents() {
        hoverOverElement(SELECTOR_CART_CONTENTS);
    }

    public void cartContentsRemoveProduct() {
        clickElement(SELECTOR_REMOVE_PRODUCT_FROM_CART_BUTTON);
    }

    public void cartContentsGoToProduct() {
        clickElement(SELECTOR_GO_TO_PRODUCT_BUTTON);
    }

    public void cartContentsViewCart() {
        clickElement(SELECTOR_VIEW_CART_BUTTON);
    }

    public void cartContentsGoToCheckout() {
        clickElement(SELECTOR_CHECKOUT_BUTTON);
    }

    public void getCartContents() {
        hoverOverElement(SELECTOR_CART_CONTENTS);
    }

    public void selectBreadcrumbNavigationItem(String itemName) {
        clickElement(String.format(SELECTOR_BREADCRUMB_NAVIGATION_ITEM, itemName));
    }

    public void searchForText(String searchText) {
        fillInputWithText(SELECTOR_SEARCH_FIELD_INPUT, searchText);
        pressKeyOnKeyboard(SELECTOR_SEARCH_FIELD_INPUT, "Enter");
    }

    public void selectProductCategory(String categoryName) {
        clickElement(String.format(SELECTOR_CATEGORY_NAME, categoryName));
    }

    public void selectProductCategoryFromWidget(String categoryName) {
        clickElement(String.format(SELECTOR_PRODUCT_CATEGORY_WIDGET, categoryName));
    }

    public void selectRecentlyViewedProduct(String productName) {
        clickElement(String.format(SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET, productName));
    }
}
