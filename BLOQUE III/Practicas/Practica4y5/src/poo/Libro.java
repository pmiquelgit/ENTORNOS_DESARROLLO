package poo;

public class Libro {
    
    //Defino las características que tiene el libro
    private String titulo;
    private String ISBN;
    private String editorial;
    private String idioma;
    private int numPaginas;
    private int anno;
    private String dispReserva;


    //Creo el objeto del libro
    public Libro (String titulo, String ISBN, String editorial, String idioma, int numPaginas, int anno, String dispReserva) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.editorial = editorial;
        this.idioma = idioma;
        this.numPaginas = numPaginas;
        this.anno = anno;
        this.dispReserva = dispReserva;
    }


    ///////////////////////////////////////////////////////////
    //FUNCIONALIDADES PARA CADA ATRIBUTO
    //Creo los getters y setters para cada característica
    ///////////////////////////////////////////////////////////

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getAnno() {
        return this.anno;
    }

    public void setDispReserva(String dispReserva) {
        this.dispReserva = dispReserva;
    }

    public String getDispReserva() {
        return this.dispReserva;
    }

    //FUNCION ESTA DISPONIBLE PARA RESERVA
    public boolean estaDisponible(String dispReserva) {
        if (dispReserva.equals("Si")) {
            System.out.println("Este libro está disponible para su reserva!");
            return true;
        } else {
            System.out.println("Este libro no está disponible para su reserva.");
            return false;
        }
    }

    //FUNCION ES EXTRANJERO SI NO ES ESPANYOL
    public boolean esExtranjero(String idioma) {
        if (idioma.equals("Español") || idioma.equals("Espanyol")) {
            System.out.println("El libro está escrito en Español.");
            return true;
        } else {
            System.out.println("El libro es extranjero, está escrito en: " + this.idioma);
            return false;
        }
    }

    //FUNCION DE INFORMACIÓN
    public void informacion() {
        System.out.println("Libro: " + this.titulo + ", editorial " + this.editorial + ", año " + this.anno + ", idioma " + this.idioma + ", número de páginas " + this.numPaginas + ". Hay disponibilidad: " + this.dispReserva);  
    }
}
