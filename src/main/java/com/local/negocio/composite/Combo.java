package main.java.com.local.negocio.composite;
import main.java.com.local.negocio.core.Vendible;
import java.util.List;
import java.util.ArrayList;

public class Combo implements Vendible {
    private Integer idCombo;
    private String nombreCombo;
    private List<Vendible> contenidoCombo;

    public Combo(Integer idCombo, String nombreCombo) {
        this.idCombo = idCombo;
        this.nombreCombo = nombreCombo;
        this.contenidoCombo = new ArrayList<>();
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
        if (contenidoCombo.isEmpty()){
            return 0;
        }


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
