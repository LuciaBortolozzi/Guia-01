import java.util.Calendar;

public class Pagos {
    private Calendar fechaDelDia;
    private char formaDePago;
    private int numRecibo;
    private int numTransaccion;

    public Pagos() {
    }

    public Pagos(Calendar fechaDelDia, char formaDePago, int numRecibo, int numTransaccion) {
        this.fechaDelDia = fechaDelDia;
        this.formaDePago = formaDePago;
        this.numRecibo = numRecibo;
        this.numTransaccion = numTransaccion;
    }

    public Calendar getFechaDelDia() {
        return fechaDelDia;
    }

    public void setFechaDelDia(Calendar fechaDelDia) {
        this.fechaDelDia = fechaDelDia;
    }

    public char getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(char formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public int getNumTransaccion() {
        return numTransaccion;
    }

    public void setNumTransaccion(int numTransaccion) {
        this.numTransaccion = numTransaccion;
    }
}
