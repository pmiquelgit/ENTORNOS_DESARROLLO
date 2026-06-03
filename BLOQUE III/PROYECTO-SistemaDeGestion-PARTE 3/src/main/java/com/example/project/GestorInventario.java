package com.example.project;


import java.util.ArrayList;
import java.util.List;

public class GestorInventario {
    private List<String> listaIds = new ArrayList<>();
    private List<Integer> stockReal = new ArrayList<>();
    private List<Integer> stockReservado = new ArrayList<>();

    private int buscarIndice(String id) {
        for (int i = 0; i < listaIds.size(); i++) {
            if (listaIds.get(i).equals(id)) return i;
        }
        return -1;
    }

    public void darDeAltaProducto(String id, int cantidad) {
        int idx = buscarIndice(id);
        if (idx == -1) {
            listaIds.add(id);
            stockReal.add(cantidad);
            stockReservado.add(0);
        } else {
            stockReal.set(idx, stockReal.get(idx) + cantidad);
        }
    }

    public boolean verificarYReservar(String id, int cantidad) {
        int idx = buscarIndice(id);
        if (idx != -1) {
            int disponible = stockReal.get(idx) - stockReservado.get(idx);
            if (disponible >= cantidad) {
                stockReservado.set(idx, stockReservado.get(idx) + cantidad);
                return true;
            }
        }
        return false;
    }

    public double calcularImpactoRotura(String id, double precio) {
        int idx = buscarIndice(id);
        if (idx == -1) return 0;
        int faltante = Math.abs(stockReal.get(idx) - stockReservado.get(idx));
        return (faltante > 10) ? precio * 0.05 : 0;
    }

    public void confirmarVenta(String id, int cantidad) {
        int idx = buscarIndice(id);
        if (idx != -1) {
            stockReal.set(idx, stockReal.get(idx) - cantidad);
            stockReservado.set(idx, stockReservado.get(idx) - cantidad);
        }
    }

    public boolean esProductoCritico(String id) {
        int idx = buscarIndice(id);
        return idx != -1 && stockReal.get(idx) < 5;
    }
}