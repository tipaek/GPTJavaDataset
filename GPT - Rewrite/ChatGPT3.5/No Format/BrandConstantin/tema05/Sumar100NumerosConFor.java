/**
 * Program that sums the next 100 numbers after a positive integer entered by the user.
 * It checks that the entered data is correct (a positive number).
 *
 * @author costy
 */
import java.util.Scanner;

public class Sum100NumbersWithFor {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a positive number, and I will sum the next 100 numbers");
        System.out.println("==========================================================");

        int num;

        do {
            System.out.print("Enter a positive number: ");
            num = keyboard.nextInt();

            if (num <= 0) {
                System.out.println("Please enter a positive number.");
            }

        } while (num <= 0);

        int sum = 0;

        for (int i = num + 1; i < num + 101; i++) {
            sum += i;
        }

        System.out.println("The sum of the next 100 numbers is: " + sum);
    }
}
