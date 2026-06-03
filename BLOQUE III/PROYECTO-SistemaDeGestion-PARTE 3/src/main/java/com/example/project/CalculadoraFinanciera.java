package com.example.project;


public class CalculadoraFinanciera {
    
    public double aplicarIVA(double base, String tipoIva) {
        return switch (tipoIva.toUpperCase()) {
            case "GENERAL" -> base * 1.21;
            case "REDUCIDO" -> base * 1.10;
            case "SUPER" -> base * 1.04;
            default -> base;
        };
    }

    public double calcularDescuentoFidelidad(double total, int añosAntiguedad, boolean esVip) {
        double desc = (añosAntiguedad > 5) ? 0.10 : 0.05;
        if (esVip) desc += 0.05;
        return total * (1 - desc);
    }

    public double calcularGastosEnvio(double peso, double totalPedido, String zona) {
        if (totalPedido > 100.0) return 0.0;
        double tasaZona = zona.equals("INTERNACIONAL") ? 15.0 : 5.0;
        return tasaZona + (peso * 1.2);
    }

    public double calcularComisionPasarela(double total, String metodo) {
        return metodo.equals("PAYPAL") ? total * 0.03 : 1.5;
    }

    public double obtenerPrecioFinalIntegrado(double base, double envio, double descuentoAcumulado) {
        double precioConDescuento = base - descuentoAcumulado;
        double precioConEnvio = precioConDescuento + envio;
        return precioConEnvio; 
    }
}