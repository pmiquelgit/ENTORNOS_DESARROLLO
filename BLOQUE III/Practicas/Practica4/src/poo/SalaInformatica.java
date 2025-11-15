package poo;

public class SalaInformatica extends Sala {
    
    int numEquipos;

    public SalaInformatica (String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva, int numPersonas, int aforoMax, int numMesas, int numEquipos)
    {
        super(nombre, capacidad, pizarra, tipo, dispReserva, numPersonas, aforoMax);
        this.numEquipos = numEquipos;
    }

    //GETTERS Y SETTERS
    public void setNumEquipos(int numEquipos)
    {
        this.numEquipos = numEquipos;
    }

    public int getNumEquipos()
    {
        return this.numEquipos;
    }
}
