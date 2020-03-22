package view;
import java.util.*;

public class Validaciones {
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }

    public Validaciones() {
    }

    public static int validarInt(){
        int x;
        do {
            while (!scan.hasNextInt()){
                Mostrar.mostrar("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextInt();
        } while ( x <= 0 );
        return x;
    }

    public static long validarLong(){
        long x;
        do {
            while (!scan.hasNextLong()){
                Mostrar.mostrar("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextLong();
        } while ( x <= 0 );
        return x;
    }

    public static double validarDouble() {
        double x;
        do {
            while (!scan.hasNextDouble()){
                Mostrar.mostrar("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextDouble();
        } while ( x <= 0 );
        return x;
    }

    public static boolean validarBoolean() {
        return scan.nextBoolean();
    }

    public static int validarAnio() {
        int x;
        do {
            while (!scan.hasNextInt()){
                Mostrar.mostrar("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextInt();
        } while ( x < 1900 );
        return x;
    }

    public static int validarMes() {
        int x;
        do {
            while (!scan.hasNextInt()){
                Mostrar.mostrar("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextInt();
        } while ( x < 1 || x > 12 );
        return x;
    }

    public static int validarDia() {
        int x;
        do {
            while (!scan.hasNextInt()){
                Mostrar.mostrar("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextInt();
        } while ( x < 1 || x > 31 );
        return x;
    }

    public static boolean decision(){
        int x;
        do {
            while (!scan.hasNextInt()) {
                System.out.println("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextInt();
        } while (x != 1 && x != 2);

        if (x == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int limite(int a, int b){
        int x;
        do {
            while (!scan.hasNextInt()) {
                System.out.println("Incorrecto, ingresar nuevamente: ");
                scan.nextLine();
            }
            x = scan.nextInt();
        } while (x < a || x > b);
        return x;
    }

    public static String ingresar(String ingreso) {
        System.out.println("Ingresar: " + ingreso);
        String texto = "";
        while (texto.equals("")) {
            texto = scan.nextLine();
        }
        return texto;
    }

    public static String ingresar(String ingreso, boolean toUpper) {
        System.out.println("Ingresar: " + ingreso);
        String texto = "";
        while (texto.equals("")) {
            texto = scan.nextLine();
        }
        if(toUpper) {
            return texto.toUpperCase();
        } else {
            return texto;
        }
    }
}
