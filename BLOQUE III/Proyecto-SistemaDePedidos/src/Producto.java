public class Producto {
    
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {

        this.nombre = nombre;
        this.precio = precio;
    }

    //GETTERS Y SETTERS  PARA LOS ATRIBUTOS DE PERSONA
    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getPrecio()
    {
        return this.precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    //Aquí, implemento la función que luego sobreescribiré en las subclases
    //"ProductoFísico" y "ProductoDigital"
    public double calcularPrecioFinal() {
        return 0.0;
    }

    //Añado por aquí el método "toString" para poder mostrar la información
    //del producto sin que me develva un identificador inentendible.

    @Override
    public String toString() 
    {
        return String.format("Nombre del producto: " + this.nombre + " - Precio: " + this.precio);
    }

}
