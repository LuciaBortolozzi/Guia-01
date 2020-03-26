package model;

public class PorPaquete extends Golosinas{
    private boolean promocion;
    private Depositos[] deposito;

    public PorPaquete(int codigo, String descripcion, String[] sabores, double precioUnitario, boolean promocion, Depositos[] deposito) {
        super(codigo, descripcion, sabores, precioUnitario);
        this.promocion = promocion;
        this.deposito = deposito;
    }

    public PorPaquete(boolean promocion, Depositos[] deposito) {
        this.promocion = promocion;
        this.deposito = deposito;
    }

    public PorPaquete() {
    }

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    public Depositos[] getDeposito() {
        return deposito;
    }

    public void setDeposito(Depositos[] deposito) {
        this.deposito = deposito;
    }

}
