package fakestore.models;

import com.github.javafaker.Faker;

public class PaymentDetails {

    String cardNumber;
    String cardExpirationDate;
    String cardCVCCode;
    String blikCode;

    Faker faker = new Faker();

    public PaymentDetails() {
        this.cardNumber = "4242424242424242";
        this.cardExpirationDate = "12/32";
        this.cardCVCCode = faker.number().digits(3);
        this.blikCode = faker.number().digits(6);
    }

    public String getBlikCode() {
        return blikCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public String getCardCVCCode() {
        return cardCVCCode;
    }
}
