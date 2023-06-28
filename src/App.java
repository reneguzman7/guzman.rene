import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import Utilitario.RGColor;
import Utilitario.RGUtil;

/**
 * @author reneguzman7
 */
public class App {
    public static void main(String[] args) {
        boolean rgControl = true;
        RGUtil.rgClear();

        final String RGCEDULA = "1750366286";
        final String RGCORREO = "RENE.GUZMAN@EPN.EDU.EC";
        final String RGNOMBRE = "rene alejandro guzman moreira";

        rgPresentarDatos(RGCEDULA, RGCORREO, RGNOMBRE);

        rgLoginRene();

        System.out.println(RGColor.BOLD_PURPLE + "------------------------");
        System.out.println(RGColor.BOLD_PURPLE + "Carga horaria de ALUMNOS");
        System.out.println(RGColor.BOLD_PURPLE + "------------------------");
        System.out.println(RGColor.BOLD_PURPLE + "Usuario: ");

        do {

            rgOpcionesMenu();

            int rgEntradaMenu = Integer.parseInt(RGUtil.sc.nextLine());
            if (rgEntradaMenu >= 0 && rgEntradaMenu <= 4) {
                rgControl = false;
            } else {
                System.out.println("Opcion no valida \n");
                rgControl = true;
            }

            switch (rgEntradaMenu) {
                case 1:
                    String rgDirectorio = "src\\\\Horarios";
                    rgImprimirNombresArchivosCSV(rgDirectorio);

                    rgControl = rgRepetirMenu();

                    break;
                case 2:

                    String carpetaCSV = "src\\\\\\\\Horarios"; // Especifica la ruta de la carpeta aquí
                    HashSet<String> rgTemasAsignados = new HashSet<>();
                    HashMap<String, String> rgAsignaciones = new HashMap<>();

                    File rgCarpeta = new File(carpetaCSV);
                    if (!rgCarpeta.isDirectory()) {
                        System.out.println("La ruta proporcionada no es una carpeta válida.");
                        return;
                    }

                    File[] rgArchivosCSV = rgCarpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

                    for (File rgArchivo : rgArchivosCSV) {
                        leerArchivoCSV(rgArchivo.getAbsolutePath(), rgTemasAsignados, rgAsignaciones);
                    }

                    System.out.println("[+] Listado de temas asignados:");

                    for (String rgTema : rgTemasAsignados) {
                        System.out.println("\t-" + rgAsignaciones.get(rgTema));
                    }

                    break;
                case 3:
                    System.out.println(
                            "Hora\t(l) Lunes\t(m) Martes\t(x) Miercoles\t(j) Jueves\t(v) Viernes\t(s)Sabado\t");
                    break;
                case 4:

                    break;
                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (rgControl == true);

    }

     public static void leerArchivoCSV(String rgArchivo, HashSet<String> rgTemasAsignados, HashMap<String, String> rgAsignaciones) {
        try (BufferedReader rgBr = new BufferedReader(new FileReader(rgArchivo))) {
            String rgLinea;
            while ((rgLinea = rgBr.readLine()) != null) {
                String[] rgDatos = rgLinea.split(";");
                if (rgDatos.length >= 3) {
                    String rgTema = rgDatos[2];
                    String rgAsignatura = rgDatos[1] + "-" + rgDatos[3] + "\t" + rgDatos[2];
                    rgTemasAsignados.add(rgTema);
                    rgAsignaciones.put(rgTema, rgAsignatura);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void rgImprimirListadoSinRepetidos(HashSet<String> rgElementosArchivo) {
    //     System.out.println("[+] Listado de <<tema-asignado>>:");

    //     for (String rgTemaAsignado : rgElementosArchivo) {
    //         System.out.println("\t- " + rgTemaAsignado);
    //     }
    // }

    public static boolean rgRepetirMenu() {
        boolean rgControl;
        System.out.println("\n Desea repetir el proceso SI O NO");
        String rgRespuesta = RGUtil.sc.nextLine();
        if (rgRespuesta.equalsIgnoreCase("SI")) {
            rgControl = true;
        } else {
            rgControl = false;
        }
        return rgControl;
    }

    private static void rgOpcionesMenu() {
        System.out.println(RGColor.BOLD_BRIGHT_YELLOW + "1. Visualizar Alumnos");
        System.out.println(RGColor.BOLD_BRIGHT_YELLOW + "2. Visualizar Asignaturas");
        System.out.println(RGColor.BOLD_BRIGHT_YELLOW + "3. Visualizar Horario");
        System.out.println(RGColor.BOLD_BRIGHT_YELLOW + "4. Visualizar Horario de una asignatura");
        System.out.println(RGColor.BOLD_BRIGHT_YELLOW + "0. SALIR");
    }

    /**
     * Esta funcion recibe como parametro las constantes de
     * cedula, correo y nombre para presentarlas al inicio del progra
     * 
     * @param RGCEDULA
     * @param RGCORREO
     * @param RGNOMBRE
     */
    public static void rgPresentarDatos(String RGCEDULA, String RGCORREO, String RGNOMBRE) {
        System.out.println(RGColor.BOLD_CYAN + "-CEDULA: " + RGCEDULA);
        System.out.println(RGColor.BOLD_CYAN + "-CORREO: " + RGCORREO.toLowerCase());
        System.out.println(RGColor.BOLD_CYAN + "-NOMBRE: " + RGNOMBRE.toUpperCase() + "\n");
    }

    /**
     * Esta funcion controla el login para ingresar a la aplicacion
     * 
     * @return
     */
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
        System.exit(0);
        return false;
    }

    /**
     * Est funcion recibe como parametro un string que es la ruta donde se
     * encuentran los archivos imprime los nombres de los archivos CSV
     * en el directorio especificado.
     * 
     * @param rgDirectorio La ruta del directorio donde se buscarán los archivos
     *                     CSV.
     */
    public static void rgImprimirNombresArchivosCSV(String rgDirectorio) {
        File rgCarpeta = new File(rgDirectorio);

        // Verificar si el directorio existe y es una carpeta
        if (rgCarpeta.exists() && rgCarpeta.isDirectory()) {
            File[] rgArchivos = rgCarpeta.listFiles();

            // Recorrer los archivos en el directorio
            for (File rgArchivo : rgArchivos) {
                // Verificar si es un archivo CSV e imprimir el nombre sin .csv
                if (rgArchivo.isFile() && rgArchivo.getName().endsWith(".csv")) {
                    String rgNombreArchivo = rgArchivo.getName();
                    int rgIndicePunto = rgNombreArchivo.lastIndexOf('.');
                    if (rgIndicePunto > 0) {
                        String rgNombreSinExtension = rgNombreArchivo.substring(0, rgIndicePunto);
                        System.out.println(RGColor.BOLD_RED + rgNombreSinExtension);
                    }
                }
            }
        } else {
            System.out.println("El directorio especificado no existe.");
        }
    }
}
