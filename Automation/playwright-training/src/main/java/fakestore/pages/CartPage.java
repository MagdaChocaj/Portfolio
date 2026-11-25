package fakestore.pages;

import fakestore.pages.Base.BasePage;

public class CartPage extends BasePage {

    private final String SELECTOR_PROCEED_TO_CHECKOUT_BUTTON    = "//div[@class='wc-proceed-to-checkout']";
    private final String SELECTOR_EXPRESS_CHECKOUT_BUTTON       = "//div[@id='wc-stripe-express-checkout-element']";

    public void clickProceedToCheckoutButton() {
        clickElement(SELECTOR_PROCEED_TO_CHECKOUT_BUTTON);
    }

    public void clickPayWithLinkButton() {
        clickElement(SELECTOR_EXPRESS_CHECKOUT_BUTTON);
    }
}
