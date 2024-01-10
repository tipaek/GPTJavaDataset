/**
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.
 *
 * @author costy
 */

public class MultiplosDeCincoConWhile {
    public static void main(String[] args) {

        System.out.println("Números múltiplos de 5 de 0 a 100 son: ");

        int numero = 0;

        while (numero <= 100) {
            System.out.print(" " + numero);
            numero += 5;
        }
    }
}
