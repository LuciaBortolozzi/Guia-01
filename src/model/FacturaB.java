package model;

import java.util.Calendar;

public class FacturaB extends Facturas {

    public FacturaB(Calendar fechaEmision, Calendar fechaVencimiento, int centroEmisor, long numFactura, Clientes cliente, String nombreTienda) {
        super(fechaEmision, fechaVencimiento, centroEmisor, numFactura, cliente);
    }

    public FacturaB() {
    }
}
