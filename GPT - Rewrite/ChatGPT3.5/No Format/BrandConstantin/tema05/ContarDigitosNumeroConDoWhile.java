/**
 * Realiza un programa que nos diga cuántos dígitos tiene un número introducido
 * por teclado.
 *
 * @author costy
 */
import java.util.Scanner;

public class ContarDigitosNumeroConDoWhile {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);

        System.out.println("CONTAR DIGITOS DE UN NÚMERO");
        System.out.println("============================================");

        int digitCount = 0;

        System.out.println("Escribe un número y te diré de cuántos dígitos está formado:");
        int num = Math.abs(tecla.nextInt()); // Using Math.abs to handle negative numbers

        do {
            num = num / 10;
            digitCount++;
        } while (num > 0);

        System.out.println("El número tiene " + digitCount + " dígitos");
    }
}
