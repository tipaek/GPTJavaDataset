/**
 * Escribe un programa que diga si un número introducido por teclado es o no
 * primo. Un número primo es aquel que sólo es divisible entre él mismo y la
 * unidad.
 *
 * @author costy
 */
import java.util.Scanner;

public class NumeroPrimoConFor {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe un numero:");
        int num = teclado.nextInt();

        boolean primo = true;

        if (num <= 1) {
            primo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    primo = false;
                    break;
                }
            }
        }

        if (primo) {
            System.out.println("Numero primo!");
        } else {
            System.out.println("Numero no primo!");
        }
    }
}
