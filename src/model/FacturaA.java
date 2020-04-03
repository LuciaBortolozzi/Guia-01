package model;

import java.util.Calendar;

public class FacturaA extends Facturas {

    public FacturaA(Calendar fechaEmision, Calendar fechaVencimiento, long numFactura, Clientes cliente) {
        super(fechaEmision, fechaVencimiento, numFactura, cliente);
    }

    public FacturaA() {
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
        }
        return total;
    }




}
