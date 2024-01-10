/**
 * Escribe un programa que pida una base y un exponente (entero positivo) y que
 * calcule la potencia.
 *
 * @author costy
 */
import java.util.Scanner;

public class CalcularPotenciaConFor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe la base (número entero positivo):");
        int base = teclado.nextInt();

        System.out.println("Escribe el exponente (número entero positivo):");
        int expo = teclado.nextInt();

        int potencia = 1;

        if (expo < 0) {
            System.out.println("Error: El exponente debe ser un número entero positivo.");
        } else {
            for (int i = 1; i <= expo; i++) {
                potencia *= base;
            }

            System.out.println(base + " ^ " + expo + " = " + potencia);
        }
    }
}
