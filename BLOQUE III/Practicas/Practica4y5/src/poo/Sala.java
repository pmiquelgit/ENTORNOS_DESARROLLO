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
    private int aforoMax;

    // DEFINO LA LISTA DE PERSONAS EN LOS ATRIBUTOS
    private List<PersonaPoo> personas;
    private PersonaPoo personaResponsable;

    public Sala(String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva, int numPersonas, int aforoMax) {

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pizarra = pizarra;
        this.tipo = tipo; //Puede ser de estudio, de lecutura o infantil
        this.dispReserva = dispReserva;
        this.numPersonas = numPersonas;
        this.aforoMax = aforoMax;
        this.personaResponsable = null;

        // CREO LA LISTA DE PERSONAS EN EL CONSTRUCTOR
        this.personas = new ArrayList<>();

    }
    //////////////////////////
    //////FUNCIONALIDADES/////
    //////////////////////////

    // GETTERS Y SETTERS PARA CADA ATRIBUTO
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

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public int getNumPersonas() {
        return this.numPersonas;
    }

    //PRÁCTICA 5 SETTERS Y GETTERS - AFORO MAX
    public void setAforoMax(int aforoMax) {
        this.aforoMax = aforoMax;
    }

    public int getAforoMax() {
        return this.aforoMax;
    }

    //PRÁCTICA 5 SETTERS Y GETTERS - PERSONA RESPONSABLE
    public void setPersonaResponsable(PersonaPoo personaResponsable) {
        this.personaResponsable = personaResponsable;
        System.out.println("La persona responsable ahora es: " + this.personaResponsable);
    }

    public PersonaPoo getPersonaResponsable() {
        return personaResponsable;
    }


    // FUNCION DE ESTÁ DISPONIBLE
    public void estaDisponible() {
        if (this.dispReserva == true) {
            System.out.println("Esta sala está disponible para ser reservada.");
        } else {
            System.out.println("Esta sala no está disponible para ser reservada.");
        }
    }

    // FUNCION PARA TIENE PIZARRA
    public void tienePizarra() {
        if (this.pizarra == true) {
            System.out.println("Esta sala dispone de pizarra.");
        } else {
            System.out.println("Esta sala no dispone de ninguna pizarra.");
        }
    }

    // FUNCION PARA LA INFORMACIÓN
    public void informacionSala() {
        System.out.println("Sala: " + this.nombre + ". Capacidad de " + this.capacidad + ". Se utiliza para: "
                + this.tipo + ". Dispone/no de pizarra: " + this.pizarra + ". Está disponible para su reserva: "
                + this.dispReserva);
    }

    // FUNCION PARA AÑADIR PERSONAS A LA SALA
    // Aquí he creado una condición que verifique si no supera la capacidad de
    // personas
    public boolean entrarPersona(PersonaPoo p) {
        if (this.personas.size() < this.getCapacidad()) {
            this.personas.add(p);
            System.out.println("La persona: " + p.getNombre() + " ha entrado en la sala: " + this.nombre);
            return true;
        } else {
            System.out.println("Capacidad de la sala llena. " + p.getNombre() + " no puede entrar.");
            return false;
        }
    }

    // MÉTODO PARA SACAR PERSONAS DE LA SALA
    // Aquí he considerado más opciones:
    // 1. Si la capacidad me perite sacar a personas (Porque si hay 0 personas no
    // habrá a quién sacar.
    // 2. Si la capacidad es de 0, que directamente me diga que no hay nadie en la
    // sala.
    // 3. Si ninguna de ellas es cierta, significa que la persona no estaba en la
    // sala directamente.
    public boolean salirPersona(PersonaPoo p) {
        if (this.getCapacidad() > 0 && this.personas.remove(p)) {
            System.out.println("La persona " + p.getNombre() + " ha salido de la sala.");
            return true;
        } else if (this.getCapacidad() == 0) {
            System.out.println("La sala está vacía");
            return false;
        } else {
            System.out.println("La persona " + p.getNombre() + " no estaba en la sala.");
            return false;
        }

    }

    // MÉTODO PARA MOSTRAR TODAS LAS PERSONAS QUE HAY EN LA SALA.
    // De nuevo, he realizado un bucle para mostrar todas las personas de la lista.
    // Junto con toda su información
    public void mostrarPersonas() {
        System.out.println("Hay " + this.personas.size() + " en la sala.");

        for (int i = 0; i < this.personas.size(); i++) {
            PersonaPoo persona = this.personas.get(i);
            System.out.println((i + 1) + ". " + persona.getNombre() + " - Edad: " + persona.getEdad() + " - Profesión: "
                    + persona.getProfesion() + " - DNI: " + persona.getdni());
        }
    }
}
