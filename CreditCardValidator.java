import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Credit Card Number: ");
        String cardNumber = sc.nextLine();

        if (!isDigitsOnly(cardNumber)) {
            System.out.println("Invalid input! Only digits allowed.");
            return;
        }

        if (!isValidLength(cardNumber)) {
            System.out.println("Invalid card length!");
            return;
        }

        String cardType = getCardType(cardNumber);
        boolean isValid = isValidCard(cardNumber);

        System.out.println("Card Type: " + cardType);

        if (isValid) {
            System.out.println("Credit Card is VALID ✅");
        } else {
            System.out.println("Credit Card is INVALID ❌");
        }
    }

    static boolean isDigitsOnly(String cardNumber) {
        return cardNumber.matches("\\d+");
    }

    static boolean isValidLength(String cardNumber) {
        int len = cardNumber.length();
        return len >= 13 && len <= 19;
    }

    static String getCardType(String cardNumber) {

        if (cardNumber.startsWith("4")) {
            return "Visa";
        }

        int firstTwo = Integer.parseInt(cardNumber.substring(0, 2));
        if (firstTwo >= 51 && firstTwo <= 55) {
            return "MasterCard";
        }

        return "Unknown";
    }

    static boolean isValidCard(String cardNumber) {

        int sum = 0;
        boolean isSecond = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {

            int digit = cardNumber.charAt(i) - '0';

            if (isSecond) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            isSecond = !isSecond;
        }

        return sum % 10 == 0;
    }
}
