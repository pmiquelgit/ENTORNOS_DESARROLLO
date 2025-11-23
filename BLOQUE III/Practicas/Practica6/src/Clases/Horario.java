package Clases;
import java.sql.Time;

public class Horario {

    private String diaSemana;
    private Time horaInicio;
    private Time horaFin;

    public Horario(String diaSemana, Time horaInicio, Time horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}
