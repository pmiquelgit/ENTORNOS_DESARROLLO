package poo;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    
        private String nombre;
        private int capacidad;
        private boolean pizarra;
        private String tipo;
        private boolean dispReserva;
        private int numPersonas;

        //Lista de las personas que hay en la sala
        private List<PersonaPoo>personas;

    public Sala (String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva) {

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pizarra = pizarra;
        this.tipo = tipo;
        this.dispReserva = dispReserva;
        this.numPersonas = numPersonas;

        //Constructor para la lista de personas
        this.personas = new ArrayList<>();

    }
        //////////////////////////
        //FUNCIONALIDADES
        //////////////////////////

    //GETTERS Y SETTERS PARA CADA ATRIBUTO

    public void setNombre(String nombre) {
        nombre = this.nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCapacidad(int capacidad) {
        capacidad = this.capacidad;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setPizzara(boolean pizarra) {
        pizarra = this.pizarra;
    }

    public boolean getPizarra() {
        return this.pizarra;
    }

    public void setTipo(String tipo) {
        tipo = this.tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setDispReserva(boolean dispReserva) {
        dispReserva = this.dispReserva;
    }

    public boolean getDispReserva() {
        return this.dispReserva;
    }

    public void setNumPersonas(int numPersonas){
        this.numPersonas = numPersonas;
    }

    public int getNumPersonas(){
        return this.numPersonas;
    }

    //FUNCION DE ESTÁ DISPONIBLE
    public void estaDisponible() {
        if (this.dispReserva == true) {
            System.out.println("Esta sala está disponible para ser reservada.");
        } else {
            System.out.println("Esta sala no está disponible para ser reservada.");
        }
    }

    //FUNCION PARA TIENE PIZARRA
    public void tienePizarra() {
        if (this.pizarra == true) {
            System.out.println("Esta sala dispone de pizarra.");
        } else {
            System.out.println("Esta sala no dispone de ninguna pizarra.");
        }
    }

    //FUNCION PARA LA INFORMACIÓN
    public void informacionSala() {
        System.out.println("Sala: " + this.nombre + ". Capacidad de " + this.capacidad + ". Se utiliza para: " + this.tipo + ". Dispone/no de pizarra: " + this.pizarra + ". Está disponible para su reserva: " + this.dispReserva);
    }

    //FUNCION PARA AÑADIR PERSONAS A LA SALA
    public boolean entrarPersona(PersonaPoo p)
    {
        if (this.personas.size() < this.getCapacidad())
        {
            this.personas.add(p);
            System.out.println("La persona: " + p.getNombre() + "ha entrado en la sala: " + this.nombre);
            return true;
        } else
        {
            System.out.println("Capacidad de la sala llena. " + p.getNombre() + " no puede entrar.");
            return false;
        }
    }

    //MÉTODO PARA SACAR PERSONAS DE LA SALA
    public boolean salirPersona(PersonaPoo p)
    {
        if (this.getCapacidad() > 0 && this.personas.remove(p))
        {
            System.out.println("La persona " + p.getNombre() + " ha salido de la sala.");
            return true;
        } else if (this.getCapacidad() == 0) {
            System.out.println("La sala está vacía");
            return false;
        } else
        {
            System.out.println("La persona " + p.getNombre() + " no estaba en la sala.");
            return false;
        }
       
    }
            //MÉTODO PARA MOSTRAR TODAS LAS PERSONAS QUE HAY EN LA SALA
            public void mostrarPersonas()
        {
            System.out.println("Hay " + this.personas.size() + " en la sala.");

            for (int i = 0; i < this.personas.size(); i++)
            {
                PersonaPoo persona = this.personas.get(i);
                System.out.println((i + 1) + ". " + persona.getNombre() + " - Edad: " + persona.getEdad() + " - Profesión: " + persona.getProfesion() + " - DNI: " + persona.getdni());
            }
        }
}
