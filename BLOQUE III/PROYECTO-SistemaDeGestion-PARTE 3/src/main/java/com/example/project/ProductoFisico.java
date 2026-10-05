package com.example.project;

/**
 * A physical product that has to be shipped. Besides the base price,
 * it has a shipping cost.
 */
public class ProductoFisico extends Producto {
    
    /** Shipping cost of the product. */
    private double costeEnvio;

    /**
     * Creates a physical product.
     *
     * @param nombre      the name of the product
     * @param precio      the base price
     * @param costeEnvio  the shipping cost
     */
    public ProductoFisico(String nombre, double precio, double costeEnvio)
    {
        super(nombre, precio);
        this.costeEnvio = costeEnvio;
    }

    /**
     * Gets the shipping cost.
     *
     * @return the shipping cost
     */
    public double getCosteEnvio()
    {
        return this.costeEnvio;
    }

    /**
     * Sets the shipping cost.
     *
     * @param costeEnvio the new shipping cost
     */
    public void setCosteEnvio(double costeEnvio)
    {
        this.costeEnvio = costeEnvio;
    }

    /**
     * Calculates the final price: base price plus shipping cost.
     * The result is never lower than 0.
     *
     * @return the final price, with a minimum of 0.0
     */
    @Override
    public double calcularPrecioFinal()
    {
        double resultado = getPrecio() + costeEnvio;
        return Math.max(0.0, resultado);
    }

    /**
     * Returns a readable description of the product with its name and price.
     *
     * @return a string with the name and the price of the product
     */
    @Override
    public String toString()
    {
        return "Nombre del producto digital: " + this.getNombre() + " - Precio: " + this.getPrecio();
    }

}
