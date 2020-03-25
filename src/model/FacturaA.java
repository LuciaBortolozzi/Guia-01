package model;

import java.util.Calendar;

public class FacturaA extends Facturas {

    public FacturaA(Calendar fechaEmision, Calendar fechaVencimiento, int centroEmisor, long numFactura, Clientes cliente) {
        super(fechaEmision, fechaVencimiento, centroEmisor, numFactura, cliente);
    }

    public FacturaA() {
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemsDeFactura item: itemsDeFactura
             ) {
            total = item.getGolosina().getPrecioUnitario() * IVA;
        }
        return total;
    }
}
