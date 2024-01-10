/**
 * Escribe un programa que muestre por pantalla todos los números enteros
 * positivos menores a uno leído por teclado que no sean divisibles entre otro
 * también leído de igual forma.
 *
 * @author costy
 */
import java.util.Scanner;

public class EnterosPositivosDivisibles {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número grande:");
        int numIntrod = teclado.nextInt();

        System.out.println("Introduce un divisor más pequeño que el anterior:");
        int divisor = teclado.nextInt();

        if (numIntrod <= 0) {
            System.out.println("Error: El número introducido debe ser positivo y mayor que cero.");
        } else if (divisor <= 0) {
            System.out.println("Error: El divisor introducido debe ser positivo y mayor que cero.");
        } else {
            for (int i = 1; i < numIntrod; i++) {
                if ((i % divisor) != 0) {
                    System.out.print(i + "   ");
                }
            }
        }
    }
}
