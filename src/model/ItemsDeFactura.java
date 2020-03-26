package model;

public class ItemsDeFactura {
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

}
