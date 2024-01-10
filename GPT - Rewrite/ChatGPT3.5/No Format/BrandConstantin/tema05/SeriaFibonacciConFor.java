/**
 * Programa que muestra los n primeros términos de la serie de Fibonacci.
 * El primer término de la serie es 0, el segundo es 1 y el resto se calcula
 * sumando los dos anteriores.
 *
 * @author costy
 */
import java.util.Scanner;

public class SerieFibonacciConFor {
    public static void main(String[] args) {

        System.out.println("Escribe cualquier número");

        int elemento;
        int num1 = 0;
        int num2 = 1;
        int suma;

        Scanner teclado = new Scanner(System.in);
        elemento = teclado.nextInt();

        if (elemento <= 100) {
            if (elemento == 1) {
                System.out.print("0");
            } else {
                System.out.print(num1 + " ");

                for (int i = 1; i < elemento; i++) {
                    suma = num1 + num2;
                    System.out.print(num2 + " ");
                    num1 = num2;
                    num2 = suma;
                }
            }
        } else {
            System.err.println("Por favor, ingresa un número menor o igual a 100");
        }
    }
}
