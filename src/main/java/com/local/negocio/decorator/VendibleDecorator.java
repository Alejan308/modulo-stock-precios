package main.java.com.local.negocio.decorator;
import main.java.com.local.negocio.core.Vendible;


public abstract class VendibleDecorator implements Vendible {
    protected Vendible decorado;

    public VendibleDecorator(Vendible decorado) {
        this.decorado = decorado;
    }

    public double getPrecio() {
        return decorado.getPrecio();
    }

    public Integer getStock() {
        return decorado.getStock();
    }
}