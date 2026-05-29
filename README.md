# 📦 Módulo de Cálculo de Stock y Precios (Composite & Decorator)

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-Pattern--Driven-blue?style=for-the-badge)

## 📝 Descripción

Este proyecto consiste en un **Módulo de Cálculo de Stock y Precios** extensible y de alta cohesión desarrollado en Java. El sistema resuelve de forma elegante un desafío comercial común: la gestión de inventario y la tasación dinámica de productos individuales, agrupaciones complejas (**combos recursivos**) y la adición en tiempo de ejecución de modificadores de precio como **descuentos acumulables** y costos variables de **packaging**. 

Al adoptar un enfoque guiado por patrones de diseño, el sistema **evita la explosión de clases** (la necesidad de crear subclases rígidas para cada combinación posible de empaque y descuento), garantizando una arquitectura altamente mantenible, escalable y limpia.

---

## ✨ Características Principales (Features)

* **Combos Recursivos (Composite):** Capacidad para gestionar productos simples y combos de productos que, a su vez, pueden contener otros combos de manera jerárquica ilimitada.
* **Cálculo de Stock Inteligente:** El stock disponible de cualquier combo se calcula dinámicamente en base al componente con menor stock de su estructura interna.
* **Modificadores Acumulables (Decorator):** Soporte para envolver cualquier ítem vendible con múltiples capas de lógica de negocio (descuentos porcentuales, recargos por packaging, etc.) sin alterar las clases base.
* **Lógica Polimórfica:** Toda la estructura comparte un contrato unificado, permitiendo al cliente interactuar con un producto simple, un combo o un objeto decorado con la misma transparencia.

---

## 🏗️ Arquitectura y Patrones de Diseño

Para resolver el dominio del problema se combinaron de forma sinérgica dos de los patrones estructurales más potentes de la **GoF (Gang of Four)**:

1.  **Composite:** Se utiliza para unificar el comportamiento de objetos simples (`Producto`) y objetos compuestos (`Combo`) bajo la abstracción común `Vendible`. Esto permite que los clientes traten a los elementos individuales y a las colecciones de manera homogénea.
2.  **Decorator:** Se implementa para añadir responsabilidades y comportamientos adicionales de forma dinámica. Los descuentos y envoltorios "envuelven" al `Vendible` base, modificando el precio final de forma matemática y acumulativa.

### 📂 Estructura de Paquetes

```text
📦 modulo-stock-precios
 ┗ 📂 src
   ┗ 📂 main
     ┗ 📂 java
       ┗ 📂 com
         ┗ 📂 local
           ┗ 📂 negocio
             ┣ 📂 core
             ┃ ┣ 📄 Vendible.java          # Interfaz componente base
             ┃ ┗ 📄 Producto.java          # Componente hoja (Leaf)
             ┣ 📂 composite
             ┃ ┗ 📄 Combo.java             # Componente compuesto (Composite)
             ┣ 📂 decorator
             ┃ ┣ 📄 VendibleDecorator.java # Decorador base estructural
             ┃ ┣ 📄 DescuentoDecorator.java# Modificador de precio (Descuentos)
             ┃ ┗ 📄 PackagingDecorator.java# Modificador de precio (Empaquetado)
             ┣ 📂 ventas
             ┃ ┗ 📄 Pedido.java            # Clase cliente / Carrito de compras
             ┗ 📄 Main.java                # Punto de entrada de la aplicación