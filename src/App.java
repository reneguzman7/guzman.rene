import Utilitario.Util;

public class App {
    public static void main(String[] args) {

        Util.clear();

        rgPresentarDatos();


        rgLoginRene();
        


















        
    }

    public static void rgPresentarDatos() {
        final String CEDULA = "1750366286";
        final String CORREO = "RENE.GUZMAN@EPN.EDU.EC";
        final String NOMBRE = "rene alejandro guzman moreira";

        System.out.println("-CEDULA: " + CEDULA);
        System.out.println("-CORREO: " + CORREO.toLowerCase());
        System.out.println("-NOMBRE: " + NOMBRE.toUpperCase());
    }

     public static boolean rgLoginRene() {
        int rgIntentosMax = 0;
        String rgUser;
        String rgClave;

        do {
            System.out.println("-------------------");
            System.out.print("+ Usuario: ");
            rgUser = Util.sc.nextLine();
            System.out.print("+ Clave: ");
            rgClave = Util.sc.nextLine();
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
}
