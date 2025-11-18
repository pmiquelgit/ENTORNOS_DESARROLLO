package poo;

public class Main {
    public static void main(String[] args) {
       
        //He borrado el ejemplo que hicimos en clase para el main y lo voy a dejar
        //Con lo que me pide la práctica 5 (Actividad 7) solamente, para tenerlo
        //Más ordenado.

        //Creo una biblioteca que se llame "Central"
        Biblioteca biblioCentral = new Biblioteca("Central", "Sant s'adurní", 9, 22);

        //Creo un libro de cada tipo, tanto físico como digital
        LibroFisico libroFisico1 = new LibroFisico("PinochoFísico", "019403NCN93X9", "Santillana", "Español", 120, 2000, "Si", "Prat de llobregat");
        LibroDigital libroDigital1 = new LibroDigital("PanchoDigital", "983749DBD92", "LibrosMundo", "Francés", 134, 2002, "Si", "EPUB", 4.53);

        //Creo una sala de cada tipo que puede haber disponible
        Sala salaEstudio = new Sala("SalaEstudio1", 32, true, "Estudio", true, 24, 32);
        Sala salaLectura = new Sala("SalaLectura", 24, true, "Lectura", true, 16, 24);
        Sala salaInfantil = new Sala("SalaInfantil", 18, false, "Infantil", false, 8, 18);

        //Creo tanto un usuario como un empleado
        Usuario usuario1 = new Usuario("Manolo", 24, "Jerez de la frontera", "González", "29367292M", "manoloemail@gmail.com", "+34 385039628", "Informático", 2, 210);
        Empleado empleado1 = new Empleado("FinalBoss", 56, "Tarragona", "Pérez Gómez", "34827402F", "finalboss@gmail.com", "+34 934683295", "Administrador", 24, "Jefe", 20000);


        //Voy a asociar al usuario a la sala de estudio, y al empleado le asignaré un prestamo

        salaEstudio.entrarPersona(usuario1);
        System.out.println();
        
        biblioCentral.registrarPrestamo(empleado1, libroFisico1);
        System.out.println();

        //Finalmente, mostraré la información de cada objeto que he creado por pantalla
        //De la biblioteca
        biblioCentral.informacionBiblioteca();
        System.out.println();
        
        //De los libros
        libroFisico1.informacion();
        libroDigital1.informacion();
        System.out.println();
        
        //De las salas
        salaEstudio.informacionSala();
        salaLectura.informacionSala();
        salaInfantil.informacionSala();
        System.out.println();

        //De las personas
        usuario1.mostrarInformacion();
        empleado1.mostrarInformacion();

    }
}
