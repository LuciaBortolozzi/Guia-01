package model;

import java.util.Calendar;

public class FacturaB extends Facturas {

    public FacturaB(Calendar fechaEmision, Calendar fechaVencimiento, int centroEmisor, long numFactura, Clientes cliente, String nombreTienda) {
        super(fechaEmision, fechaVencimiento, centroEmisor, numFactura, cliente);
    }

    public FacturaB() {
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemsDeFactura item: itemsDeFactura
        ) {
            if (item.getGolosina() instanceof PorKilo){
                if (((PorKilo) item.getGolosina()).isOferta()){
                    total = item.getGolosina().getPrecioUnitario() - item.getGolosina().getPrecioUnitario() * DESCUENTO;
                } else {
                    total = item.getGolosina().getPrecioUnitario();
                }
            } else {
                if (((PorPaquete) item.getGolosina()).isPromocion() && (item.getCantidad() % 2) == 0){
                    total = item.getGolosina().getPrecioUnitario() / 2;
                } else {
                    total = item.getGolosina().getPrecioUnitario();
                }
            }
            total = total * item.getCantidad();
            total += total * IVA;
        }
        return total;
    }
}
