package com.example.project;


import java.util.UUID;

public class ServicioFacturacion {
    private GestorInventario inventario;
    private CalculadoraFinanciera calculadora;

    public ServicioFacturacion(GestorInventario inv, CalculadoraFinanciera calc) {
        this.inventario = inv;
        this.calculadora = calc;
    }

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

    public boolean validarIntegridad(double subtotal, double iva, double total) {
        return Math.abs((subtotal + iva) - total) < 0.01;
    }

    public String emitirNotaCredito(String facturaOriginal) {
        return "NC-" + facturaOriginal;
    }

    public double estimarMargenBeneficio(double total, double costeProduccion) {
        return total - costeProduccion - (total * 0.21);
    }
    
    public void archivarFactura(String id) {
        System.out.println("Documento " + id + " almacenado.");
    }
}