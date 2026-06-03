package com.example.project;

// Esta es la clase "orquestadora" nueva que se me pide añadir
// Esta será el foco principal de las pruebas de integración
public class Tienda {
    
    // Gastos de envío según zona geográfica
    private static final double ENVIO_ESPANA = 0.0;
    private static final double ENVIO_ZONA_CERCANA = 5.0; // Países como francia, italia, portugal etc...
    private static final double ENVIO_RESTO_ZONAS = 10.0; // Resto de países del mundo

    /**
     * Realiza la venta completa del sistema.
     * Orquesta el flujo: valida el pedido, calcula el total, aplica descuentos
     * de fidelidad, añade gastos de envío según el país y genera la Factura.
     *
     * @param cliente El cliente que realiza la compra. No puede ser null.
     * @param pedido  El pedido con los productos. No puede ser null ni estar vacío.
     * @return Un objeto Factura con el desglose completo de la compra.
     * @throws IllegalArgumentException Si el cliente o el pedido son null.
     * @throws IllegalStateException    Si el pedido no contiene productos.
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
     * Calcula los gastos de envío en función del país del cliente.
     * España: 0€ | Francia, Italia, Portugal: 5€ | Resto de países: 10€
     *
     * @param pais País del cliente en mayúsculas (ej. "ESPAÑA", "FRANCIA")
     * @return El coste de envío en euros
     */
    // Con esta función, voy a calcular los gastos de envío del cliente en base al país del que sea
    // España = 0€ | Francia, Italia, Portugal = 5€ | Resto de países = 10€
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
     * Calcula el importe del descuento de fidelidad sobre un total dado.
     * Más de 5 años: 10% | Hasta 5 años: 5% | Cliente VIP: +5% adicional
     *
     * @param total            Importe sobre el que se aplica el descuento
     * @param anyosAntiguedad  Años que lleva el cliente registrado
     * @param esVip            Si el cliente tiene estado VIP
     * @return El importe a descontar en euros
     */
    // Calculo el importe del descuento de fidelidad sobre un total
    // Yo lo haré de la siguiente manera: +5 años: 10% | Hasta 5 años: 5% | Cliente VIP: +5% adicional
    public double calcularDescuentoFidelidad(double total, int anyosAntiguedad, boolean esVip) {
        double porcentaje = (anyosAntiguedad > 5) ? 0.10 : 0.05;
        if (esVip) {
            porcentaje += 0.05;
        }
        return total * porcentaje;
    }
}