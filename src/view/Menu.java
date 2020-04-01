package view;

import controller.Controlador;

public class Menu {

    Controlador controlador = new Controlador();

    public void menu(String args){

        do {
            Mostrar.mostrar("MENU");

            Mostrar.mostrar("0. Ingresar por teclado los datos de los clientes, golosinas y depósitos con los que opera\n" +
                    "la tienda.\n");

            Mostrar.mostrar("1. Ingresar por teclado, la información correspondiente a cada una de las facturas\n" +
                    "generadas. Mostrar por pantalla cada factura registrada, incluyendo todos sus datos,\n" +
                    "el nombre de la tienda, datos de las golosinas, precios, subtotales, IVA y totales con 3\n" +
                    "valores decimales.\n");

            Mostrar.mostrar("2. A partir de un número de factura ingresado por teclado, registrar el pago de la misma\n" +
                    "o bien, modificar el existente.\n");

            Mostrar.mostrar("3. Para cada uno de los clientes, mostrar su CUIT y razón social, números de factura\n" +
                    "correspondientes, tipo (factura A o B), fecha de emisión y de vencimiento de aquellas\n" +
                    "emitidas durante los dos últimos meses. Incluir la descripción, cantidad, precio de las\n" +
                    "golosinas vendidas y si tiene alguna promoción o descuento aplicado.");

            Mostrar.mostrar("4. Mostrar por pantalla los números de facturas vencidas impagas, ordenados en forma\n" +
                    "descendente cuyo importe total vendido supere el valor ingresado como argumento de\n" +
                    "la aplicación y se trate de ventas exclusivas de golosinas por peso.\n");

            Mostrar.mostrar("5. Mediante el uso de datos miembros de tipo estático incluido en una clase del modelo,\n" +
                    "mostrar la cantidad de facturas B generadas.\n");

            Mostrar.mostrar("6. Para cada periodo del año actual (mes y año), mostrar por pantalla la cantidad de\n" +
                    "facturas A emitidas, la cantidad de facturas B emitidas y el total de IVA a informar a la\n" +
                    "AFIP (total de IVA facturado).\n");

            Mostrar.mostrar("7. Indicar la cantidad de golosinas en paquete, que no fueron vendidas durante el año en\n" +
                    "curso a ningún cliente responsable inscripto.\n");

            Mostrar.mostrar("8. Mostrar por pantalla, número de factura, fecha de pago (si existe) de todas las\n" +
                    "facturas cuyas golosinas vendidas comienzan con las dos primeras letras ingresadas\n" +
                    "por teclado.\n");

            Mostrar.mostrar("9. Salir del menu");

            int opcion = Validaciones.limite(0, 9);

            switch (opcion){
                case 0:
                    controlador.ingresarClientes();
                    controlador.ingresarDepositos();
                    controlador.ingresarGolosinas();
                    break;
                case 1:
                    controlador.ingresarFacturas();
                    controlador.mostrarFacturas();
                    break;
                case 2:
                    controlador.registrarPago();
                    break;
                case 3:
                    controlador.ultimosDosMeses();
                    break;
                case 4:
                    controlador.factVencImpagas(args);
                    break;
                case 5:
                    controlador.facturasBGeneradas();
                    break;
                case 6:
                    controlador.informeIVA();
                    break;
                case 7:
                    controlador.noVendidasARespIns();
                    break;
                case 8:
                    controlador.golosinasDosLetras();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}