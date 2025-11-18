package poo;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends PersonaPoo{
    
    private int numSocio;
    private List<Libro>listaPrestados;

    public Usuario(String nombre, int edad, String direccion, String apellidos, String dni, String email, String telefono, String profesion, int annoExperiencia, int numSocio)
    {
        super(nombre, edad, apellidos, dni, email, telefono, profesion, annoExperiencia);
        this.numSocio = numSocio;
        this.listaPrestados = new ArrayList<>();
      
    }

    //GETTERS Y SETTERS
    public void setNumSocio(int numSocio)
    {
        this.numSocio = numSocio;
    }

    public int numSocio()
    {
        return this.numSocio;
    }

    public List<Libro> getListaLibrosPrestados()
    {
        return listaPrestados;
    }


    //MÉTODOS PARA PRESTAR O DEVOLVER UN LIBRO
    public void prestarLibro(Libro libro)
    {
        this.listaPrestados.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + " ha sido prestado.");
    }

    public void devolverLibro(Libro libro)
    {
        this.listaPrestados.remove(libro);
        System.out.println("Libro '" + libro.getTitulo() + " ha sido devuelto.");
    }
}
