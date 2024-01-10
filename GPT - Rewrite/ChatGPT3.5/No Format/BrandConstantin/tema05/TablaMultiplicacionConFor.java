/*
 * Muestra la tabla de multiplicar de un número introducido por teclado.
 *
 * @author Costy
 */
import java.util.Scanner;

public class TablaMultiplicacionConFor {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);

        System.out.println("TABLA DE MULTIPLICAR");
        System.out.println("============================================");

        int resultado;

        System.out.println("Escribe el número que quieres multiplicar");
        int num = tecla.nextInt();
        System.out.println("============================================");

        for (int i = 1; i <= 10; i++) {
            resultado = i * num;
            System.out.println(num + " x " + i + " = " + resultado);
        }
    }
}
