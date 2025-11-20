package Clases;

import java.sql.Date;

public class Persona {
    

    private String dni = "";
    private String nombre = "";
    private Date fechaNacimiento;

    public Persona (String dni, String nombre, Date fechaNacimiento) {

        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;

    }


    public int getEdad() {
        
    }

    
}
