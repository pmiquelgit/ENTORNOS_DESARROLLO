package poo;

public class Biblioteca {
    String nombre;
    String direccion;
    int horaApertura;
    int horaCierre;

    public Biblioteca (String nombre,String direccion, int horaApertura, int horaCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    //GETTERS Y SETTERS PARA CADA ATRIBUTO
    public void setNombre(String nombre) {
        nombre = this.nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setDireccion(String direccion) {
        direccion = this.direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setHoraApertura(int horaApertura) {
        horaApertura = this.horaApertura;
    }

    public int getHoraApertura() {
        return this.horaApertura;
    }

    public void setHoraCierre(int horaCierre) {
        horaCierre = this.horaCierre;
    }

    //FUNCION PARA COMPROBAR SI ESTÁ ABIERTA
    public void estaAbierta(int hora) {
        if (hora > this.horaApertura && hora < this.horaCierre) {
            System.out.println("La biblioteca está abierta.");
        } else {
            System.out.println("La biblioteca está cerrada.");
        }

    }

    //FUNCION PARA LA INFORMACIÓN DE LA BIBLIOTECA
    public void informacionBiblioteca() {
        System.out.println("Biblioteca: " + this.nombre + ". Dirección: " + this.direccion + ". Abierto desde las " + this.horaApertura + " hasta las " + this.horaCierre);
    }

}
