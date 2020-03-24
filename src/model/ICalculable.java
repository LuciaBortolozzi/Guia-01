package model;

public interface ICalculable {
    //atributos public static final
    double DESCUENTO = 0.20;
    double IVA = 0.21;
    String[] SABORES = {"acido", "agrio", "amargo", "dulce", "salado", "picante"};

    //metodos public abstract
    double calcularTotal();

}
