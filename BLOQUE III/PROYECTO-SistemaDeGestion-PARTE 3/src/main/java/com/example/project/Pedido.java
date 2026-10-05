package com.example.project;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order made by a customer, containing a list of products.
 */
public class Pedido {
    /** Products included in the order. */
    private List<Producto> productos;
    /** Customer who makes the order. */
    private Cliente cliente;

    /**
     * Creates an empty order for a customer.
     *
     * @param cliente the customer who makes the order
     */
    public Pedido(Cliente cliente)
    {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * Adds a product to the order.
     *
     * @param p the product to add
     * @throws NullPointerException if the product is null
     */
    public void agregarProducto(Producto p)
    {
        //HE CORREGIDO ESTA FUNCION PARA LA PARTE 3 DEL PROYECTO PARA QUE SONARCUBE FUNCIONE CORRECTAMENTE
        if (p == null)
        {
            throw new NullPointerException("El producto no puede ser nulo.");
        }
        productos.add(p);

    }

    /**
     * Calculates the total of the order by adding the final price of every product.
     *
     * @return the sum of the final prices of all the products
     * @throws IllegalStateException if the order has no products
     */
    public double calcularTotal()
    {
        if (productos.isEmpty()) {
            throw new IllegalStateException("El pedido no tiene ningún producto.");
        }
        
        double total = 0.0;
        for (Producto p : productos)
        {
            total += p.calcularPrecioFinal();
        }
        return total;
    }

    /**
     * Prints in the console a summary of the order: customer name,
     * the list of products with their prices and the total amount.
     *
     * @throws IllegalStateException if the order has no products
     */
    public void mostrarResumen()
    {
        System.out.println("RESUMEN DEL PEDIDO:");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Productos: ");
        for (Producto p : productos)
        {
            System.out.println(" - " + p.getNombre() + ". Precio: " + p.getPrecio());
        }
        System.out.println("Importe total del pedido: " + calcularTotal());

    }
    
}
