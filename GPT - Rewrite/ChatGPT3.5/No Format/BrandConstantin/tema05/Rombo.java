/**
 * Realiza un programa que pinte por pantalla un rombo hecho con asteriscos.
 * El programa debe pedir la altura. Se debe comparar que la altura sea un número impar mayor o igual a 3,
 * en caso contrario, se debe mostrar un mensaje de error.
 */
import java.util.Scanner;

public class Rombo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int i;
        int k;
        int j;

        System.out.print("Introduce un número: ");
        int size = teclado.nextInt();
        System.out.print("===================================================================\n");

        if (size >= 3 && size % 2 != 0) {
            for (i = 1; i <= (size - 1); i++) {
                for (k = size; k > i; k--) {
                    System.out.print(" ");
                }
                for (j = 1; j <= i; j++) {
                    System.out.print("*" + " ");
                }
                System.out.println();
            }
            for (i = size; i > 0; i--) {
                for (k = size; k > i; k--) {
                    System.out.print(" ");
                }
                for (j = 1; j <= i; j++) {
                    System.out.print("*" + " ");
                }
                System.out.println();
            }
        } else {
            System.err.print("La altura debe ser un número impar mayor o igual a 3");
        }
    }
}
