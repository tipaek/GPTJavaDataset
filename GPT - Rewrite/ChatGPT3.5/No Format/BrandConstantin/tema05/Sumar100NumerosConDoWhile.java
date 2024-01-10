/**
 * Realiza un programa que sume los 100 números siguientes a un número entero
 * positivo introducido por teclado. Se debe comprobar que el dato introducido
 * es correcto (que es un número positivo).
 *
 * @author costy
 */
import java.util.Scanner;

public class Sumar100NumerosConDoWhile {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe un número positivo y te sumo los 100 siguientes");
        System.out.println("==================================================");

        int num;

        do {
            System.out.print("Introduce un número positivo: ");
            num = teclado.nextInt();

            if (num <= 0) {
                System.out.println("Por favor, ingresa un número positivo.");
            }

        } while (num <= 0);

        int suma = 0;
        int i = num + 1;

        do {
            suma += i;
            i++;
        } while (i < num + 100);

        System.out.println("La suma de los 100 números es: " + suma);
    }
}
