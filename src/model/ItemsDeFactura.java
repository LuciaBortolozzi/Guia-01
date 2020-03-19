package model;

public class ItemsDeFactura implements ICalculable{
    private Golosinas golosina;
    private int cantidad;

    public ItemsDeFactura(Golosinas golosina, int cantidad) {
        this.golosina = golosina;
        this.cantidad = cantidad;
    }

    public ItemsDeFactura() {
    }

    public Golosinas getGolosina() {
        return golosina;
    }

    public void setGolosina(Golosinas golosina) {
        this.golosina = golosina;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double calcularTotal() {
        if (golosina instanceof PorPaquete && cantidad % 2 == 0){
            ((PorPaquete) golosina).setPromocion(true);
        } else {
            ((PorPaquete) golosina).setPromocion(false);
        }
        return ((PorPaquete) golosina).calcularTotal();
    }
}
