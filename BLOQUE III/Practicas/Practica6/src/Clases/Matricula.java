package Clases;

import java.util.Date;

public class Matricula {
    
    private Date fecha;
    private double notaFinal;

    public Matricula(Date fecha, double notaFinal) {
        this.fecha = fecha;
        this.notaFinal = notaFinal;
    }

    public double calcularNotaFinal() {
        return 0; //<-- Agrego esto para que el archivo no me salte con error
    }
}
