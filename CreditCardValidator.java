import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Credit Card Number: ");
        String cardNumber = sc.nextLine();

        int sum = 0;
        boolean isSecond = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {

            int digit = cardNumber.charAt(i) - '0';

            if (isSecond) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = digit - 9;
                }
            }

            sum += digit;
            isSecond = !isSecond;
        }

        if (sum % 10 == 0) {
            System.out.println("Credit Card is VALID ✅");
        } else {
            System.out.println("Credit Card is INVALID ❌");
        }
    }
}
