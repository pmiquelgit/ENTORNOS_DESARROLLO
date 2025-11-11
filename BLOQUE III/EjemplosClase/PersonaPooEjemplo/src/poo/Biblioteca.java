package poo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private int horaApertura;
    private int horaCierre;

    //AQUÍ AÑADO LAS LISTAS QUE ME PIDE
    private List<Libro>libros;
    private List<Sala>salas;


    public Biblioteca (String nombre,String direccion, int horaApertura, int horaCierre) 
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;

        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    //CREAR LOS MÉTODOS PARA AÑADIR Y ELIMINAR LIBROS DE LAS LISTAS
    public void addLibro(Libro libro)
    {
        this.libros.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + "' añadido a la biblioteca.");
    }

    public void removeLibro(Libro libro)
    {
        if (this.libros.remove(libro))
        {
            System.out.println("Libro '" + libro.getTitulo() + "' eliminado de la biblioteca.");
        } else 
        {
            System.out.println("El libro '" + libro.getTitulo() + "' no estaba en la biblioteca.");
        }
        
    }

    //CREAR LOS MÉTODOS PARA AÑADIR Y ELIMINAR SALAS DE LAS LISTAS
    public void addSala(Sala sala)
    {
        this.salas.add(sala);
        System.out.println("La sala '" + sala.getNombre() + "' ha sido añadida.");
    }

    public void removeSala(Sala sala)
    {
        if (this.salas.remove(sala))
        {
            System.out.println("La sala '" + sala.getNombre() + "' ha sido eliminada.");
        } else
        {
            System.out.println("La sala '" + sala.getNombre() + "' no estaba en la biblioteca." );
        }
    }

    //GETTERS Y SETTERS PARA CADA ATRIBUTO
    public void setNombre(String nombre) 
    {
        nombre = this.nombre;
    }

    public String getNombre() 
    {
        return this.nombre;
    }

    public void setDireccion(String direccion) 
    {
        direccion = this.direccion;
    }

    public String getDireccion() 
    {
        return this.direccion;
    }

    public void setHoraApertura(int horaApertura) 
    {
        horaApertura = this.horaApertura;
    }

    public int getHoraApertura() 
    {
        return this.horaApertura;
    }

    public void setHoraCierre(int horaCierre) 
    {
        horaCierre = this.horaCierre;
    }

    //FUNCION PARA COMPROBAR SI ESTÁ ABIERTA
    public void estaAbierta(int hora) 
    {
        if (hora > this.horaApertura && hora < this.horaCierre) 
        {
            System.out.println("La biblioteca está abierta.");
        } else {
            System.out.println("La biblioteca está cerrada.");
        }

    }

    //FUNCION PARA LA INFORMACIÓN DE LA BIBLIOTECA
    public void informacionBiblioteca() 
    {
        System.out.println("Biblioteca: " + this.nombre + ". Dirección: " + this.direccion + ". Abierto desde las " + this.horaApertura + " hasta las " + this.horaCierre);
    }

    //FUNCION PARA MOSTRAR LA INFORMACIÓN DE TODA LA BIBLIOTECA

    public void mostrarBiblioteca()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Horario: Desde las " + this.horaApertura + " hasta las " + horaCierre);
        System.out.println();

        //Mostraré los libros que hay disponibles
        System.out.println("Hay " + this.libros.size() + " libros disponibles");
        System.out.println();

        //Con esta condicion junto con el bucle, muestro la información más detallada de los libros.
        if (this.libros.isEmpty())
        {
            System.out.println("No hay ningún libro en la biblioteca.");
        } else 
        {
            for (int i = 0; i < this.libros.size(); i++)
            {
                Libro libro = this.libros.get(i);
                System.out.println((i + 1) + ". " + libro.getTitulo() + " - " + libro.getEditorial() + " (" + libro.getAnno() + ").");
            }
        }

        System.out.println();
    }

//Ahora, para salas hacer lo mismo que libros, y continuar con el ejercicio.
}
