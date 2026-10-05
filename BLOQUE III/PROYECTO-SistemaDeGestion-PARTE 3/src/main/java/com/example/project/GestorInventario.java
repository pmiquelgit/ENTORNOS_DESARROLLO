package com.example.project;


import java.util.ArrayList;
import java.util.List;

/**
 * Manages the stock of products using three parallel lists: product ids,
 * real stock and reserved stock. The element at the same index in each list
 * belongs to the same product.
 */
public class GestorInventario {
    /** List of product ids. */
    private List<String> listaIds = new ArrayList<>();
    /** Real units in stock for each product. */
    private List<Integer> stockReal = new ArrayList<>();
    /** Units reserved but not yet sold for each product. */
    private List<Integer> stockReservado = new ArrayList<>();

    /**
     * Finds the position of a product in the inventory lists.
     *
     * @param id the id of the product to look for
     * @return the index of the product, or -1 if it is not in the inventory
     */
    private int buscarIndice(String id) {
        for (int i = 0; i < listaIds.size(); i++) {
            if (listaIds.get(i).equals(id)) return i;
        }
        return -1;
    }

    /**
     * Registers a product in the inventory. If it already exists, the quantity
     * is added to its real stock; otherwise it is created with no reserved units.
     *
     * @param id        the id of the product
     * @param cantidad  the number of units to add
     */
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

    /**
     * Checks whether there are enough available units (real stock minus reserved)
     * and, if so, reserves them.
     *
     * @param id        the id of the product
     * @param cantidad  the number of units to reserve
     * @return {@code true} if the units were reserved, {@code false} if the product
     *         does not exist or there is not enough available stock
     */
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

    /**
     * Calculates the economic impact of a stock shortage. If the absolute difference
     * between real and reserved stock is greater than 10 units, the impact is 5% of the price.
     *
     * @param id      the id of the product
     * @param precio  the price of the product
     * @return 5% of the price if the difference is greater than 10, otherwise 0
     *         (also 0 if the product does not exist)
     */
    public double calcularImpactoRotura(String id, double precio) {
        int idx = buscarIndice(id);
        if (idx == -1) return 0;
        int faltante = Math.abs(stockReal.get(idx) - stockReservado.get(idx));
        return (faltante > 10) ? precio * 0.05 : 0;
    }

    /**
     * Confirms a sale by subtracting the units from both the real and the reserved stock.
     * Does nothing if the product does not exist.
     *
     * @param id        the id of the product
     * @param cantidad  the number of units sold
     */
    public void confirmarVenta(String id, int cantidad) {
        int idx = buscarIndice(id);
        if (idx != -1) {
            stockReal.set(idx, stockReal.get(idx) - cantidad);
            stockReservado.set(idx, stockReservado.get(idx) - cantidad);
        }
    }

    /**
     * Checks whether a product is in critical condition, meaning its real stock is below 5 units.
     *
     * @param id the id of the product
     * @return {@code true} if the product exists and has fewer than 5 units, {@code false} otherwise
     */
    public boolean esProductoCritico(String id) {
        int idx = buscarIndice(id);
        return idx != -1 && stockReal.get(idx) < 5;
    }
}
