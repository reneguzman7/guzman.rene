import java.io.File;

import Utilitario.RGColor;
import Utilitario.RGUtil;

public class App {
    public static void main(String[] args) {

        RGUtil.rgClear();

        final String RGCEDULA = "1750366286";
        final String RGCORREO = "RENE.GUZMAN@EPN.EDU.EC";
        final String RGNOMBRE = "rene alejandro guzman moreira";

        rgPresentarDatos(RGCEDULA, RGCORREO, RGNOMBRE);

        rgLoginRene();


        System.out.println("------------------------");
        System.out.println("Carga horaria de ALUMNOS");
        System.out.println("------------------------");
        System.out.println("Usuario: ");

        System.out.println("1. Visualizar Alumnos");
        System.out.println("2. Visualizar Asignaturas");
        System.out.println("3. Visualizar Horario");
        System.out.println("4. Visualizar Horario de una asignatura");
        System.out.println("0. SALIR");
        int rgEntradaMenu = Integer.parseInt(RGUtil.sc.nextLine());

        switch (rgEntradaMenu) {
            case 1:
                String rgDirectorio = "src\\\\Horarios";
                rgImprimirNombresArchivosCSV(rgDirectorio);

                

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

            default:
                break;
        }

    }

    public static void rgPresentarDatos(String RGCEDULA, String RGCORREO, String RGNOMBRE) {
        System.out.println(RGColor.BOLD_CYAN + "-CEDULA: " + RGCEDULA);
        System.out.println(RGColor.BOLD_CYAN + "-CORREO: " + RGCORREO.toLowerCase());
        System.out.println(RGColor.BOLD_CYAN + "-NOMBRE: " + RGNOMBRE.toUpperCase());
    }

    public static boolean rgLoginRene() {
        int rgIntentosMax = 0;
        String rgUser;
        String rgClave;

        do {
            System.out.println(RGColor.RESET + "-------------------");
            System.out.print("+ Usuario: ");
            rgUser = RGUtil.sc.nextLine();
            System.out.print("+ Clave: ");
            rgClave = RGUtil.sc.nextLine();
            System.out.println("-------------------");

            boolean rgLoginExitoso = (((rgUser.equals("profe")) && (rgClave.equals("1234")))
                    || ((rgUser.equals("rene.guzman@epn.edu.ec")) && (rgClave.equals("1750366286"))));

            if (rgLoginExitoso == true) {
                rgIntentosMax += 3;
                System.out.println("::Bienvenido " + rgUser.toUpperCase());
                return true;
            } else {
                rgIntentosMax++;
                System.out.println("Le quedan " + (3 - rgIntentosMax) + " intentos");
            }
        } while (rgIntentosMax < 3);
        System.out.println("Lo sentimos tu usuario y clave son incorrectos..!");
        // System.exit(0);
        return false;
    }

    public static void rgImprimirNombresArchivosCSV(String rgDirectorio) {
        File rgCarpeta = new File(rgDirectorio);

        // Verificar si el directorio existe y es una carpeta
        if (rgCarpeta.exists() && rgCarpeta.isDirectory()) {
            File[] rgArchivos = rgCarpeta.listFiles();

            // Recorrer los archivos en el directorio
            for (File archivo : rgArchivos) {
                // Verificar si es un archivo CSV
                if (archivo.isFile() && archivo.getName().endsWith(".csv")) {
                    String nombreArchivo = archivo.getName();
                    int indicePunto = nombreArchivo.lastIndexOf('.');
                    if (indicePunto > 0) {
                        String nombreSinExtension = nombreArchivo.substring(0, indicePunto);
                        System.out.println(nombreSinExtension);
                    }
                }
            }
        } else {
            System.out.println("El directorio especificado no existe.");
        }
    }
}
