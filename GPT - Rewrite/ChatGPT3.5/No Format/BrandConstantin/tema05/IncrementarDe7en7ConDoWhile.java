/**
 * Escribe un programa que obtenga los números enteros comprendidos entre dos
 * números introducidos por teclado y validados como distintos, el programa debe
 * empezar por el menor de los enteros introducidos e ir incrementando de 7 en 7.
 *
 * @author costy
 */
import java.util.Scanner;

public class IncrementarDe7en7ConDoWhile {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe un numero:");
        int num1 = teclado.nextInt();

        System.out.println("Escribe otro numero:");
        int num2 = teclado.nextInt();
        System.out.println("==================================================");

        if (num1 == num2) {
            System.err.println("Escribe 2 numeros distintos por favor!");
        } else {
            int startNum;
            int endNum;

            if (num1 < num2) {
                startNum = num1;
                endNum = num2;
            } else {
                startNum = num2;
                endNum = num1;
                System.err.println("El primer numero debe ser menor que el segundo.");
                System.err.println("Intercambiando los numeros...");
            }

            int i = startNum;
            do {
                System.out.println(i + " ");
                i += 7;
            } while (i <= endNum);
        }
    }
}
