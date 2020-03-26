package model;

public class PorKilo extends Golosinas{
    private boolean oferta;

    public PorKilo(int codigo, String descripcion, String[] sabores, double precioUnitario, boolean oferta) {
        super(codigo, descripcion, sabores, precioUnitario);
        this.oferta = oferta;
    }

    public PorKilo(boolean oferta) {
        this.oferta = oferta;
    }

    public PorKilo() {
    }

    public boolean isOferta() {
        return oferta;
    }

    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }
}
