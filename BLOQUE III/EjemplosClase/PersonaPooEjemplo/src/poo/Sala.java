package poo;

public class Sala {
    
        String nombre;
        int capacidad;
        boolean pizarra;
        String tipo;
        boolean dispReserva;

    public Sala (String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva) {

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pizarra = pizarra;
        this.tipo = tipo;
        this.dispReserva = dispReserva;

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
}
