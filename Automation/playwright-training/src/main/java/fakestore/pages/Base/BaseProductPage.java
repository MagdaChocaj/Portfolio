package fakestore.pages.Base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BaseProductPage extends BasePage {

    private final String SELECTOR_PRODUCT_TITLE                         = "//h1[@class='product_title entry-title']";
    private final String SELECTOR_PRICE                                 = "//p[@class='price']//bdi";
    private final String SELECTOR_STOCK_AVAILABILITY                    = "//p[@class='stock in-stock']";
    private final String SELECTOR_QUANTITY_INPUT                        = "//div[@class = 'quantity']/input";
    private final String SELECTOR_ADD_TO_CART_BUTTON                    = "//button[@name='add-to-cart']";
    private final String SELECTOR_EXPRESS_CHECKOUT_BUTTON               = "//button [contains(@class, 'LinkButton')]";
    private final String SELECTOR_WISHLIST_BUTTON                       = "//a[@class='add_to_wishlist single_add_to_wishlist']";
    private final String SELECTOR_DESCRIPTION_TAB                       = "//li[@id='tab-title-description']/a";
    private final String SELECTOR_ADDITIONAL_INFORMATION_TAB            = "//li[@id='tab-title-additional_information']/a";
    private final String SELECTOR_REVIEWS_TAB                           = "//li[@id='tab-title-reviews']/a";
    private final String SELECTOR_RELATED_PRODUCTS_SECTION              = "//section[@class='related products']";
    private final String SELECTOR_STICKY_ADD_TO_CART_BUTTON             = "//a[@class='storefront-sticky-add-to-cart__content-button button alt']";
    private final String SELECTOR_PREVIOUS_PRODUCT                      = "//nav[@class='storefront-product-pagination']/a[@rel='prev']";
    private final String SELECTOR_NEXT_PRODUCT                          = "//nav[@class='storefront-product-pagination']/a[@rel='next']";
    private final String SELECTOR_SUCCESS_MESSAGE                       = "//div[@class='woocommerce-message']";
    private final String SELECTOR_SUCCESS_MESSAGE_VIEW_CART_BUTTON      = "//div[@class='woocommerce-message']/a";
    String quantity;

    public String getProductTitle(){
        return getTextFromElement(SELECTOR_PRODUCT_TITLE);
    }

    public String getPrice() {
        return getTextFromElement(SELECTOR_PRICE);
    }

    public String getStockAvailability() {
        return getTextFromElement(SELECTOR_STOCK_AVAILABILITY);
    }

    public Page getProductPage(){
        return getCurrentPage();
    }

    public String getURL() {
        return getUrl();
    }

    public void addQuantity(String quantity) {
        inputTextToElement(SELECTOR_QUANTITY_INPUT, quantity);
        this.quantity = getValueFromElement(SELECTOR_QUANTITY_INPUT);
    }

    public String getQuantity() {
        return quantity;
    }

    public void addProductToCart() {
        clickElement(SELECTOR_ADD_TO_CART_BUTTON);
    }

    public void buyProductWithLink() {
        clickElement(SELECTOR_EXPRESS_CHECKOUT_BUTTON);
    }

    public void addProductToWishlist() {
        clickElement(SELECTOR_WISHLIST_BUTTON);
    }

    public void viewProductDescription() {
        clickElement(SELECTOR_DESCRIPTION_TAB);
        focusOnElement(SELECTOR_DESCRIPTION_TAB);
    }

    public void viewAdditionalInformation() {
        clickElement(SELECTOR_ADDITIONAL_INFORMATION_TAB);
        focusOnElement(SELECTOR_ADDITIONAL_INFORMATION_TAB);
    }

    public void viewReviews() {
        clickElement(SELECTOR_REVIEWS_TAB);
        focusOnElement(SELECTOR_REVIEWS_TAB);
    }

    public void viewRelatedProducts() {
        scrollToElement(SELECTOR_RELATED_PRODUCTS_SECTION);
    }

    public void addProductToCartWithStickyButton() {
        clickElement(SELECTOR_STICKY_ADD_TO_CART_BUTTON);
    }

    public void goToPreviousProduct() {
        clickElement(SELECTOR_PREVIOUS_PRODUCT);
    }

    public void goToNextProduct() {
        clickElement(SELECTOR_NEXT_PRODUCT);
    }

    public String getSuccessMessageContent() {
        return getTextFromElement(SELECTOR_SUCCESS_MESSAGE);
    }

    public Locator getSuccessMessage() {
        return getElement(SELECTOR_SUCCESS_MESSAGE);
    }

    public void clickViewCartButtonInSuccessMessage() {
        clickElement(SELECTOR_SUCCESS_MESSAGE_VIEW_CART_BUTTON);
    }




}

