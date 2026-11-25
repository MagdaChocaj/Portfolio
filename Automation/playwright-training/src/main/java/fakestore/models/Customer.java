package fakestore.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Customer {

    String email;
    String firstName;
    String lastName;
    String country;
    String address;
    String postalCode;
    String city;
    String phoneNumber;
    String password;

    Faker faker = new Faker(Locale.of("pl", "PL"));

    public Customer() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.country = faker.country().name();
        this.email = faker.internet().emailAddress();
        this.address = faker.address().streetAddress();
        this.postalCode = faker.address().zipCode();
        this.city = faker.address().city();
        this.phoneNumber = faker.phoneNumber().cellPhone();
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String generatePassword() {
        String newPassword = faker.internet().password(12, 20, true, true);
        return this.password = newPassword;

    }
}
