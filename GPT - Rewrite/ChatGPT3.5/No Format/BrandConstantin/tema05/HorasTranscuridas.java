/**
 * Realiza un programa que calcule las horas transcurridas entre dos horas de
 * dos días de la semana. No se tendrán en cuenta los minutos ni los segundos.
 * El día de la semana se puede pedir como un número (del 1 al 7) o como una
 * cadena (de “lunes” a “domingo”). Se debe comprobar que el usuario introduce los
 * datos correctamente y que el segundo día es posterior al primero. A
 * continuación se muestra un ejemplo: Por favor, introduzca la primera hora.
 * Día: lunes
 * Hora: 18
 * Por favor, introduzca la segunda hora.
 * Día: martes
 * Hora: 20
 * Entre las 18:00h del lunes y las 20:00h del martes hay 26 hora/s.
 *
 * @author costy
 */
import java.util.Scanner;

public class HorasTranscurridas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("AVERIGUAR LAS HORAS TRANSCURRIDAS ENTRE DOS DIAS");

        int dia1 = 0;
        int dia2 = 0;
        int hora1;
        int hora2;
        boolean verdadero = true;
        String diaUno;
        String diaDos;
        String nombreDiaUno = "";
        String nombreDiaDos = "";

        do {
            System.out.println("Introduce la primera hora:");
            hora1 = teclado.nextInt();
            System.out.println("Introduce el día:");
            diaUno = teclado.next();

            switch (diaUno.toLowerCase()) {
                case "lunes":
                case "1":
                    dia1 = 1;
                    nombreDiaUno = "lunes";
                    break;
                case "martes":
                case "2":
                    dia1 = 2;
                    nombreDiaUno = "martes";
                    break;
                case "miercoles":
                case "3":
                    dia1 = 3;
                    nombreDiaUno = "miércoles";
                    break;
                case "jueves":
                case "4":
                    dia1 = 4;
                    nombreDiaUno = "jueves";
                    break;
                case "viernes":
                case "5":
                    dia1 = 5;
                    nombreDiaUno = "viernes";
                    break;
                case "sabado":
                case "6":
                    dia1 = 6;
                    nombreDiaUno = "sábado";
                    break;
                case "domingo":
                case "7":
                    dia1 = 7;
                    nombreDiaUno = "domingo";
                    break;
                default:
                    System.out.println("Introduce un día válido de la semana (1-7/lunes-domingo)");
                    verdadero = false;
                    break;
            }

            if (!verdadero) {
                continue;
            }

            System.out.println("Introduce la segunda hora:");
            hora2 = teclado.nextInt();
            System.out.println("Introduce el segundo día:");
            diaDos = teclado.next();

            switch (diaDos.toLowerCase()) {
                case "lunes":
                case "1":
                    dia2 = 1;
                    nombreDiaDos = "lunes";
                    break;
                case "martes":
                case "2":
                    dia2 = 2;
                    nombreDiaDos = "martes";
                    break;
                case "miercoles":
                case "3":
                    dia2 = 3;
                    nombreDiaDos = "miércoles";
                    break;
                case "jueves":
                case "4":
                    dia2 = 4;
                    nombreDiaDos = "jueves";
                    break;
                case "viernes":
                case "5":
                    dia2 = 5;
                    nombreDiaDos = "viernes";
                    break;
                case "sabado":
                case "6":
                    dia2 = 6;
                    nombreDiaDos = "sábado";
                    break;
                case "domingo":
                case "7":
                    dia2 = 7;
                    nombreDiaDos = "domingo";
                    break;
                default:
                    System.out.println("Introduce un día válido de la semana (1-7/lunes-domingo)");
                    verdadero = false;
                    break;
            }

            if (!verdadero) {
                continue;
            }

            if (dia2 <= dia1) {
                System.out.println("El segundo día debe ser posterior al primero.");
                verdadero = false;
            }

            if (((hora1 < 0) || (hora1 > 23)) || ((hora2 < 0) || (hora2 > 23))) {
                System.out.println("Introduce una hora correcta (0-23)");
                verdadero = false;
            }

        } while (!verdadero);

        System.out.println("Entre las " + hora1 + ":00h del " + nombreDiaUno + " y las " + hora2 + ":00h del "
                + nombreDiaDos + " hay un total de ");
        System.out.print(((dia2 * 24) + hora2) - ((dia1 * 24) + hora1) + " horas");
    }
}
