package com.example.project;

/**
 * A digital product (for example a game or an ebook). Besides the base price,
 * it has a download size, a VAT percentage and a fixed discount.
 */
public class ProductoDigital extends Producto {
    /** Size of the download. */
    private double tamanyoDescarga;
    /** VAT percentage applied to the price (for example 12 means 12%). */
    private double porcientoIva;
    /** Fixed discount amount subtracted from the price with VAT. */
    private double descuento;

    /**
     * Creates a digital product.
     *
     * @param nombre           the name of the product
     * @param precio           the base price
     * @param tamanyoDescarga  the size of the download
     * @param porcientoIva     the VAT percentage
     * @param descuento        the fixed discount amount
     */
    public ProductoDigital (String nombre, double precio, double tamanyoDescarga, double porcientoIva, double descuento)
    {
        super(nombre, precio);
        this.tamanyoDescarga = tamanyoDescarga;
        this.porcientoIva = porcientoIva;
        this.descuento = descuento;
    }

    /**
     * Gets the download size.
     *
     * @return the size of the download
     */
    public double getTamanyoDescarga()
    {
        return this.tamanyoDescarga;
    }

    /**
     * Gets the VAT percentage.
     *
     * @return the VAT percentage
     */
    public double getPorcientoIva()
    {
        return this.porcientoIva;
    }

    /**
     * Gets the fixed discount.
     *
     * @return the discount amount
     */
    public double getDescuento()
    {
        return this.descuento;
    }

    /**
     * Calculates the final price: base price plus VAT, minus the fixed discount.
     * The result is never lower than 0.
     *
     * @return the final price, with a minimum of 0.0
     * @throws IllegalArgumentException if the discount is greater than the base price
     */
    @Override
    public double calcularPrecioFinal()
    {
        if (descuento > precio) {
            throw new IllegalArgumentException("El descuento es mayor que el precio.");
        }
        double ivaAplicado = getPrecio() * (1.0 + this.porcientoIva / 100.0);
        double precioFinal = ivaAplicado - this.descuento;
        return Math.max(0.0, precioFinal);
    }

    /**
     * Returns a readable description of the digital product.
     *
     * @return a string with the name and the price of the product
     */
    @Override
    public String toString()
    {
        return "Nombre del producto digital: " + this.getNombre() + " - Precio: " + this.getPrecio();
    }
}
