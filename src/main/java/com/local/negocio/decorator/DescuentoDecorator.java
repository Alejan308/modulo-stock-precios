package main.java.com.local.negocio.decorator;
import main.java.com.local.negocio.core.Vendible;

public class DescuentoDecorator extends VendibleDecorator {
    public DescuentoDecorator(Vendible decorado) {
        super(decorado);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * 0.9; // Aplica un descuento del 10%
    }
    public Integer getStock() {
        return super.getStock();
    }
    
}
