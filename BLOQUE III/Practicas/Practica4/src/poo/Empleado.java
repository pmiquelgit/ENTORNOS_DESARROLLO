package poo;

public class Empleado extends PersonaPoo {
    
    private String puesto;
    private int sueldo;

    public Empleado (String nombre, int edad, String direccion, String apellidos, String dni, String email, String telefono, String profesion, int annoExperiencia, String puesto, int sueldo)
    {
        super(nombre, edad, apellidos, dni, email, telefono, profesion, annoExperiencia);
        this.puesto = puesto;
        this. sueldo = sueldo;   
    }

    public void setPuesto(String puesto)
    {
        this.puesto = puesto;
    }

    public String getPuesto()
    {
        return this.puesto;
    }

    public void setSueldo(int sueldo)
    {
        this.sueldo = sueldo;
    }

    public int getSueldo()
    {
        return this.sueldo;
    }

    
}
