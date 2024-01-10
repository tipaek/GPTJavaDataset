/**
 * Realiza un programa que pida primero un número y a continuación un dígito. El
 * programa nos debe dar la posición (o posiciones) contando de izquierda a
 * derecha que ocupa ese dígito en el número introducido.
 *
 * @author costy
 */
import java.util.Scanner;

public class PosicionDigitoConDoWhile {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        long numIntrod;
        long digito;
        long reves = 0;
        int posicion = 1;

        System.out.println("Introduce un número:");
        numIntrod = teclado.nextLong();

        System.out.println("Introduce un dígito:");
        digito = teclado.nextLong();

        System.out.println("-------------------------------------------------------");

        do {
            reves = (reves * 10) + (numIntrod % 10);
            numIntrod = numIntrod / 10;
        } while (numIntrod > 0);

        do {
            if ((reves % 10) == digito) {
                System.out.println("El dígito está en la posición: " + posicion);
            }
            reves = reves / 10;
            posicion++;
        } while (reves > 0);
    }
}
