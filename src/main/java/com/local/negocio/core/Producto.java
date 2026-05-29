package main.java.com.local.negocio.core;

public class Producto implements Vendible {
    private Integer id;
    private String nombre;
    private double precio;
    private Integer stock;

    public Producto(Integer id, String nombre, double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
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