import java.util.Calendar;
import java.util.Scanner;

public class Main {
    static final int F = 2;
    static final int G = 2;
    static final int C = 3;
    static final int D = 5;

    public static void main(String[] args) throws Exception {

        Facturas facturas[] = new Facturas[F];
        Golosinas golosinas[] = new Golosinas[G];
        double calorias = Double.parseDouble(args[0]);

        Calendar actual = Calendar.getInstance();
        Scanner stdin = new Scanner(System.in);

        ingresoClientes();
        Menu();
    }
    
    public static void ingresoClientes(){
        Clientes clientes[] = new Clientes[C];

        System.out.println("Ingreso de clientes");
        for(int i = 0; i < C; i++) {
            System.out.println("Cliente: " + (i + 1));

            System.out.println("Ingresar CUIT: ");
            clientes[i].setCuit(Validaciones.validarLong());

            clientes[i].setRazonSocial(Validaciones.ingresar("razon social: "));

            System.out.println("Ingresar true si es responsable inscripto o false si no lo es: ");
            clientes[i].setCondicionIVA(Validaciones.validarBoolean());
        }
    }

    public static void ingresoGolosinas(){
        Golosinas golosinas[] = new Golosinas[G];

        System.out.println("Ingreso de golosinas");
        for(int i = 0; i < G; i++) {

        }

    }

    public static void Menu(){
        do {
            System.out.println("MENU");

            System.out.println("0. Ingresar por teclado, la información correspondiente a cada una de las facturas\n" +
                    "generadas. Mostrar por pantalla cada factura registrada, incluyendo todos sus datos,\n" +
                    "el nombre de la tienda, datos de las golosinas, precios, subtotales, IVA y totales con 3\n" +
                    "valores decimales.\n");

            System.out.println("1. Ingresar por teclado los datos de los clientes, golosinas y depósitos con los que opera\n" +
                    "la tienda.\n");

            System.out.println("2. A partir de un número de factura ingresado por teclado, registrar el pago de la misma\n" +
                    "o bien, modificar el existente.\n");

            System.out.println("3. Para cada uno de los clientes, mostrar su CUIT y razón social, números de factura\n" +
                    "correspondientes, tipo (factura A o B), fecha de emisión y de vencimiento de aquellas\n" +
                    "emitidas durante los dos últimos meses. Incluir la descripción, cantidad, precio de las\n" +
                    "golosinas vendidas y si tiene alguna promoción o descuento aplicado.");

            System.out.println("4. Mostrar por pantalla los números de facturas vencidas impagas, ordenados en forma\n" +
                    "descendente cuyo importe total vendido supere el valor ingresado como argumento de\n" +
                    "la aplicación y se trate de ventas exclusivas de golosinas por peso.\n");

            System.out.println("5. Mediante el uso de datos miembros de tipo estático incluido en una clase del modelo,\n" +
                    "mostrar la cantidad de facturas B generadas.\n");

            System.out.println("6. Para cada periodo del año actual (mes y año), mostrar por pantalla la cantidad de\n" +
                    "facturas A emitidas, la cantidad de facturas B emitidas y el total de IVA a informar a la\n" +
                    "AFIP (total de IVA facturado).\n");

            System.out.println("7. Indicar la cantidad de golosinas en paquete, que no fueron vendidas durante el año en\n" +
                    "curso a ningún cliente responsable inscripto.\n");

            System.out.println("8. Mostrar por pantalla, número de factura, fecha de pago (si existe) de todas las\n" +
                    "facturas cuyas golosinas vendidas comienzan con las dos primeras letras ingresadas\n" +
                    "por teclado.\n");

            System.out.println("9. Salir del menu");

            int opcion = Validaciones.limite(0, 9);

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
