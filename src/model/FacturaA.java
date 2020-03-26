package model;

import java.util.Calendar;

public class FacturaA extends Facturas {

    public FacturaA(Calendar fechaEmision, Calendar fechaVencimiento, int centroEmisor, long numFactura, Clientes cliente) {
        super(fechaEmision, fechaVencimiento, centroEmisor, numFactura, cliente);
    }

    public FacturaA() {
    }
}
