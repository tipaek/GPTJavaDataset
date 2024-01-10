/**
 * Program that allows entering an indeterminate series of numbers until their sum exceeds 10000.
 * When this happens, it displays the total accumulated, the count of the entered numbers, and the average.
 *
 * @author costy
 */
import java.util.Scanner;

public class SumUpTo10KWithFor {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int sum = 0;
        int enteredNum;
        int totalNumbers = 0;

        for (; sum <= 10000; totalNumbers++) {
            System.out.println("Enter numbers:");
            enteredNum = keyboard.nextInt();

            sum += enteredNum;
        }

        System.out.println("The average of the numbers is " + (sum / totalNumbers));
        System.out.println("The total accumulated is " + sum);
        System.out.println("With a total of entered numbers of " + totalNumbers);
    }
}
