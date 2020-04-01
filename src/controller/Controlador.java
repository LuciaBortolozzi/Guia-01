package controller;
import model.*;
import view.Validaciones;
import view.Mostrar;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Controlador {
    private static final int F = 2;
    private static final int G = 2;
    private static final int C = 3;
    private static final int D = 5;
    private static final int I = 2;
    private static final char TARJETA_DEBITO = 'D';
    private static final char TARJETA_CREDITO = 'C';
    private static final char TRANSFERENCIA = 'T';

    Facturas[] facturas = new Facturas[F];
    Clientes[] clientes = new Clientes[C];
    Golosinas[] golosinas = new Golosinas[G];
    Depositos[] depositos = new Depositos[D];

    public Controlador(){

    }

    public void ingresarFacturas(){
//        Ingresar por teclado, la información correspondiente a cada una de las facturas generadas.

        Mostrar.mostrar("Ingreso de facturas");
        for(int i = 0; i < F; i++) {

            //Primero agrego el cliente para saber si se trata de factura A o B

            Mostrar.mostrar("Agregar el cliente correspondiente: ");
            Mostrar.mostrar("\t\t\t\t\t\t\t\tCliente\t\tCUIT\t\tRazon Social\t\tResponsable Inscripto");
            for (int j = 0; j < clientes.length; j++) {
                Mostrar.mostrar("Cliente"+ j +": "
                        + clientes[j].getCuit() + "\t\t"
                        + clientes[j].getRazonSocial() + "\t\t"
                        + (clientes[j].isCondicionIVA() ?  "si" : "no") );
            }

            int pos = -1;
            do {
                Mostrar.mostrar("Ingresar cuit del cliente de la factura: ");
                long cuit = Validaciones.validarLong();

                for (int j = 0; j < clientes.length; j++) {
                    if (clientes[j].getCuit() == cuit) {
                        pos = j;
                        break;
                    }
                }
                if (pos == -1){
                    System.out.println("No se encontro el cliente.");
                }
            } while(pos == -1);

            if (facturas[i].getCliente().isCondicionIVA()){
                facturas[i] = new FacturaA();
            } else {
                facturas[i] = new FacturaB();
            }

            facturas[i].setCliente(clientes[pos]);

            Mostrar.mostrar("Factura: " + (i + 1));
            facturas[i].setNumFactura(i);

            Calendar actual = Calendar.getInstance();
            facturas[i].setFechaEmision(actual);

            Calendar venc = Calendar.getInstance();
            venc.add(Calendar.DATE,30);

            facturas[i].setFechaVencimiento(venc);

            Mostrar.mostrar("Ingresar centro emisor: ");
            facturas[i].setCentroEmisor(Validaciones.validarInt());

            Mostrar.mostrar("Ingresar items de la factura: ");

            for (int j = 0; j < I; j++){
                Mostrar.mostrar("Item: " + ( j + 1));

                //Agrego golosina
                Mostrar.mostrar("\t\t\t\t\t\t\t\tGolosina\t\tCodigo\t\tDescripcion\t\tPrecio Unitario");
                for (int k = 0; k < golosinas.length; k++) {
                    Mostrar.mostrar("Golosina"+ k +": "
                            + golosinas[k].getCodigo() + "\t\t"
                            + golosinas[k].getDescripcion() + "\t\t"
                            + golosinas[k].getPrecioUnitario());
                }

                pos = -1;
                do {
                    Mostrar.mostrar("Ingresar codigo de golosina del item: ");
                    int cod = Validaciones.validarInt();

                    for (int k = 0; k < golosinas.length; k++) {
                        if (golosinas[k].getCodigo() == cod) {
                            pos = k;
                            break;
                        }
                    }
                    if (pos == -1){
                        System.out.println("No se encontro la golosina.");
                    }
                } while(pos == -1);

                Mostrar.mostrar("Ingresar cantidad de golosina: ");
                int cant = Validaciones.validarInt();

                facturas[i].setItemsDeFactura( j, golosinas[pos], cant);
            }

            Mostrar.mostrar("¿Desea ingresar pago de la factura? (1) si o (0) no: ");

            if (Validaciones.validarBoolean()){
                Mostrar.mostrar("Numero de Recibo: " + ( i + 1));
                Mostrar.mostrar("Ingresar numero de transaccion: ");
                int nTr = Validaciones.validarInt();

                Mostrar.mostrar("Ingresar forma de pago: ");
                Mostrar.mostrar("1. Tarjeta de debito\n" +
                                        "2. Tarjeta de credito\n" +
                                        "3. Trasferencia bancaria\n");
                int eleccion = Validaciones.limite(1,3);
                char formaDePago;
                switch (eleccion){
                    case 1:
                        formaDePago = TARJETA_DEBITO;
                        break;
                    case 2:
                        formaDePago = TARJETA_CREDITO;
                        break;
                    default:
                        formaDePago = TRANSFERENCIA;
                        break;
                }

                facturas[i].setPago(actual,formaDePago,i,nTr);
            }
        }
    }

    public void mostrarFacturas() {
//        Mostrar por pantalla cada factura registrada, incluyendo todos sus datos, el nombre de la tienda, datos de las golosinas, precios, subtotales, IVA y totales con 3 valores decimales

        Mostrar.mostrar("Nombre de Tienda: " + facturas[0].getNombreTienda());    // Es siempre el mismo
        for (Facturas fact: facturas
             ) {

            if (fact instanceof FacturaA){
                Mostrar.mostrar("Factura A");
            } else {
                Mostrar.mostrar("Factura B");
            }

            Mostrar.mostrar("Factura: " + "000" + fact.getCentroEmisor() + "-" + "0000000" + fact.getNumFactura() + "\n"
                    + "Fecha de emision: " + fact.getFechaEmision().get(Calendar.DAY_OF_MONTH) + "/" +
                                            fact.getFechaEmision().get((Calendar.MONTH) + 1) + "/" +
                                            fact.getFechaEmision().get(Calendar.YEAR) + "\n"
                    + "Fecha de vencimiento: " + fact.getFechaVencimiento().get(Calendar.DAY_OF_MONTH) + "/" +
                                                fact.getFechaVencimiento().get((Calendar.MONTH) + 1) + "/" +
                                                fact.getFechaVencimiento().get(Calendar.YEAR) + "\n"
                    + "Centro Emisor: " + fact.getCentroEmisor());

            Mostrar.mostrar("CUIT del cliente: " + fact.getCliente().getCuit() + "\n"
                    + "Razon Social del cliente: " + fact.getCliente().getRazonSocial() + "\n"
                    + "Responsable inscripto: " + (fact.getCliente().isCondicionIVA() ?  "si" : "no"));

            for (ItemsDeFactura item: fact.getItemsDeFactura()
                 ) {
                Mostrar.mostrar("Codigo de golosina: " + item.getGolosina().getCodigo() + "\n"
                + "Descripcion de golosina: " + item.getGolosina().getDescripcion() + "\n");
                Mostrar.mostrar("Sabores de golosina: ");
                for (int i = 0; i < item.getGolosina().getSabores().length; i++){
                    Mostrar.mostrar(item.getGolosina().getSabores()[i]);
                }
                Mostrar.mostrar("Precio unitario: " + item.getGolosina().getPrecioUnitario());
                Mostrar.mostrar("Cantidad de golosina: " + item.getCantidad());
            }
            DecimalFormat formato = new DecimalFormat("#.##");

            if (fact instanceof FacturaA){
                double iva = fact.calcularTotal()*ICalculable.IVA;

                Mostrar.mostrar("Subtotal: " + formato.format(fact.calcularTotal()) + "\n"
                + "IVA: " + formato.format(iva) + "\n"
                + "Total: " + formato.format((fact.calcularTotal()+iva)));
            } else {
                Mostrar.mostrar("Total: " + formato.format(fact.calcularTotal()));
            }

            if (fact.getPago() != null){
                Mostrar.mostrar("Fecha del dia: " + fact.getPago().getFechaDelDia().get(Calendar.DAY_OF_MONTH) + "/" +
                        fact.getPago().getFechaDelDia().get((Calendar.MONTH) + 1) + "/" +
                        fact.getPago().getFechaDelDia().get(Calendar.YEAR) + "\n"
                        + "Forma de pago: "
                        + (fact.getPago().getFormaDePago() == TARJETA_DEBITO ? "Tarjeta de debito":
                                (fact.getPago().getFormaDePago() == TARJETA_CREDITO ? "Tarjeta de credito":
                                        "Transferencia"))+ "\n"
                        + "Numero de recibo: " + fact.getPago().getNumRecibo() + "\n"
                        + "Numero de transaccion: " + fact.getPago().getNumTransaccion());
            }
        }
    }

    public void ingresarClientes(){
//        Ingresar por teclado los datos de los clientes con los que opera la tienda.

        Mostrar.mostrar("Ingreso de clientes");
        for(int i = 0; i < C; i++) {
            clientes[i] = new Clientes();

            Mostrar.mostrar("Cliente: " + (i + 1));

            Mostrar.mostrar("Ingresar CUIT: ");
            clientes[i].setCuit(Validaciones.validarLong());

            clientes[i].setRazonSocial(Validaciones.ingresar("razon social: "));

            Mostrar.mostrar("Ingresar (1) si es responsable inscripto o (0) en caso contrario: ");
            clientes[i].setCondicionIVA(Validaciones.validarBoolean());
        }
    }

    public void ingresarGolosinas(){
//        Ingresar por teclado los datos de las golosinas con los que opera la tienda.

        Mostrar.mostrar("Ingreso de golosinas");
        for(int i = 0; i < G; i++) {
            Mostrar.mostrar("Golosina: " + (i + 1));
            Mostrar.mostrar("(1) Por paquete \n(2) Por kilo\n ");
            int tipo = Validaciones.tipo();
            if (tipo == 1) {
                golosinas[i] = new PorPaquete();
            } else {
                golosinas[i] = new PorKilo();
            }

            Mostrar.mostrar("Ingresar codigo: ");
            golosinas[i].setCodigo(Validaciones.validarInt());

            golosinas[i].setDescripcion(Validaciones.ingresar("descripcion: "));

            Mostrar.mostrar("Sabores posibles: acido, agrio, amargo, dulce, salado, picante");
            Mostrar.mostrar("Ingresar cantidad de sabores (max 6): ");
            int cant = Validaciones.limite(1, 6);
            String[] sabores = new String[cant];
            for(int j = 0; j < cant; j++) {
                Mostrar.mostrar("Ingresar sabores: \n0. acido \n1. agrio \n2. amargo \n3. dulce \n4. salado \n5. picante ");
                int sabor = Validaciones.limite(0, 5);
                sabores[j] = ICalculable.SABORES[sabor];
            }
            golosinas[i].setSabores(sabores);

            Mostrar.mostrar("Ingresar precio unitario: ");
            golosinas[i].setPrecioUnitario(Validaciones.validarDouble());

            if (golosinas[i] instanceof PorPaquete){
                Mostrar.mostrar("Ingresar (1) si hay 2x1 o (0) en caso contrario: ");
                ((PorPaquete) golosinas[i]).setPromocion(Validaciones.validarBoolean());

                for (int j = 0; j < depositos.length; j++) {
                    Mostrar.mostrar("Deposito"+ j +": "
                            + depositos[j].getNombre() + "\t\t"
                            + (depositos[j].isPropio() ?  "si" : "no") );
                }

                // Array de depositos auxiliar
                Mostrar.mostrar("Ingresar cantidad de depositos en donde se encuentra la golosina: ");
                cant = Validaciones.limite(0, depositos.length);
                Depositos[] aux = new Depositos[cant];
                for(int j = 0; j < aux.length; j++){
                    aux[j] = new Depositos();
                }

                //Busqueda de depositos para agregar
                String nombre = "";
                int pos = -1;
                int k = 0;
                do {
                    for (int j = 0; j < depositos.length; j++) {
                        Mostrar.mostrar("¿En que deposito se encuentran las golosinas? ");
                        nombre = Validaciones.ingresar("nombre: ");

                        if (depositos[j].getNombre().equals(nombre)) {
                            pos = j;
                            aux[k] = depositos[j];
                            k++;
                            break;
                        }
                    }
                    if (pos == -1){
                        System.out.println("No se encontro ningun deposito.");
                    }
                } while(pos == -1);
                ((PorPaquete) golosinas[i]).setDepositos(aux);

            } else {
                Mostrar.mostrar("Ingresar (1) si esta en oferta o (0) en caso contrario: ");
                ((PorKilo) golosinas[i]).setOferta(Validaciones.validarBoolean());
            }
        }
    }

    public void ingresarDepositos(){
//        Ingresar por teclado los datos de los depósitos con los que opera la tienda.

        Mostrar.mostrar("Ingreso de depositos");
        for(int i = 0; i < D; i++) {
            depositos[i] = new Depositos();

            Mostrar.mostrar("Deposito: " + (i + 1));

            depositos[i].setNombre(Validaciones.ingresar("nombre: "));
            depositos[i].setDomicilio(Validaciones.ingresar("domicilio: "));

            Mostrar.mostrar("Ingresar (1) si es propio o (0) en caso contrario: ");
            depositos[i].setPropio(Validaciones.validarBoolean());
        }
    }

    public void registrarPago(){
//        A partir de un número de factura ingresado por teclado, registrar el pago de la misma o bien, modificar el existente.

        Calendar actual = Calendar.getInstance();
        Mostrar.mostrar("Ingrese la factura, a la cual desea registrar/modificar pago: ");

        int pos = -1;
        do {
            Mostrar.mostrar("Ingresar numero de la factura: ");
            long nro = Validaciones.validarLong();
            for (int i = 0; i < facturas.length; i++) {
                if (facturas[i].getNumFactura() == nro) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1){
                System.out.println("No se encontro la factura.");
            }
        } while(pos == -1);

        if (facturas[pos].getPago() == null){
            Mostrar.mostrar("Registrar pago: ");
        } else {
            Mostrar.mostrar("Modificar pago: ");
        }

        Mostrar.mostrar("Numero de Recibo: " + ( pos + 1));
        Mostrar.mostrar("Ingresar numero de transaccion: ");
        int nTr = Validaciones.validarInt();

        Mostrar.mostrar("Ingresar forma de pago: ");
        Mostrar.mostrar("1. Tarjeta de debito\n" +
                                "2. Tarjeta de credito\n" +
                                "3. Trasferencia bancaria\n");
        int eleccion = Validaciones.limite(1,3);
        char formaDePago;
        switch (eleccion){
            case 1:
                formaDePago = TARJETA_DEBITO;
                break;
            case 2:
                formaDePago = TARJETA_CREDITO;
                break;
            default:
                formaDePago = TRANSFERENCIA;
                break;
        }
        facturas[pos].setPago(actual,formaDePago,pos,nTr);
    }

    public void ultimosDosMeses(){
//        Para cada uno de los clientes, mostrar su CUIT y razón social, números de factura correspondientes, tipo (factura A o B),
//        fecha de emisión y de vencimiento de aquellas emitidas durante los dos últimos meses.
//        Incluir la descripción, cantidad, precio de las golosinas vendidas y si tiene alguna promoción o descuento aplicado.





    }

    public void factVencImpagas(String args){
//        Mostrar por pantalla los números de facturas vencidas impagas, ordenados en forma
//        descendente cuyo importe total vendido supere el valor ingresado como argumento de
//        la aplicación y se trate de ventas exclusivas de golosinas por peso.

        Calendar actual = Calendar.getInstance();
        double importe = Double.parseDouble(args);

        for (int i = facturas.length; i >= 0; i--) {
            double total;

            if (facturas[i] instanceof FacturaA){
                double iva = facturas[i].calcularTotal()*ICalculable.IVA;
                total = facturas[i].calcularTotal()+iva;
            } else {
                total = facturas[i].calcularTotal();
            }

            if (facturas[i].getFechaVencimiento().before(actual) && facturas[i].getPago() == null){
                for (ItemsDeFactura item: facturas[i].getItemsDeFactura()
                     ) {
                    if (item.getGolosina() instanceof PorKilo && (total > importe)){
                        Mostrar.mostrar("Numero de factura vencida impaga: " + "000" + facturas[i].getCentroEmisor() + "-" + "0000000" + facturas[i].getNumFactura());
                    }
                }
            }
        }

    }

    public void facturasBGeneradas(){
//        Mediante el uso de datos miembros de tipo estático incluido en una clase del modelo,
//        mostrar la cantidad de facturas B generadas.

        int cant = 0;
        for (Facturas fact : facturas
        ){
            if (fact instanceof FacturaB){
                cant++;
                break;
            }
        }
        Mostrar.mostrar("La cantidad de facturas B generadas es de: " + cant);

    }

    public void informeIVA(){
//        Para cada periodo del año actual (mes y año), mostrar por pantalla la cantidad de facturas A emitidas,
//        la cantidad de facturas B emitidas y el total de IVA a informar a la AFIP (total de IVA facturado).

        Calendar actual = Calendar.getInstance();
        for (int i = 0; i < actual.get(Calendar.MONTH); i++){

        }
    }

    public void noVendidasARespIns(){
//        Indicar la cantidad de golosinas en paquete, que no fueron vendidas durante el año en curso a ningún cliente responsable inscripto.

        Calendar actual = Calendar.getInstance();
        int cant = 0;

        for (Facturas fact : facturas
        ){
            if ((fact.getFechaEmision().get(Calendar.YEAR) == actual.get(Calendar.YEAR)) && fact instanceof FacturaB){
                for (ItemsDeFactura item: fact.getItemsDeFactura()
                     ) {
                    if (item.getGolosina() instanceof PorPaquete){
                        cant++;
                    }
                }
            }
        }
    }

    public void golosinasDosLetras(){
//        Mostrar por pantalla, número de factura, fecha de pago (si existe) de todas las facturas
//        cuyas golosinas vendidas comienzan con las dos primeras letras ingresadas por teclado.

        String ingreso;
        String golosina;
        boolean encontrado = false;

        Mostrar.mostrar("Ingresar la golosina vendida que desea mostrar: ");
        ingreso = Validaciones.ingresar("golosinas vendidas: ");
        ingreso = ingreso.substring(0, 2);

        for (Facturas fact : facturas
             ) {
            for (ItemsDeFactura item: fact.getItemsDeFactura()
                 ) {
                golosina = item.getGolosina().getDescripcion().substring(0,2);
                if (golosina.equals(ingreso)){
                    encontrado = true;
                    break;
                }
            }
            if (encontrado){
                Mostrar.mostrar("Factura: " + "000" + fact.getCentroEmisor() + "-" + "0000000" + fact.getNumFactura());
                if (fact.getPago() != null){
                    Mostrar.mostrar("Fecha del pago: " + fact.getPago().getFechaDelDia().get(Calendar.DAY_OF_MONTH) + "/" +
                            fact.getPago().getFechaDelDia().get((Calendar.MONTH) + 1) + "/" +
                            fact.getPago().getFechaDelDia().get(Calendar.YEAR));
                }
            }
            encontrado = false;
        }


    }
}