package poo;
public class Main {
    public static void main(String[] args) {
        PersonaPoo persona1 = new PersonaPoo("Mbappe",26);
        PersonaPoo persona2 = new PersonaPoo("Lamine",18);

        persona1.setDireccion("Madrid, 10");

        persona1.mostrarInformacion();
        persona2.mostrarInformacion();

        System.out.println("Para la persona 1 sabemos que tiene " + persona1.getEdad() + " años.");

        Sala sala1 = new Sala("Sala del comienzo", 21, true, "estudio", true);


        sala1.informacionSala();
        
        sala1.estaDisponible();

        sala1.tienePizarra();
    }
}
