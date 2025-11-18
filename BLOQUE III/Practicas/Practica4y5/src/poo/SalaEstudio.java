package poo;

public class SalaEstudio extends Sala {
    
    int numMesas;

    public SalaEstudio (String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva, int numPersonas, int aforoMax, int numMesas)
    {
        super(nombre, capacidad, pizarra, tipo, dispReserva, numPersonas, aforoMax);
        this.numMesas = numMesas;
    }

    public void setNumMesas(int numMesas)
    {
        this.numMesas = numMesas;
    }

    public int getNumMesas()
    {
        return this.numMesas;
    }

}
