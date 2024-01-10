/**
 * Escribe un programa que lea una lista de diez números y determine cuántos son
 * positivos y cuántos son negativos.
 *
 * @author costy
 */
import java.util.Scanner;

public class PositivosYnegativosConDoWhile {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;
        int contador = 0;

        System.out.println("Escribe 10 números y te diré cuántos son positivos y cuántos son negativos");
        System.out.println("==========================================");

        do {
            System.out.println("Escribe un número:");
            int num = teclado.nextInt();

            if (num < 0) {
                negativos++;
            } else {
                positivos++;
            }
            contador++;
        } while (contador < 10);

        System.out.println("Hay " + positivos + " números positivos y " +
            negativos + " números negativos");
    }
}
