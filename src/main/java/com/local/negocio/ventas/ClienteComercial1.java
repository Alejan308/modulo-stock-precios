package main.java.com.local.negocio.Pruebas;
import main.java.com.local.negocio.core.Vendible;
import main.java.com.local.negocio.composite.Combo;
import main.java.com.local.negocio.core.Producto;

public class ClienteComercial1 {
    public static void main(String[] args) {
        // --- 1. CREACIÓN DE PRODUCTOS SIMPLES (Hojas) ---
        Vendible casco = new Producto(1, "Casco Profesional", 150.0, 10);
        Vendible guantes = new Producto(2, "Guantes de Cuero", 50.0, 15);
        Vendible chaleco = new Producto(3, "Chaleco Reflectivo", 30.0, 5);
        Vendible moto = new Producto(4, "Moto Scrambler 250cc", 3500.0, 3);

        // --- 2. CREACIÓN DE UN COMBO SIMPLE (Composite) ---
        // Combo: Guantes + Casco + Chaleco
        Combo comboSeguridad = new Combo(101, "Combo Seguridad Moto");
        comboSeguridad.agregarVendible(casco);
        comboSeguridad.agregarVendible(guantes);
        comboSeguridad.agregarVendible(chaleco);

        // --- 3. CREACIÓN DE UN COMBO DE COMBOS (Composite de Composites) ---
        // Combo Supremo: La Moto + El Combo de Seguridad anterior
        Combo comboMoteroCompleto = new Combo(202, "Combo Motero Supremo");
        comboMoteroCompleto.agregarVendible(moto);
        comboMoteroCompleto.agregarVendible(comboSeguridad); // <--- ¡Esto es posible gracias a la interfaz!

        // --- 4. MOSTRAR RESULTADOS TRATANDO A TODOS POR IGUAL ---
        System.out.println("====== REPORTE DE PRODUCTOS INDIVIDUALES ======");
        imprimirDatos(casco);
        imprimirDatos(moto);

        System.out.println("\n====== REPORTE DE COMBOS SIMPLES ======");
        imprimirDatos(comboSeguridad);

        System.out.println("\n====== REPORTE DE COMBOS DE COMBOS ======");
        imprimirDatos(comboMoteroCompleto);
    }

    // Este método representa al "Cliente" puro del patrón.
    // Recibe la interfaz abstracta y no sabe si es un producto o un combo.
    public static void imprimirDatos(Vendible articulo) {
        System.out.println("Artículo: " + (articulo instanceof Producto ? ((Producto)articulo).getNombre() : ((Combo)articulo).getNombreCombo()));
        System.out.println("-> Precio Final: $" + articulo.getPrecio());
        System.out.println("-> Stock Disponible: " + articulo.getStock() + " unidades.");
        System.out.println("----------------------------------------------");
    }
}