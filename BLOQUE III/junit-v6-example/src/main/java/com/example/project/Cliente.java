package com.example.project;


public class Cliente {
    
    private String nombre;
    private String correo;
    private String direccion;


    public Cliente(String nombre, String correo, String direccion){

        //HE TENIDO QUE CORREGIR ESTE CONSTRUCTOR PARA QUE SONARCUBE FUNCIONASE EN LA PARTE 3 DEL PROYECTO
        if (nombre == null || nombre.isEmpty()) {
            throw new NullPointerException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;

    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getCorreo()
    {
        return this.correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    //MÉTODO "toString" para mostrar la información del cliente sobreescribiendo
    //el método por este con "@Override"
    @Override
    public String toString()
    {
        return "Nombre: " + this.nombre + " - Correo: " + this.correo;
    }
}
