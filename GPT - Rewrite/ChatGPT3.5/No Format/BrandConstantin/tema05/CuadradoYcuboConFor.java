/**
 * Escribe un programa que muestre en tres columnas, el cuadrado y el cubo de
 * los 5 primeros números enteros a partir de uno que se introduce por teclado.
 *
 * @author costy
 */
import java.util.Scanner;

public class CuadradoYcuboConFor {
    public static void main(String[] args) {
        System.out.println("Escribe cualquier número de 1 a 99:");

        int num;
        Scanner teclado = new Scanner(System.in);
        num = teclado.nextInt();

        if (num < 1 || num > 99) {
            System.out.println("El número debe estar en el rango de 1 a 99.");
        } else {
            System.out.println("Número | Cuadrado | Cubo");
            System.out.println("=========================");

            for (int contador = 0; contador < 5; contador++) {
                System.out.println(num + "      | " + num * num + "      | " + num * num * num);
                num++;
            }
        }
    }
}
