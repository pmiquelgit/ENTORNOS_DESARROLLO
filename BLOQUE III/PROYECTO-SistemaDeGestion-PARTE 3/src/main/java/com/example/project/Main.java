package com.example.project;

/**
 * Entry point of the application. Builds a sample customer, products and an order,
 * and prints the order summary.
 */
public class Main {

    /**
     * Runs the demo: creates a customer, four products (two physical, two digital),
     * adds them to an order and shows the summary.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        
        //Aquí creo un cliente de prueba
        Cliente cliente1 = new Cliente("Paco Fernández", "pacofernandez@gmail.com", "Calle Rodríguez");

        //Los productos del mismo cliente
        Producto producto1 = new ProductoFisico("Monitor gaming", 120.0, 5.5);
        Producto producto2 = new ProductoFisico("Teledirigido", 65, 12.0);
        Producto producto3 = new ProductoDigital("JuegoLoco", 30, 120, 12, 0);
        Producto producto4 = new ProductoDigital("Ebook", 20, 6, 12, 18);

        //Creo un pedido para el cliente
        Pedido pedido1 = new Pedido(cliente1);

        //Todos los productos agregados al pedido del cliente
        pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);
        pedido1.agregarProducto(producto3);
        pedido1.agregarProducto(producto4);

        //Y finalmente aquí muestro toda la información del pedido
        pedido1.mostrarResumen();


        //RECUERDA ELIMINAR LOS MÉTODOS QUE HAS DE HACER DEL PRIMER DIAGRAMA UML
        //Y DEJARLOS COMO UNA "MEJORA" PARA EL SEGUNDO DIAGRAMA UML

    }
}
