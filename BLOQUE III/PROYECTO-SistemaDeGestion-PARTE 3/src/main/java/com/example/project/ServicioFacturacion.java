package com.example.project;


import java.util.UUID;

/**
 * Billing service that combines the inventory manager and the financial calculator
 * to process invoices and perform related operations.
 */
public class ServicioFacturacion {
    /** Inventory used to check and reserve stock. */
    private GestorInventario inventario;
    /** Calculator used for VAT, discounts and shipping. */
    private CalculadoraFinanciera calculadora;

    /**
     * Creates a billing service.
     *
     * @param inv   the inventory manager
     * @param calc  the financial calculator
     */
    public ServicioFacturacion(GestorInventario inv, CalculadoraFinanciera calc) {
        this.inventario = inv;
        this.calculadora = calc;
    }

    /**
     * Processes a complete invoice for a product: reserves the stock, applies
     * general VAT, a loyalty discount (2 years, not VIP) and national shipping (2.0 weight),
     * and confirms the sale in the inventory.
     *
     * @param idProd      the id of the product
     * @param cant        the number of units to sell
     * @param precioUnit  the unit price of the product
     * @return a string with the invoice code and the total, or
     *         "ERROR: Stock insuficiente" if the stock could not be reserved
     */
    public String procesarFacturaCompleta(String idProd, int cant, double precioUnit) {
        if (!inventario.verificarYReservar(idProd, cant)) {
            return "ERROR: Stock insuficiente";
        }

        double base = precioUnit * cant;
        double conIva = calculadora.aplicarIVA(base, "GENERAL");
        double montoDescuento = conIva - calculadora.calcularDescuentoFidelidad(conIva, 2, false);
        double gastosEnvio = calculadora.calcularGastosEnvio(2.0, base, "NACIONAL");

        double total = calculadora.obtenerPrecioFinalIntegrado(conIva, gastosEnvio, montoDescuento);
        
        inventario.confirmarVenta(idProd, cant);
        return "FACT-" + UUID.randomUUID().toString().substring(0,5) + " | Total: " + total + "€";
    }

    /**
     * Checks that an invoice is consistent: subtotal plus VAT must equal the total,
     * with a tolerance of 0.01.
     *
     * @param subtotal  the amount before VAT
     * @param iva       the VAT amount
     * @param total     the total of the invoice
     * @return {@code true} if the amounts match within the tolerance, {@code false} otherwise
     */
    public boolean validarIntegridad(double subtotal, double iva, double total) {
        return Math.abs((subtotal + iva) - total) < 0.01;
    }

    /**
     * Issues a credit note for an invoice.
     *
     * @param facturaOriginal the code of the original invoice
     * @return the credit note code, which is "NC-" followed by the original invoice code
     */
    public String emitirNotaCredito(String facturaOriginal) {
        return "NC-" + facturaOriginal;
    }

    /**
     * Estimates the profit margin: total minus production cost minus 21% of the total (VAT).
     *
     * @param total            the total amount of the sale
     * @param costeProduccion  the production cost
     * @return the estimated profit margin
     */
    public double estimarMargenBeneficio(double total, double costeProduccion) {
        return total - costeProduccion - (total * 0.21);
    }
    
    /**
     * Archives an invoice. Currently it only prints a message in the console.
     *
     * @param id the id of the invoice to archive
     */
    public void archivarFactura(String id) {
        System.out.println("Documento " + id + " almacenado.");
    }
}
