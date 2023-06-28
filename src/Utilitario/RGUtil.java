package Utilitario;

import java.util.Scanner;

public class RGUtil {

    //public static final String Colores = null;
    public static  Scanner sc = new Scanner(System.in);

    /**
     * limpia la consola
     */
    public final static void rgClear() {
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system

            if (operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getNumeroPositivo(String mensage) {
        int numero;

        System.out.print(mensage);
        do {
            numero = sc.nextInt();
        } while (numero <= 0);
        // sc.close();

        return numero;
    }

}
