package main.java.com.local.negocio.decorator;
import main.java.com.local.negocio.core.Vendible;

public class PackagingDecorator extends VendibleDecorator {
    public PackagingDecorator(Vendible decorado) {
        super(decorado);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 1000.0; // Agrega un costo fijo por el packaging
    }
    public Integer getStock() {
        return super.getStock();
    }

}