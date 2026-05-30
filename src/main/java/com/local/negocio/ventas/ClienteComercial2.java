package main.java.com.local.negocio.Pruebas;

import main.java.com.local.negocio.core.Vendible;
import main.java.com.local.negocio.core.Producto;
import main.java.com.local.negocio.composite.Combo;
import main.java.com.local.negocio.decorator.PackagingDecorator;
import main.java.com.local.negocio.decorator.DescuentoDecorator;

public class ClienteComercial2 {
    public static void main(String[] args) {
        
        // 1. Creamos los productos base
        Vendible casco = new Producto(1, "Casco Profesional", 100.0, 10);
        Vendible guantes = new Producto(2, "Guantes de Cuero", 50.0, 15);

        // 2. Creamos un Combo (Composite)
        Combo comboSeguridad = new Combo(101, "Combo Seguridad");
        comboSeguridad.agregarVendible(casco);
        comboSeguridad.agregarVendible(guantes); // Precio Base del Combo: $150.0

        System.out.println("=== 1. Producto Simple con Decoradores ===");
        // Al casco le aplicamos un empaque especial de $20.0
        Vendible cascoConEmpaque = new PackagingDecorator(casco, 20.0);
        imprimirDatos("Casco con empaque", cascoConEmpaque);


        System.out.println("\n=== 2. Combo Completo con Descuento del 10% ===");
        // Aplicamos descuento al combo entero. Precio esperado: 150 * 0.90 = $135.0
        Vendible comboConDescuento = new DescuentoDecorator(comboSeguridad, 0.10);
        imprimirDatos("Combo + Descuento 10%", comboConDescuento);


        System.out.println("\n=== 3. ACUMULACIÓN MÁXIMA (Combo + Descuento 1 + Descuento 2 + Packaging) ===");
        // Envolvemos el combo en: Descuento del 10%, luego otro descuento del 5%, y finalmente una caja premium de $50
        // La estructura en memoria queda como: Packaging( Descuento( Descuento( Combo ) ) )
        Vendible comboSuperDecorado = new DescuentoDecorator(comboSeguridad, 0.10); // $135.0
        comboSuperDecorado = new DescuentoDecorator(comboSuperDecorado, 0.05);       // $135 * 0.95 = $128.25
        comboSuperDecorado = new PackagingDecorator(comboSuperDecorado, 50.0);       // $128.25 + $50 = $178.25

        imprimirDatos("Combo con Descuentos Acumulados y Caja Premium", comboSuperDecorado);
    }

    public static void imprimirDatos(String descripcion, Vendible articulo) {
        System.out.println("Descripción comercial: " + descripcion);
        System.out.println("-> Precio Final: $" + articulo.getPrecio());
        System.out.println("-> Stock Disponible: " + articulo.getStock() + " unidades.");
        System.out.println("-------------------------------------------------------");
    }
}
