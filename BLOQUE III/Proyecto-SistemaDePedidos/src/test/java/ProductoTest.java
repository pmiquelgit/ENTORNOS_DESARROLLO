package test.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoTest {
    
    //VOY A REALIZAR AQUÍ LOS CASOS DE PRUEBA PARA PRODUCTO QUE SON LOS SIGUIENTES:

    // CALCULAR PRECIO DE PRODUCTO FÍSICO
    @Test
    @DisplayName("Calcular precio de producto físico")
    void calcularPrecioFisicoTest() {
        ProductoFisico productoTest = new ProductoFisico("Ordenador", 100.0, 15);
    }
}
