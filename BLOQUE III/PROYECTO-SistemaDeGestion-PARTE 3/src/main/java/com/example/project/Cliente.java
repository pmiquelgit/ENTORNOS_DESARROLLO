package com.example.project;


public class Cliente {
    
    private String nombre;
    private String correo;
    private String direccion;
    private int anyosAntiguedad;
    private boolean esVip;
    private String pais;

    // Nuevo constructor para cliente con los atributos nuevos que me pide
    public Cliente(String nombre, String correo, String direccion, int anyosAntiguedad, boolean esVip, String pais) {
        if (nombre == null || nombre.isEmpty()) {
            throw new NullPointerException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.anyosAntiguedad = anyosAntiguedad;
        this.esVip = esVip;
        this.pais = pais;


    }

    // Mantengo el constructor antiguo para que los test no colapsen
    // Este constructor no tiene los atributos nuevos que he añadido
    public Cliente(String nombre, String correo, String direccion){

        //HE TENIDO QUE CORREGIR ESTE CONSTRUCTOR PARA QUE SONARCUBE FUNCIONASE EN LA PARTE 3 DEL PROYECTO
        this(nombre, correo, direccion, 0, false, "ESPAÑA");

    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAnyosAntiguedad() {
        return this.anyosAntiguedad;
    }

    public void setAnyosAntiguedad(int anyosAntiguedad) {
        this.anyosAntiguedad = anyosAntiguedad;
    }

    public boolean isEsVip() {
        return this.esVip;
    }

    public boolean getEsVip() {
        return this.esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    //MÉTODO "toString" para mostrar la información del cliente sobreescribiendo
    //el método por este con "@Override"
    @Override
    public String toString()
    {
        return "Nombre: " + this.nombre + " - Correo: " + this.correo;
    }
}
