package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void testTodosLosGettersYSettersDeCliente() {

        
        ///////////////////////////////////////////////////////////////////////////////
        // ESTA CLASE LA HE CREADO PARA PODER SUPERAR EL 80% DE COBERTURA EN SONARCUBE
        ///////////////////////////////////////////////////////////////////////////////

        Cliente cliente = new Cliente("Juan", "juan@mail.com", "Calle 1");

        // Uso TODOS los setters 
        cliente.setNombre("Pedro");
        cliente.setCorreo("pedro@mail.com");
        cliente.setDireccion("Avenida 2");
        cliente.setAnyosAntiguedad(5);
        cliente.setEsVip(true);
        cliente.setPais("FRANCIA");

        // Compruebo TODOS los getters
        assertEquals("Pedro", cliente.getNombre());
        assertEquals("pedro@mail.com", cliente.getCorreo());
        assertEquals("Avenida 2", cliente.getDireccion());
        assertEquals(5, cliente.getAnyosAntiguedad());
        assertTrue(cliente.isEsVip());
        assertEquals("FRANCIA", cliente.getPais());

        // Compruebo el toString 
        String textoEsperado = "Nombre: Pedro - Correo: pedro@mail.com";
        assertEquals(textoEsperado, cliente.toString());
    }
}