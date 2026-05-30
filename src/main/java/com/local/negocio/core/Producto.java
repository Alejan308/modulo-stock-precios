package main.java.com.local.negocio.core;

public class Producto implements Vendible {
    private Integer idProducto;
    private String nombreP;
    private double precio;
    private Integer stock;

    public Producto(Integer id, String nombre, double precio, Integer stock) {
        this.idProducto = id;
        this.nombreP = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Integer getId() {
        return idProducto;
    }
    public String getNombre() {
        return nombreP;
    }

    public double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }
}