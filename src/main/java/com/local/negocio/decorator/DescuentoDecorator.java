package main.java.com.local.negocio.decorator;
import main.java.com.local.negocio.core.Vendible;

public class DescuentoDecorator extends VendibleDecorator {
    private double porcentajeDescuento; // Ejemplo: 0.10 para el 10%

    // Ahora es flexible: recibe el porcentaje a descontar
    public DescuentoDecorator(Vendible decorado, double porcentajeDescuento) {
        super(decorado);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * (1 - this.porcentajeDescuento);
    }
    public Integer getStock() {
        return super.getStock();
    }
    
}
