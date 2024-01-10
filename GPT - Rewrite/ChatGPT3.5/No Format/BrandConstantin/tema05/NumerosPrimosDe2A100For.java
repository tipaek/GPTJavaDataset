/**
 * Muestra por pantalla todos los números primos entre 2 y 100, ambos incluidos.
 *
 * @author costy
 */

public class NumerosPrimosDe2A100For {
    public static void main(String[] args) {

        boolean primo;

        for (int i = 2; i <= 100; i++) {
            primo = true;

            for (int b = 2; b < i; b++) {
                if (i % b == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
