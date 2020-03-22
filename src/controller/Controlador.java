package controller;
import model.*;
import view.Validaciones;

import java.util.Calendar;
import java.util.Scanner;

public class Controlador {
    static final int F = 2;
    static final int G = 2;
    static final int C = 3;
    static final int D = 5;

    Facturas facturas[] = new Facturas[F];
    Golosinas golosinas[] = new Golosinas[G];

    Calendar actual = Calendar.getInstance();
    Scanner stdin = new Scanner(System.in);

    public Controlador() {
    }

    public void ingresarClientes(){

    }
    public void ingresarFacturas(){
        Calendar actual = Calendar.getInstance();
        int diaActual = actual.get(Calendar.DAY_OF_MONTH);
        int mesActual = actual.get((Calendar.MONTH) + 1);
        int anioAcual = actual.get(Calendar.YEAR);


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
}