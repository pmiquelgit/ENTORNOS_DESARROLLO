package Clases;

import java.util.Date;

public class Profesor extends Persona {
    
    private double salario = 0;

    public Profesor(String dni, String nombre, Date fechaNacimiento, double salario) {

        super(dni, nombre, fechaNacimiento);
        this.salario = salario;

    }

    public void asignarCurso(c : Curso) {
        //Aquí no puedo agregar nada para prevenir el error
    }
}
