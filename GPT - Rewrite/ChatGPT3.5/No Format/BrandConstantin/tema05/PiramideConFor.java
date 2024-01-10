/**
* Realiza un programa que pinte una pirámide por pantalla. La altura se debe
* pedir por teclado. El carácter con el que se pinta la pirámide también se
* debe pedir por teclado.
*
* @author costy
 */
import java.util.Scanner;

public class PiramideConFor {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la altura de la pirámide:");
        int numIntrod = teclado.nextInt();

        System.out.println("Introduce el carácter para pintar la pirámide:");
        char caracter = teclado.next().charAt(0);

        System.out.println("------------------------------------------------------");

        for (int a = 1; a <= numIntrod; a++) {
            // Print spaces
            for (int espacio = 0; espacio < (numIntrod - a); espacio++) {
                System.out.print(" ");
            }

            // Print characters
            for (int numero = 1; numero <= a; numero++) {
                System.out.print(" " + caracter);
            }

            System.out.println();
        }

        System.out.println("------------------------------------------------------");
    }
}
