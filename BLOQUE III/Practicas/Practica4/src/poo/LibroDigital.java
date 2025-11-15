package poo;

public class LibroDigital extends Libro {
    
    private String formato;
    private double tamanyoMB;

    public LibroDigital(String titulo, String ISBN, String editorial, String idioma, int numPaginas, int anno, String dispReserva, String formato, double tamanyoMB)
    {
        super(titulo, ISBN, editorial, idioma, numPaginas, anno, dispReserva);
        this.formato = formato;
        this.tamanyoMB = tamanyoMB;
    }

    //GETTERS Y SETTERS

    public void setFormato(String formato)
    {
        this.formato = formato;
    }

    public String getFormato()
    {
        return this.formato;
    }

    public void setTamanyoMB(double tamanyoMB)
    {
        this.tamanyoMB = tamanyoMB;
    }

    public double getTamanyoMB()
    {
        return this.tamanyoMB;
    }

    @Override
    public void informacion()
    {
        super.informacion();
        System.out.println("Su formato está en: " + this.formato + " y pesa: " + this.tamanyoMB);
    }

}
