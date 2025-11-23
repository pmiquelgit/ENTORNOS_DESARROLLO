package Clases;

import java.util.Date;

public class Estudiante extends Persona {
    
    private boolean repetidor;

    public Estudiante (String dni, String nombre, Date fechaNacimiento) {
        super(dni, nombre, fechaNacimiento);
        this.repetidor = repetidor;
    }

    public Matricula inscribirse(Curso c) {
        return null; // <-- He añadido esto de aquí para que el archivo no me dé error 
    }
}
