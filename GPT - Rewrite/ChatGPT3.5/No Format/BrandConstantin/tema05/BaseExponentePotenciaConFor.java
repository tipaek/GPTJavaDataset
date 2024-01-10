import java.util.Scanner;

public class BaseExponentePotenciaConFor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe la base (número entero positivo)");
        int base = teclado.nextInt();

        System.out.println("Escribe el exponente (número entero positivo)");
        int exponente = teclado.nextInt();

        int potencia = 1;

        for (int y = 1; y <= exponente; y++) {
            potencia *= base;
            System.out.println(base + " ^ " + y + " = " + potencia);
        }

        teclado.close();
    }
}
