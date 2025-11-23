package Clases;

import java.util.Date;

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
     return (Integer) null; // <-- He añadido esto de aquí para que el archivo no me dé error   
    }

    
}
