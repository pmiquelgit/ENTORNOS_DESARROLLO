package poo;

public class Main {
    public static void main(String[] args) {
       
        //He borrado el ejemplo que hicimos en clase para el main y lo voy a dejar
        //Con lo que me pide la práctica 5 (Actividad 7) solamente, para tenerlo
        //Más ordenado.

        //Creo una biblioteca que se llame "Central"
        Biblioteca biblioCentral = new Biblioteca("Central", "Sant s'adurní", 9, 22);

        LibroFisico libroFisico1 = new LibroFisico("PinochoFísico", "019403NCN93X9", "Santillana", "Español", 120, 2000, "Si", "Prat de llobregat");
        LibroDigital libroDigital1 = new LibroDigital("PanchoDigital", "983749DBD92", "LibrosMundo", "Francés", 134, 2002, "Si", "EPUB", 4.53);



    }
}
