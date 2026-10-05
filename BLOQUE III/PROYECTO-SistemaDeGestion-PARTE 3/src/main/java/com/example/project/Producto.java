package com.example.project;

/**
 * Base class for all the products of the shop. Stores the name and the price,
 * and defines the method that subclasses override to calculate the final price.
 */
public class Producto {
    
    /** Name of the product. */
    private String nombre;
    /** Base price of the product. */
    protected double precio;

    /**
     * Creates a product.
     *
     * @param nombre  the name of the product
     * @param precio  the base price of the product
     */
    public Producto(String nombre, double precio) {

        this.nombre = nombre;
        this.precio = precio;
    }

    //GETTERS Y SETTERS

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Sets the name of the product.
     *
     * @param nombre the new name
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Gets the base price of the product.
     *
     * @return the base price
     */
    public double getPrecio()
    {
        return this.precio;
    }

    /**
     * Sets the base price of the product.
     *
     * @param precio the new price, must not be negative
     * @throws IllegalArgumentException if the price is negative
     */
    public void setPrecio(double precio)
    {
        //HE TENIDO QUE MODIFICAR ESTO PARA LA PARTE 3 DEL PROYECTO 
        if (precio < 0) {
            throw new IllegalArgumentException("Precio negativo no permitido.");
        }
        this.precio = precio;
    }

    /**
     * Calculates the final price of the product. In this base class it returns 0.0;
     * subclasses {@link ProductoFisico} and {@link ProductoDigital} override it.
     *
     * @return the final price of the product
     */
    //Aquí, implemento la función que luego sobreescribiré en las subclases
    //"ProductoFísico" y "ProductoDigital"
    public double calcularPrecioFinal() {
        return 0.0;
    }

    /**
     * Returns a readable description of the product with its name and price.
     *
     * @return a string with the name and the price of the product
     */
    //Añado por aquí el método "toString" para poder mostrar la información
    //del producto sin que me develva un identificador inentendible.

    @Override
    public String toString() {
        return String.format("Nombre del producto: %s - Precio: %s", this.nombre, this.precio);    
    }

}
