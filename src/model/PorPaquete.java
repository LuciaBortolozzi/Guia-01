package model;

public class PorPaquete extends Golosinas{
    private boolean promocion;
    private Depositos[] depositos;

    public PorPaquete(int codigo, String descripcion, String[] sabores, double precioUnitario, boolean promocion, Depositos[] depositos) {
        super(codigo, descripcion, sabores, precioUnitario);
        this.promocion = promocion;
        this.depositos = depositos;
    }

    public PorPaquete(boolean promocion, Depositos[] depositos) {
        this.promocion = promocion;
        this.depositos = depositos;
    }

    public PorPaquete() {
    }

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    public Depositos[] getDepositos() {
        return depositos;
    }

    public void setDepositos(Depositos[] depositos) {
        this.depositos = depositos;
    }

}
