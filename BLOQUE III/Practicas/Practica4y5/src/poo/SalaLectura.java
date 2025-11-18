package poo;

import java.util.ArrayList;
import java.util.List;

public class SalaLectura extends Sala {
    
    private List<Libro>listaLibros;

    public SalaLectura(String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva, int numPersonas, int aforoMax)
    {
        super(nombre, capacidad, pizarra, tipo, dispReserva, numPersonas, aforoMax);
        this.listaLibros = new ArrayList<>();
    }

    //GETTER PARA LA LISTA
    public List<Libro> getListaLibro()
    {
        return listaLibros;
    }


    public void agregarLibro(Libro libro)
    {
        this.listaLibros.add(libro);
        System.out.println("Se ha añadido el libro " + libro.getTitulo() + " a la sala de lectura." );
    }

    public void eliminarLibro(Libro libro)
    {
        if(this.listaLibros.remove(libro))
        {
            System.out.println("El libro " + libro.getTitulo() + " se ha eliminado de la lista.");
        } else {
            System.out.println("El libro no se encontraba en esta sala de lectura.");
        }
        
        
    }
}
