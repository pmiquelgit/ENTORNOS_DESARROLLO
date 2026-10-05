package com.example.project;

/**
 * Orchestrator class of the shop. It validates an order, calculates the total,
 * applies the loyalty discount, adds the shipping costs by country and
 * generates the invoice. It is the main target of the integration tests.
 */
public class Tienda {
    
    /** Shipping cost for Spain. */
    private static final double ENVIO_ESPANA = 0.0;
    /** Shipping cost for nearby countries (France, Italy, Portugal). */
    private static final double ENVIO_ZONA_CERCANA = 5.0;
    /** Shipping cost for the rest of the world. */
    private static final double ENVIO_RESTO_ZONAS = 10.0;

    /**
     * Performs a complete sale.
     * Orchestrates the flow: validates the order, calculates the total, applies the
     * loyalty discount, adds the shipping costs by country and generates the invoice.
     *
     * @param cliente the customer who makes the purchase, must not be null
     * @param pedido  the order with the products, must not be null or empty
     * @return an invoice with the full breakdown of the purchase
     * @throws IllegalArgumentException if the customer or the order are null
     * @throws IllegalStateException    if the order contains no products
     */
    public Factura realizarVenta(Cliente cliente, Pedido pedido) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null.");
        }
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser null.");
        }
        // Voy a pillar el total del pedido
        double totalPedido = pedido.calcularTotal();
        // Ahora miro los gastos de envío dependiendo de conde esté el cliente
        double gastoEnvio = calcularGastoEnvioPorPais(cliente.getPais());
        // Calculamos el descuento de fidelidad sobre el total del pedido
        double descuento = calcularDescuentoFidelidad(totalPedido, cliente.getAnyosAntiguedad(), cliente.isEsVip());
        // Y finalmente, calculo el total final del pedido
        double totalFinal = totalPedido + gastoEnvio - descuento;
        // Me aseguro de que el total final no sea negativo
        if (totalFinal < 0) {
            totalFinal = 0;
        }
        // Genero y devuelvo la factura
        return new Factura(cliente.getNombre(), Math.round(totalPedido * 100.0) / 100.0, gastoEnvio, Math.round(descuento * 100.0) / 100.0, Math.round(totalFinal * 100.0) / 100.0);
    }

    /**
     * Calculates the shipping costs depending on the country of the customer.
     * Spain: 0 EUR | France, Italy, Portugal: 5 EUR | Rest of countries: 10 EUR
     * (a null country is treated as the rest of the world).
     *
     * @param pais the country of the customer (case-insensitive), for example "ESPAÑA" or "FRANCIA"
     * @return the shipping cost in euros
     */
    public double calcularGastoEnvioPorPais(String pais) {
        if (pais == null) {
            return ENVIO_RESTO_ZONAS;
        }
        return switch (pais.toUpperCase()) {
            case "ESPAÑA" -> ENVIO_ESPANA;
            case "FRANCIA", "ITALIA", "PORTUGAL" -> ENVIO_ZONA_CERCANA;
            default -> ENVIO_RESTO_ZONAS;
        };
    }

    /**
     * Calculates the loyalty discount amount for a given total.
     * More than 5 years: 10% | Up to 5 years: 5% | VIP customer: extra 5%
     *
     * @param total            the amount the discount is applied to
     * @param anyosAntiguedad  years the customer has been registered
     * @param esVip            whether the customer has VIP status
     * @return the amount to discount, in euros
     */
    public double calcularDescuentoFidelidad(double total, int anyosAntiguedad, boolean esVip) {
        double porcentaje = (anyosAntiguedad > 5) ? 0.10 : 0.05;
        if (esVip) {
            porcentaje += 0.05;
        }
        return total * porcentaje;
    }
}
