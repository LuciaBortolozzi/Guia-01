package model;

import java.util.Calendar;

public class FacturaB extends Facturas {
    private static int contadorB = 0;

    public FacturaB(Calendar fechaEmision, Calendar fechaVencimiento, int centroEmisor, long numFactura, Clientes cliente) {
        super(fechaEmision, fechaVencimiento, centroEmisor, numFactura, cliente);
        contadorB++;
    }

    public FacturaB() {
        contadorB++;
    }

    public static int getContador() {
        return contadorB;
    }

    public static void setContador(int contadorB) {
        FacturaB.contadorB = contadorB;
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
