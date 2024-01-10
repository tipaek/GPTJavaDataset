/**
 * Muestra por pantalla todos los números primos entre 2 y 100, ambos incluidos.
 *
 * @author costy
 */

public class NumerosPrimosDe2a100While {
    public static void main(String[] args) {

        boolean primo;
        int i = 1;

        while (i < 100) {
            i++;

            primo = true;

            for (int b = 2; b < i; b++) {
                if (i % b == 0) {
                    primo = false;
                    break;  // Added a break to exit the loop early if not prime
                }
            }

            if (primo) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
