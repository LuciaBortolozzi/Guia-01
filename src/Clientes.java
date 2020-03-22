public class Clientes {
    private long cuit;
    private String razonSocial;
    private boolean condicionIVA;

    public Clientes() {
    }

    public Clientes(long cuit, String razonSocial, boolean condicionIVA) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.condicionIVA = condicionIVA;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public boolean isCondicionIVA() {
        return condicionIVA;
    }

    public void setCondicionIVA(boolean condicionIVA) {
        this.condicionIVA = condicionIVA;
    }
}
