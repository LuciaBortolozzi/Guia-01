package model;

import java.util.Calendar;

public abstract class Facturas implements ICalculable{

    protected static final int ITEMS = 2;

    protected Calendar fechaEmision;
    protected Calendar fechaVencimiento;
    protected static int centroEmisor;
    protected long numFactura;
    protected Clientes cliente;
    protected ItemsDeFactura[] itemsDeFactura = new ItemsDeFactura[ITEMS];
    protected static final String nombreTienda = "TODO DULCE";
    protected Pagos pago;

    public Facturas(Calendar fechaEmision, Calendar fechaVencimiento, int centroEmisor, long numFactura, Clientes cliente) {
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.centroEmisor = centroEmisor;
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.pago = new Pagos();

        for(int i = 0; i < ITEMS; i++){
            itemsDeFactura[i] = new ItemsDeFactura();
        }
    }

    public Facturas() {
        this.pago = new Pagos();

        for(int i = 0; i < ITEMS; i++){
            itemsDeFactura[i] = new ItemsDeFactura();
        }
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCentroEmisor() {
        return centroEmisor;
    }

    public void setCentroEmisor(int centroEmisor) {
        this.centroEmisor = centroEmisor;
    }

    public long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(long numFactura) {
        this.numFactura = numFactura;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ItemsDeFactura[] getItemsDeFactura() {
        return itemsDeFactura;
    }

    public void setItemsDeFactura(int posicion, Golosinas golosina, int cantidad) {
        itemsDeFactura[posicion].setGolosina(golosina);
        itemsDeFactura[posicion].setCantidad(cantidad);
    }

    public String getNombreTienda() {
        return nombreTienda;
    }


    public Pagos getPago() {
        return pago;
    }

    public void setPago(Calendar fechaDelDia, char formaDePago, int numRecibo, int numTransaccion) {
        pago.setFechaDelDia(fechaDelDia);
        pago.setFormaDePago(formaDePago);
        pago.setNumRecibo(numRecibo);
        pago.setNumTransaccion(numTransaccion);
    }
}
