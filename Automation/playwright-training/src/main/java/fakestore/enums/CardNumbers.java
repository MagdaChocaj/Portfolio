package fakestore.enums;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public enum CardNumbers {

    VISA,
    VISA_DEBIT,
    MASTERCARD,
    MASTERCARD_DEBIT,
    MASTERCARD_PREPAID,
    AMERICAN_EXPRESS,
    DISCOVER,
    DISCOVER_DEBIT,
    DINERS_CLUB,
    DINERS_CLUB_14_DIGIT,
    BCCARD_DINACARD,
    JCB,
    UNION_PAY,
    UNION_PAY_DEBIT,
    UNION_PAY_19_DIGIT,
    VISA_POLAND;

    public static String getValue(CardNumbers card) {
        HashMap<String, String> cardNumbers = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/fakestore/resources/CardNumbers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                cardNumbers.put(String.valueOf(line.contains(card.toString())), line.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return cardNumbers.get(card.toString());
    }
}
