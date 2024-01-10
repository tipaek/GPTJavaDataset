/**
 * Programa que lee una lista de diez números y determina cuántos son positivos y cuántos son negativos.
 *
 * @author costy
 */
import java.util.Scanner;

public class PositivosYNegativosConWhile {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;
        int contador = 0;

        System.out.println("Escribe 10 números:");
        System.out.println("==========================================");

        while (contador < 10) {
            System.out.println("Escribe un número:");
            int num = teclado.nextInt();

            if (num >= 0) {
                positivos++;
            } else {
                negativos++;
            }
            contador++;
        }

        System.out.println("Hay " + positivos + " números positivos y " +
             negativos + " números negativos");
    }
}
