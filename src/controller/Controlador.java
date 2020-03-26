package controller;
import model.*;
import view.Validaciones;
import view.Mostrar;

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

    public Controlador(){

    }

    Facturas[] facturas = new Facturas[F];

    public void ingresarFacturas(){
        Mostrar.mostrar("Ingreso de facturas");
        for(int i = 0; i < F; i++) {
            Mostrar.mostrar("Factura: " + (i + 1));
            facturas[i].setNumFactura(i);

            Calendar actual = Calendar.getInstance();
            int diaActual = actual.get(Calendar.DAY_OF_MONTH);
            int mesActual = actual.get((Calendar.MONTH) + 1);
            int anioAcual = actual.get(Calendar.YEAR);

            facturas[i].setFechaEmision(actual);

            Calendar venc = Calendar.getInstance();
            venc.add(Calendar.DATE,30);
            int diaVenc = venc.get(Calendar.DAY_OF_MONTH);
            int mesVenc = venc.get((Calendar.MONTH) + 1);
            int anioVenc = venc.get(Calendar.YEAR);

            facturas[i].setFechaVencimiento(venc);

            Mostrar.mostrar("Ingresar centro emisor: ");
            facturas[i].setCentroEmisor(Validaciones.validarInt());

            Mostrar.mostrar("Clientes: ");
            Clientes[] clientes = ingresarClientes();
            Mostrar.mostrar("\t\t\t\t\t\t\t\tCliente\t\tCUIT\t\tRazon Social\t\tResponsable Inscripto");
            for (int j = 0; j < clientes.length; j++) {
                Mostrar.mostrar("Cliente"+ j +": "
                        + clientes[j].getCuit() + "\t\t"
                        + clientes[j].getRazonSocial() + "\t\t"
                        + (clientes[j].isCondicionIVA() ?  "si" : "no") );
            }

            Mostrar.mostrar("Ingresar numero de cliente de la factura: ");
            int pos = Validaciones.limite(0, clientes.length);

            facturas[i].setCliente(clientes[pos]);

//            if (facturas[i].getCliente().isCondicionIVA()){}

            Mostrar.mostrar("Ingresar items de la factura: ");

            for (int j = 0; j < I; j++){
                Mostrar.mostrar("Item: " + ( j + 1));

                Golosinas[] golosinas = ingresarGolosinas();
                Mostrar.mostrar("\t\t\t\t\t\t\t\tGolosina\t\tCodigo\t\tDescripcion\t\tPrecio Unitario");
                for (int k = 0; k < golosinas.length; k++) {
                    Mostrar.mostrar("Golosina"+ k +": "
                            + golosinas[k].getCodigo() + "\t\t"
                            + golosinas[k].getDescripcion() + "\t\t"
                            + golosinas[k].getPrecioUnitario());
                }

                Mostrar.mostrar("Ingresar numero de golosina del item: ");
                pos = Validaciones.limite(0, golosinas.length);

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
        for (Facturas fact: facturas
             ) {
            Mostrar.mostrar("Nombre de Tienda");
            Mostrar.mostrar(fact.getNombreTienda());
            Mostrar.mostrar("\t\t\t\t\t\t\t\tFactura\t\tFecha de Emision\t\tFecha de Vencimiento\t\tCentro Emisor\t\tCliente\t\tItems de Factura\t\t");

            Mostrar.mostrar("Factura"+ fact.getNumFactura() +": "
                    + fact.getFechaEmision() + "\t\t"
                    + fact.getFechaVencimiento() + "\t\t"
                    + fact.getCentroEmisor() + "\t\t"
                    + fact.getCliente() + "\t\t"
                    + fact.getItemsDeFactura());

        }

//        fechaEmision;
//        protected Calendar fechaVencimiento;
//        protected static int centroEmisor;
//        protected long numFactura;
//        protected Clientes cliente;
//        protected ItemsDeFactura[] itemsDeFactura = new ItemsDeFactura[ITEMS];
//        protected static final String nombreTienda = "TO DO DULCE";
//        protected Pagos pago;
    }

    public static Clientes[] ingresarClientes(){
        Clientes[] clientes = new Clientes[C];

        Mostrar.mostrar("Ingreso de clientes");
        for(int i = 0; i < C; i++) {
            Mostrar.mostrar("Cliente: " + (i + 1));

            Mostrar.mostrar("Ingresar CUIT: ");
            clientes[i].setCuit(Validaciones.validarLong());

            clientes[i].setRazonSocial(Validaciones.ingresar("razon social: "));

            Mostrar.mostrar("Ingresar (1) si es responsable inscripto o (0) en caso contrario: ");
            clientes[i].setCondicionIVA(Validaciones.validarBoolean());
        }
        return clientes;
    }

    public static Golosinas[] ingresarGolosinas(){
        Golosinas[] golosinas = new Golosinas[G];

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

                Mostrar.mostrar("Depositos: ");
                Depositos[] depositos = ingresarDepositos();
                Mostrar.mostrar("\t\t\t\t\t\t\t\tDeposito\t\tNombre\t\tPropio");
                for (int j = 0; j < depositos.length; j++) {
                    Mostrar.mostrar("Deposito"+ j +": "
                            + depositos[j].getNombre() + "\t\t"
                            + (depositos[j].isPropio() ?  "si" : "no") );
                }

                Mostrar.mostrar("Ingresar cant de depositos donde se encuentra la golosina: ");
                cant = Validaciones.limite(0, depositos.length);
                Depositos[] aux = new Depositos[cant];
                for(int j = 0; j < cant; j++) {
                    Mostrar.mostrar("Ingresar numero de deposito de la golosina: ");
                    int pos = Validaciones.limite(0, depositos.length);
                    aux[j] = depositos[pos];
                }
                ((PorPaquete) golosinas[i]).setDeposito(aux);

            } else {
                Mostrar.mostrar("Ingresar (1) si esta en oferta o (0) en caso contrario: ");
                ((PorKilo) golosinas[i]).setOferta(Validaciones.validarBoolean());
            }
        }
        return golosinas;
    }

    public static  Depositos[] ingresarDepositos(){
        Depositos[] depositos = new Depositos[D];

        Mostrar.mostrar("Ingreso de depositos");
        for(int i = 0; i < D; i++) {
            Mostrar.mostrar("Deposito: " + (i + 1));

            depositos[i].setNombre(Validaciones.ingresar("nombre: "));
            depositos[i].setDomicilio(Validaciones.ingresar("domicilio: "));

            Mostrar.mostrar("Ingresar (1) si es propio o (0) en caso contrario: ");
            depositos[i].setPropio(Validaciones.validarBoolean());
        }
        return depositos;
    }


}