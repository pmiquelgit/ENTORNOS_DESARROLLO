package poo;

public class Libro {
    
    //Defino las características que tiene el libro
    String titulo;
    String ISBN;
    String editorial;
    String idioma;
    int numPaginas;
    int anno;
    String dispReserva;


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

    //Creo los getters y setters para cada característica
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



}
