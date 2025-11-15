package poo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private int horaApertura;
    private int horaCierre;

    //AQUÍ AÑADO LAS LISTAS QUE ME PIDE <-- PRÁCTICA 4
    private List<Libro>libros;
    private List<Sala>salas;

    //PRÁCTICA 5 - AÑADIR LISTA DE PERSONAS
    private List<PersonaPoo>personas;


    public Biblioteca (String nombre,String direccion, int horaApertura, int horaCierre) 
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;

        //AQUÍ INICIALIZO LAS LISTAS  <-- PRÁCTICA 4
        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();

        //PRÁCTICA 5 - INICIALIZO LA LISTA "PERSONAS"
        this.personas = new ArrayList<>();
    }

    //PRÁCTICA 5 - MÉTODOS PARA REGISTRAR PERSONA Y PRESTAMOS EN BIBLIOTECA
    public void registrarPersona(PersonaPoo visitante)
    {
        System.out.println(visitante.getNombre() + " ha visitado la biblioteca." + nombre);
    }

    public void registrarPrestamo(PersonaPoo solicitador, Libro libro)
    {
        System.out.println("La persona " + solicitador.getNombre() + " ha tomado prestado el libro: " + libro.getTitulo());
    }


    //CREAR LOS MÉTODOS PARA AÑADIR Y ELIMINAR LIBROS DE LAS LISTAS  <-- PRÁCTICA 4
    //En vez de establecer el nombre del objeto como "l" he preferido poner "libro" al igual que con "salas"
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

    //CREAR LOS MÉTODOS PARA AÑADIR Y ELIMINAR SALAS DE LAS LISTAS  <-- PRÁCTICA 4
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

    //GETTERS Y SETTERS PARA CADA ATRIBUTO  <-- PRÁCTICA 4
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

    //FUNCION PARA COMPROBAR SI ESTÁ ABIERTA  <-- PRÁCTICA 4
    public void estaAbierta(int hora) 
    {
        if (hora > this.horaApertura && hora < this.horaCierre) 
        {
            System.out.println("La biblioteca está abierta.");
        } else 
        {
            System.out.println("La biblioteca está cerrada.");
        }
    }

    //FUNCION PARA LA INFORMACIÓN DE LA BIBLIOTECA  <-- PRÁCTICA 4
    public void informacionBiblioteca() 
    {
        System.out.println("Biblioteca: " + this.nombre + ". Dirección: " + this.direccion + ". Abierto desde las " + this.horaApertura + " hasta las " + this.horaCierre);
    }


    //MÉTODO PARA MOSTRAR LOS LIBROS QUE HAY EN LA BIBLIOTECA
    //Mostraré los libros que hay disponibles junto con su nombre, editorial y año de salida  <-- PRÁCTICA 4

        public void mostrarLibros(){
        System.out.println("Hay " + this.libros.size() + " libros disponibles");
        System.out.println();

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


    //MÉTODO PARA MOSTRAR LAS SALAS QUE HAY EN LA BIBLIOTECA  <-- PRÁCTICA 4
    //Mostraré cada una con su nombre, número de personas, la capacidad y el tipo de sala.  <-- PRÁCTICA 4
    public void mostrarSalas(){
        System.out.println("Hay " + this.salas.size() + " salas.");

        if (this.salas.isEmpty())
        {
            System.out.println("No hay salas en la biblioteca.");
        } else
        {
            for (int i = 0; i < this.salas.size(); i++)
            {
                Sala sala = this.salas.get(i);
                System.out.println((i + 1) + ". " + sala.getNombre() + " - Capacidad: " + sala.getNumPersonas() + " de " + sala.getCapacidad() + " - Tipo: " + sala.getTipo());
            }
        }
    }


    //MÉTODO PARA MOSTRAR LAS SALAS VACÍAS/DISPONIBLES  <-- PRÁCTICA 4
    //Mostraré las salas que contengan 0 personas
    public void mostrarSalasDisponibles()
    {
        System.out.println("Número de salas vacías: ");
        for (int i = 0; i < this.salas.size(); i++)
        {
            Sala sala = this.salas.get(i);
            if (sala.getNumPersonas() == 0)
            {
                System.out.println("Nombre: " + sala.getNombre() + " - Capacidad: " + sala.getCapacidad() + " - Tipo: " + sala.getTipo());
            }
        }
    }

    //MÉTODO PARA MOSTRAR LAS PERSONAS QUE HAY EN TOTAL EN TODAS LAS SALAS  <-- PRÁCTICA 4
    //Aquí haré un bucle que vaya sumando una por una el número de cada sala al total
    public void motrarTotalPersonas()
    {
        int totalPersonas = 0;
        for (Sala sala : this.salas)
        {
            totalPersonas += sala.getNumPersonas();
        }
        System.out.println("En total de todas las salas hay: " + totalPersonas + " personas.");
    }

    //FUNCION PARA MOSTRAR LA INFORMACIÓN DE TODA LA BIBLIOTECA  <-- PRÁCTICA 4

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

        //Mostraré las salas que hay disponibles 
        System.out.println("Hay " + this.salas.size() + " salas disponibles");

        if (this.salas.isEmpty())
        {
            System.out.println("No hay salas disponibles en la biblioteca.");
        } else
        {
            for (int i = 0; i < this.salas.size(); i++)
            {
                Sala sala = this.salas.get(i);
                System.out.println((i + 1) + ". " + sala.getNombre() + " - Capacidad: " + sala.getCapacidad() + " - Tipo: " + sala.getTipo());
            }
        }
    }

    //PRÁCTICA 4
    //Funcion para mostrar los libros por su nombre
    //Aquí haré un bucle que recorra toda la lista de libros que haya
    //Y que lo vaya comparando con el título introducido en el método
    public Libro buscarLibroPorTitulo(String titulo)
    {
        for (Libro libro : this.libros)
        {
            if (libro.getTitulo().equalsIgnoreCase(titulo))
            {
                return libro;
            }
        }
        return null;
    }


    public void asignarResponsable(Sala s, PersonaPoo personaResponsable)
    {
        if (salas.contains(s))
        {
            s.setPersonaResponsable(personaResponsable);
            System.out.println(personaResponsable + " es la persona responsable de esta sala.");
        } else
        {
            System.out.println("Esta sala no contiene ninguna persona responsable");
        }
    }
}
