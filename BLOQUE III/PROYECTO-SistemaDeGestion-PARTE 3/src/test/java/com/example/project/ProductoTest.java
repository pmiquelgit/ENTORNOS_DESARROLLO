package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoTest {
    
    /////////////////////////////
    //CASOS DE PRUEBA POSITIVOS//
    /////////////////////////////


    // CALCULAR PRECIO DE PRODUCTO FÍSICO
    @Test
    @DisplayName("Calcular precio de producto físico")
    void calcularPrecioFisicoTest() {

        //ARRANGE
        ProductoFisico productoTestFisico = new ProductoFisico("Ordenador", 100.0, 15);
        //ACT
        double resultado = productoTestFisico.calcularPrecioFinal();
        //ASSERT
        assertEquals(115.0, resultado, "El producto no ha dado el resultado esperado"); 
        //Aquí al final coloco un mensaje de error en caso de que el producto que he creado no sea el resultado que esperamos
    }

    
    // CALCULAR PRECIO DE PRODUCTO DIGITAL
    @Test
    @DisplayName("Calcular precio de producto digital")
    void calcularPrecioDigitalTest() {
        ProductoDigital productoDigitalTest = new ProductoDigital("Videojuego", 75, 20.0, 15, 0.0);
        double resultado = productoDigitalTest.calcularPrecioFinal();
        assertEquals(resultado, 86.25, "Algo salió mal, el precio obtenido no fue el correcto.");
    }

    

    /////////////////////////////
    //CASOS DE PRUEBA NEGATIVOS//
    /////////////////////////////

    //COMPROBAR PRECIO NEGATIVO EN UN PRODUCTO
    @Test
    @DisplayName("Comprobar precio negativo en un producto")
    void comprobarPrecioNegativo() {
        Producto productoTest = new ProductoFisico("Monitor", 50.0, 10.0);

        assertThrows(IllegalArgumentException.class, () -> {
            productoTest.setPrecio(-15.0);
        }, "El sistema no debería permitir productos con precio negativo");

    }
    
    

    ////////////////////////////////////////////////////
    //CASOS DE PRUEBA PARA SUPERAR EL 80% EN SONARCUBE//
    ////////////////////////////////////////////////////

    @Test
    void testGettersSettersYMetodosBase() {
        // 1. Creamos un producto de prueba
        Producto producto = new Producto("Manzana", 1.5);

        // 2. Comprobamos los Setters (Esto pondrá en verde las líneas 23 y 37)
        producto.setNombre("Pera");
        producto.setPrecio(2.0); // Al poner un precio > 0, cubrimos el "else" oculto de la línea 34

        // 3. Comprobamos los Getters (Esto pondrá en verde las líneas 18)
        assertEquals("Pera", producto.getNombre());
        assertEquals(2.0, producto.getPrecio());

        // 4. Comprobamos calcularPrecioFinal (Pondrá en verde la línea 43)
        assertEquals(0.0, producto.calcularPrecioFinal());

        // 5. Comprobamos el toString (Pondrá en verde la línea 52)
        String textoEsperado = "Nombre del producto: Pera - Precio: 2.0";
        assertEquals(textoEsperado, producto.toString());
    }





}
