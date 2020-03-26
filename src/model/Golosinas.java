package model;

public abstract class Golosinas {
    static final int S = 6;

    protected int codigo;
    protected String descripcion;
    protected String[] sabores = new String[S];
    protected double precioUnitario;

    public Golosinas(int codigo, String descripcion, String[] sabores, double precioUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.sabores = sabores;
        this.precioUnitario = precioUnitario;
    }

    public Golosinas() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String[] getSabores() {
        return sabores;
    }

    public void setSabores(String[] sabores) {
        this.sabores = sabores;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
