package com.example.project;

/**
 * Utility class that groups the financial calculations of the shop:
 * VAT, loyalty discounts, shipping costs and payment gateway fees.
 */
public class CalculadoraFinanciera {
    
    /**
     * Applies VAT to a base amount according to the VAT type.
     * GENERAL = 21%, REDUCIDO = 10%, SUPER = 4%. Any other type leaves the amount unchanged.
     *
     * @param base    the amount before VAT
     * @param tipoIva the VAT type (case-insensitive): "GENERAL", "REDUCIDO" or "SUPER"
     * @return the amount with VAT included, or the base amount if the type is unknown
     * @throws NullPointerException if {@code tipoIva} is null
     */
    public double aplicarIVA(double base, String tipoIva) {
        return switch (tipoIva.toUpperCase()) {
            case "GENERAL" -> base * 1.21;
            case "REDUCIDO" -> base * 1.10;
            case "SUPER" -> base * 1.04;
            default -> base;
        };
    }

    /**
     * Applies the loyalty discount to a total.
     * Customers with more than 5 years get 10%, the rest get 5%, and VIP customers get an extra 5%.
     *
     * @param total           the amount before the discount
     * @param añosAntiguedad  number of years the customer has been registered
     * @param esVip           whether the customer has VIP status
     * @return the total after the discount has been subtracted (not the discount amount)
     */
    public double calcularDescuentoFidelidad(double total, int añosAntiguedad, boolean esVip) {
        double desc = (añosAntiguedad > 5) ? 0.10 : 0.05;
        if (esVip) desc += 0.05;
        return total * (1 - desc);
    }

    /**
     * Calculates the shipping cost of an order.
     * Orders over 100.0 ship for free. Otherwise the cost is the zone rate
     * (15.0 for "INTERNACIONAL", 5.0 for any other zone) plus 1.2 per weight unit.
     *
     * @param peso         the weight of the order
     * @param totalPedido  the total amount of the order
     * @param zona         the shipping zone (case-sensitive), for example "INTERNACIONAL"
     * @return the shipping cost, or 0.0 if the order qualifies for free shipping
     * @throws NullPointerException if {@code zona} is null and the order is not free of shipping
     */
    public double calcularGastosEnvio(double peso, double totalPedido, String zona) {
        if (totalPedido > 100.0) return 0.0;
        double tasaZona = zona.equals("INTERNACIONAL") ? 15.0 : 5.0;
        return tasaZona + (peso * 1.2);
    }

    /**
     * Calculates the fee charged by the payment gateway.
     * PayPal charges 3% of the total; any other method charges a flat 1.5.
     *
     * @param total   the amount of the payment
     * @param metodo  the payment method (case-sensitive), for example "PAYPAL"
     * @return the fee amount
     * @throws NullPointerException if {@code metodo} is null
     */
    public double calcularComisionPasarela(double total, String metodo) {
        return metodo.equals("PAYPAL") ? total * 0.03 : 1.5;
    }

    /**
     * Calculates the final price of an order: base price minus the accumulated discount plus shipping.
     *
     * @param base                the base price of the order
     * @param envio               the shipping cost
     * @param descuentoAcumulado  the total discount amount to subtract
     * @return the final price to pay
     */
    public double obtenerPrecioFinalIntegrado(double base, double envio, double descuentoAcumulado) {
        double precioConDescuento = base - descuentoAcumulado;
        double precioConEnvio = precioConDescuento + envio;
        return precioConEnvio; 
    }
}
