package main.java.com.local.negocio.core;

public class Producto implements Vendible {
    private double precio;
    private Integer stock;

    public Producto(double precio, Integer stock) {
        this.precio = precio;
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }
}