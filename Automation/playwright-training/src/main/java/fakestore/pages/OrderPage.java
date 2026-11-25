package fakestore.pages;

import com.microsoft.playwright.options.AriaRole;
import fakestore.models.Customer;
import fakestore.models.PaymentDetails;
import fakestore.pages.Base.BasePage;

public class OrderPage extends BasePage {

    private final String SELECTOR_EMAIL_INPUT                               = "//input [@id = 'billing_email']";
    private final String SELECTOR_FIRST_NAME_INPUT                          = "//input [@id = 'billing_first_name']";
    private final String SELECTOR_LAST_NAME_INPUT                           = "//input [@id = 'billing_last_name']";
    private final String SELECTOR_STREET_INPUT                              = "//input [@id = 'billing_address_1']";
    private final String SELECTOR_POSTAL_CODE_INPUT                         = "//input [@id = 'billing_postcode']";
    private final String SELECTOR_CITY_INPUT                                = "//input [@id = 'billing_city']";
    private final String SELECTOR_PHONE_NUMBER_INPUT                        = "//input [@id = 'billing_phone']";
    private final String SELECTOR_CREATE_ACCOUNT_CHECKBOX                   = "//input [@id = 'createaccount']";
    private final String SELECTOR_PASSWORD_INPUT                            = "//input [@id = 'account_password']";
    private final String SELECTOR_SHOW_PASSWORD_BUTTON                      = "//input [@id = 'account_password']/following-sibling::button";
    private final String SELECTOR_ADDITIONAL_INFORMATION_INPUT              = "//textarea [@id = 'order_comments']";
    private final String SELECTOR_COUNTRY_DROPDOWN                          = "//select [@id = 'billing_country']";
    private final String SELECTOR_CARD_NUMBER_INPUT                         = "//div[@id='card-panel']//input [@id='payment-numberInput']";
    private final String SELECTOR_CARD_EXPIRATION_DATE_INPUT                = "//input [@id='payment-expiryInput']";;
    private final String SELECTOR_CARD_CVC_NUMBER                           = "//input [@id='payment-cvcInput']";
    private final String SELECTOR_BLIK_RADIO_BUTTON                         = "//input [@id='payment_method_stripe_blik']";
    private final String SELECTOR_CARD_RADIO_BUTTON                         = "//input [@id='payment_method_stripe']";
    private final String SELECTOR_BLIK_CODE_INPUT                           = "//input [@id='wc-stripe-blik-code']";
    private final String SELECTOR_ACCEPT_TERMS_AND_CONDITIONS_CHECKBOX      = "//input [@id='terms']";
    private final String SELECTOR_PLACE_ORDER_BUTTON                        = "//button [@id='place_order']";
    private final String SELECTOR_IFRAME                                    = "//fieldset[@id='wc-stripe-upe-form']//iframe";

    Customer customer = new Customer();
    PaymentDetails paymentDetails = new PaymentDetails();

    public void fillConsumerDetailsAndCreateAnAccount() {
        inputTextToElement(SELECTOR_EMAIL_INPUT, customer.getEmail());
        inputTextToElement(SELECTOR_FIRST_NAME_INPUT, customer.getFirstName());
        inputTextToElement(SELECTOR_LAST_NAME_INPUT, customer.getLastName());
        selectValueFromDropdown(SELECTOR_COUNTRY_DROPDOWN, customer.getCountry());
        inputTextToElement(SELECTOR_STREET_INPUT, customer.getAddress());
        inputTextToElement(SELECTOR_POSTAL_CODE_INPUT, customer.getPostalCode());
        inputTextToElement(SELECTOR_CITY_INPUT, customer.getCity());
        inputTextToElement(SELECTOR_PHONE_NUMBER_INPUT, customer.getPhoneNumber());
        clickElement(SELECTOR_CREATE_ACCOUNT_CHECKBOX);
        inputTextToElement(SELECTOR_PASSWORD_INPUT, customer.generatePassword());
        clickElement(SELECTOR_SHOW_PASSWORD_BUTTON);
    }

    public void addAdditionalDetails(String text) {
        inputTextToElement(SELECTOR_ADDITIONAL_INFORMATION_INPUT, text);
    }

    public void fillCardDetails() {
        gotToFrame(SELECTOR_IFRAME);
        getFrameLocator().locator(SELECTOR_CARD_NUMBER_INPUT).fill(paymentDetails.getCardNumber());
        getFrameLocator().locator(SELECTOR_CARD_EXPIRATION_DATE_INPUT).fill(paymentDetails.getCardExpirationDate());
        getFrameLocator().locator(SELECTOR_CARD_CVC_NUMBER).fill(paymentDetails.getCardCVCCode());
    }

    public void goToCheckout() {
        clickElement(SELECTOR_ACCEPT_TERMS_AND_CONDITIONS_CHECKBOX);
        clickElement(SELECTOR_PLACE_ORDER_BUTTON);
    }

    public void payWithBlik() {
        clickElement(SELECTOR_BLIK_RADIO_BUTTON);
        inputTextToElement(SELECTOR_BLIK_CODE_INPUT, paymentDetails.getBlikCode());

    }
}
