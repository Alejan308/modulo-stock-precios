package main.java.com.local.negocio.composite;
import main.java.com.local.negocio.core.Vendible;
import java.util.List;

public class Combo {
    private Integer idCombo;
    private String nombreCombo;
    private java.util.List<Vendible> contenidoCombo;

    public Combo(Integer idCombo, String nombreCombo, List<Vendible> vendibles) {
        this.idCombo = idCombo;
        this.nombreCombo = nombreCombo;
        this.contenidoCombo = vendibles;
    }

    public Integer getIdCombo() {
        return idCombo;
    }
    public String getNombreCombo() {
        return nombreCombo;
    }

    public void agregarVendible(Vendible vendible) {
        contenidoCombo.add(vendible);
    }

    public void eliminarVendible(Vendible vendible) {
        contenidoCombo.remove(vendible);
    }

    public double getPrecio() {
        double precioTotal = 0.0;
        for (Vendible vendible : contenidoCombo) {
            precioTotal += vendible.getPrecio();
        }
        return precioTotal;
    }

    public Integer getStock() {
        Integer stockMinimo = Integer.MAX_VALUE;
        for (Vendible vendible : contenidoCombo) {
            Integer stockVendible = vendible.getStock();
            if (stockVendible < stockMinimo) {
                stockMinimo = stockVendible;
            }
        }
        return stockMinimo;
    }

}
