package com.example.project;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Immutable invoice generated after a sale. It stores an auto-generated code,
 * the issue date, the customer name and the amount breakdown.
 */
public class Factura {
    
    /** Unique invoice code, in the format FACT-XXXXXXXX. */
    private final String codigoFactura;
    /** Date on which the invoice was issued. */
    private final LocalDate fechaEmision;
    /** Name of the customer the invoice is issued to. */
    private final String nombreCliente;
    /** Total amount of the products. */
    private final double totalBruto;
    /** Shipping costs applied. */
    private final double totalEnvio;
    /** Loyalty discount applied. */
    private final double totalDescuento;
    /** Final amount paid by the customer. */
    private final double totalFinal;

    /**
     * Creates an invoice. The code is generated randomly and the issue date is today.
     *
     * @param nombreCliente   the name of the customer
     * @param totalBruto      the total amount of the products
     * @param totalEnvio      the shipping costs
     * @param totalDescuento  the discount amount applied
     * @param totalFinal      the final amount to pay
     */
    public Factura(String nombreCliente, double totalBruto, double totalEnvio, double totalDescuento, double totalFinal) {
        
        this.codigoFactura = "FACT-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        this.fechaEmision = LocalDate.now();
        this.nombreCliente = nombreCliente;
        this.totalBruto = totalBruto;
        this.totalEnvio = totalEnvio;
        this.totalDescuento = totalDescuento;
        this.totalFinal = totalFinal;

    }

    //////////////////////////////////////
    // GETTERS Y SETTERS PARA LA FACTURA
    //////////////////////////////////////

    /**
     * Gets the invoice code.
     *
     * @return the unique invoice code in the format FACT-XXXXXXXX
     */
    public String getCodigoFactura() {
        return this.codigoFactura;
    }

    /**
     * Gets the issue date.
     *
     * @return the date on which the invoice was issued
     */
    public LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    /**
     * Gets the customer name.
     *
     * @return the name of the customer the invoice is issued to
     */
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    /**
     * Gets the total amount of the products.
     *
     * @return the total amount of the products
     */
    public double getTotalBruto() {
        return this.totalBruto;
    }

    /**
     * Gets the shipping costs.
     *
     * @return the shipping costs applied
     */
    public double getTotalEnvio() {
        return this.totalEnvio;
    }

    /**
     * Gets the discount amount.
     *
     * @return the loyalty discount applied
     */
    public double getTotalDescuento() {
        return this.totalDescuento;
    }

    /**
     * Gets the final amount.
     *
     * @return the final amount paid by the customer
     */
    public double getTotalFinal() {
        return this.totalFinal;
    }

    /**
     * Returns the full breakdown of the invoice in a readable format.
     *
     * @return a string with the details of all the invoiced concepts
     */
    @Override
    public String toString() {
        return String.format(
            "====== FACTURA ======%n" +
            "Código:         %s%n"   +
            "Fecha:          %s%n"   +
            "Cliente:        %s%n"   +
            "---------------------%n" +
            "Total productos: %.2f€%n" +
            "Gastos de envío: %.2f€%n" +
            "Descuentos:     -%.2f€%n" +
            "=====================%n" +
            "TOTAL FINAL:    %.2f€%n",
            codigoFactura, fechaEmision, nombreCliente,
            totalBruto, totalEnvio, totalDescuento, totalFinal
        );
    }

}
