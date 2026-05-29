package main.java.com.local.negocio.composite;
import main.java.com.local.negocio.core.Vendible;
import java.util.List;

public class Combo {
    private java.util.List<Vendible> vendibles;
    public Combo(List<Vendible> vendibles) {
        this.vendibles = vendibles;
    }
    public double getPrecio() {
        double precioTotal = 0.0;
        for (Vendible vendible : vendibles) {
            precioTotal += vendible.getPrecio();
        }
        return precioTotal;
    }

}
