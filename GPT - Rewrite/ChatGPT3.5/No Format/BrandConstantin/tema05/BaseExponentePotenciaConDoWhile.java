import java.util.Scanner;

public class BaseExponentePotenciaConDoWhile {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe la base (número entero positivo)");
        int base = teclado.nextInt();

        System.out.println("Escribe el exponente (número entero positivo)");
        int exponente = teclado.nextInt();

        int potencia = 1;
        int i = 0;

        do {
            potencia *= base;
            i++;
            System.out.println(base + " ^ " + i + " = " + potencia);
        } while (i < exponente);

        teclado.close();
    }
}
