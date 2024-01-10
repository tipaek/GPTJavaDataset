/**
 * Programa que muestra los n primeros términos de la serie de Fibonacci.
 * El primer término de la serie es 0, el segundo es 1 y el resto se calcula
 * sumando los dos anteriores.
 *
 * @author costy
 */
import java.util.Scanner;

public class SerieFibonacciConDoWhile {
    public static void main(String[] args) {

        System.out.println("Escribe cualquier número");

        int i = 1;
        int elemento;
        int num1 = 0;
        int num2 = 1;
        int suma;

        Scanner teclado = new Scanner(System.in);
        elemento = teclado.nextInt();

        if (elemento >= 1) {
            System.out.print("0");
        }

        do {
            if (elemento > 1) {
                System.out.print(" " + num2);
                do {
                    suma = num1 + num2;
                    System.out.print(" " + suma);
                    num1 = num2;
                    num2 = suma;
                } while (i++ < (elemento - 2));
            }
        } while (i < elemento);
    }
}
