package com.example.project;

import java.time.LocalDate;
import java.util.UUID;

public class Factura {
    
    private final String codigoFactura;
    private final LocalDate fechaEmision;
    private final String nombreCliente;
    private final double totalBruto;
    private final double totalEnvio;
    private final double totalDescuento;
    private final double totalFinal;





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
 * @return Código único de la factura en formato FACT-XXXXXXXX
 */
public String getCodigoFactura() {
    return this.codigoFactura;
}

/**
 * @return Fecha de emisión de la factura
 */
public LocalDate getFechaEmision() {
    return this.fechaEmision;
}

/**
 * @return Nombre del cliente al que se emite la factura
 */
public String getNombreCliente() {
    return this.nombreCliente;
}

/**
 * @return Importe total de los productos con IVA incluido
 */
public double getTotalBruto() {
    return this.totalBruto;
}

/**
 * @return Gastos de envío aplicados
 */
public double getTotalEnvio() {
    return this.totalEnvio;
}

/**
 * @return Descuentos de fidelidad aplicados
 */
public double getTotalDescuento() {
    return this.totalDescuento;
}

/**
 * @return Importe final que abona el cliente
 */
public double getTotalFinal() {
    return this.totalFinal;
}

/**
 * Devuelve el desglose completo de la factura en formato legible.
 * @return String con el detalle de todos los conceptos facturados
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
