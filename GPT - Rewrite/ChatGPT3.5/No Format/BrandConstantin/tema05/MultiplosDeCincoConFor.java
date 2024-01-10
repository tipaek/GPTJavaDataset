/**
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle for.
 *
 * @author costy
 */

public class MultiplosDeCincoConFor {
    public static void main(String[] args) {

        System.out.println("Números múltiplos de 5 de 0 a 100 son:");

        for (int numero = 0; numero <= 100; numero += 5) {
            System.out.print(" " + numero);
        }
    }
}
