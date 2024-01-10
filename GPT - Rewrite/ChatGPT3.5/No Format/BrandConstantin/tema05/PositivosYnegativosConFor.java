/**
 * Programa que lee una lista de diez números y determina cuántos son positivos y cuántos son negativos.
 *
 * @author costy
 */
import java.util.Scanner;

public class PositivosYNegativosConFor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;

        System.out.println("Escribe 10 números:");
        System.out.println("==========================================");

        for (int contador = 0; contador < 10; contador++) {
            System.out.print("Escribe un número: ");
            int num = teclado.nextInt();

            if (num >= 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        System.out.println("Hay " + positivos + " números positivos y " +
             negativos + " números negativos");
    }
}
