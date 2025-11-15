package poo;

public class LibroFisico extends Libro {
    
    private int numPaginas;
    private String ubicacion;


public LibroFisico(String titulo, String ISBN, String editorial, String idioma, int numPaginas, int anno, String dispReserva, String ubicacion)    {
        super(titulo, ISBN, editorial, idioma, numPaginas, anno, dispReserva);

        this.numPaginas = numPaginas;
        this.ubicacion = ubicacion;
    }

    //GETTERS Y SETTERS

    public void setNumPaginas(int numPaginas)
    {
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas()
    {
        return this.numPaginas;
    }

    public void setUbicacion(String ubicacion)
    {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion()
    {
        return this.ubicacion;
    }

    @Override
    public void informacion()
    {
        super.informacion();
        System.out.println("Número de páginas: " + this.numPaginas + " - Ubicación del libro: " + this.ubicacion);
    }
}
