package model;

public class Depositos {
    private String nombre;
    private String domicilio;
    private boolean propio;

    public Depositos() {
    }

    public Depositos(String nombre, String domicilio, boolean propio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.propio = propio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean isPropio() {
        return propio;
    }

    public void setPropio(boolean propio) {
        this.propio = propio;
    }
}
