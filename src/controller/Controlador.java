package controller;
import model.*;
import view.Validaciones;
import view.Mostrar;

import java.util.Calendar;

public class Controlador {
    static final int F = 2;
    static final int G = 2;
    static final int C = 3;
    static final int D = 5;

    public Controlador(){

    }

    public void ingresarFacturas(){
        Facturas[] facturas = new Facturas[F];

        Calendar actual = Calendar.getInstance();
        int diaActual = actual.get(Calendar.DAY_OF_MONTH);
        int mesActual = actual.get((Calendar.MONTH) + 1);
        int anioAcual = actual.get(Calendar.YEAR);


    }


    public static Clientes[] ingresarClientes(){
        Clientes[] clientes = new Clientes[C];

        Mostrar.mostrar("Ingreso de clientes");
        for(int i = 0; i < C; i++) {
            Mostrar.mostrar("Cliente: " + (i + 1));

            Mostrar.mostrar("Ingresar CUIT: ");
            clientes[i].setCuit(Validaciones.validarLong());

            clientes[i].setRazonSocial(Validaciones.ingresar("razon social: "));

            Mostrar.mostrar("Ingresar true si es responsable inscripto o false si no lo es: ");
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
                Mostrar.mostrar("Ingresar true si hay 2x1 o false en caso contrario: ");
                ((PorPaquete) golosinas[i]).setPromocion(Validaciones.validarBoolean());

                Mostrar.mostrar("Ingresar deposito: ");
                ((PorPaquete) golosinas[i]).setDeposito(ingresarDepositos());
            } else {
                Mostrar.mostrar("Ingresar true si esta en oferta o false en caso contrario: ");
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

            Mostrar.mostrar("Ingresar true si es propio o false en caso contrario: ");
            depositos[i].setPropio(Validaciones.validarBoolean());
        }
        return depositos;
    }

}