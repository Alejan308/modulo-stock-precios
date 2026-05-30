package main.java.com.local.negocio.decorator;
import main.java.com.local.negocio.core.Vendible;

public class PackagingDecorator extends VendibleDecorator {
    private double costoPackaging;

    public PackagingDecorator(Vendible decorado, double costoPackaging) {
        super(decorado);
        this.costoPackaging = costoPackaging;
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + this.costoPackaging;
    }
    public Integer getStock() {
        return super.getStock();
    }

}