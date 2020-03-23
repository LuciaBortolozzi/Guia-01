package controller;
import model.*;
import view.Validaciones;
import view.Mostrar;

import java.util.Calendar;
import java.util.Scanner;

public class Controlador {
    static final int F = 2;
    static final int G = 2;
    static final int C = 3;
    static final int D = 5;

    public Controlador(){

    }

    public void ingresarFacturas(){
        Facturas facturas[] = new Facturas[F];

        Calendar actual = Calendar.getInstance();
        int diaActual = actual.get(Calendar.DAY_OF_MONTH);
        int mesActual = actual.get((Calendar.MONTH) + 1);
        int anioAcual = actual.get(Calendar.YEAR);


    }


    public static void ingresarClientes(){
        Clientes clientes[] = new Clientes[C];

        Mostrar.mostrar("Ingreso de clientes");
        for(int i = 0; i < C; i++) {
            Mostrar.mostrar("Cliente: " + (i + 1));

            Mostrar.mostrar("Ingresar CUIT: ");
            clientes[i].setCuit(Validaciones.validarLong());

            clientes[i].setRazonSocial(Validaciones.ingresar("razon social: "));

            Mostrar.mostrar("Ingresar true si es responsable inscripto o false si no lo es: ");
            clientes[i].setCondicionIVA(Validaciones.validarBoolean());
        }
    }

    public static void ingresarGolosinas(){
        Golosinas golosinas[] = new Golosinas[G];

        Mostrar.mostrar("Ingreso de golosinas");
        for(int i = 0; i < G; i++) {
            Mostrar.mostrar("Golosina: " + (i + 1));
            Mostrar.mostrar("(1) Por paquete o (2) Por kilo: ");
            int tipo = Validaciones.tipo();
            if (tipo == 1) {
                golosinas[i] = new PorPaquete();
            } else {
                golosinas[i] = new PorKilo();
            }

            Mostrar.mostrar("Ingresar codigo: ");
            golosinas[i].setCodigo(Validaciones.validarInt());
            
            

        }

    }

    public static void ingresoDepositos(){
        Depositos depositos[] = new Depositos[D];

        Mostrar.mostrar("Ingreso de depositos");
        for(int i = 0; i < D; i++) {

        }

    }
}