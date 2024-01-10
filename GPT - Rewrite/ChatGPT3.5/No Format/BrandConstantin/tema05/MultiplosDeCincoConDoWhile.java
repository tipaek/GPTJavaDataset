/**
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle do-while.
 *
 * @author costy
 */

public class MultiplosDeCincoConDoWhile {
    public static void main(String[] args) {

        System.out.println("Números múltiplos de 5 de 0 a 100 son:");

        int numero = 0;

        do {
            System.out.print(" " + numero);
            numero += 5;
        } while (numero <= 100);
    }
}
