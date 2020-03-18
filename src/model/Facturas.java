package model;

import java.util.Calendar;

public abstract class Facturas implements ICalculable{
    Calendar fechaEmision;
    Calendar fechaVencimiento;
    int centroEmisor;
    long numFactura;
    Clientes cliente;
    ItemsDeFactura[] itemsDeFactura;
    String nombreTienda;
    Pagos pago;


}
