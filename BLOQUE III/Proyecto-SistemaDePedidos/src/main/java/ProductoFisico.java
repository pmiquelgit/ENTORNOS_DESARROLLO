public class ProductoFisico extends Producto {
    
    private double costeEnvio;

    public ProductoFisico(String nombre, double precio, double costeEnvio)
    {
        super(nombre, precio);
        this.costeEnvio = costeEnvio;
    }

    public double getCosteEnvio()
    {
        return this.costeEnvio;
    }

    public void setCosteEnvio(double costeEnvio)
    {
        this.costeEnvio = costeEnvio;
    }

    @Override
    public double calcularPrecioFinal()
    {
        double resultado = getPrecio() + costeEnvio;
        return Math.max(0.0, resultado);
    }

    @Override
    public String toString()
    {
        return "Nombre del producto digital: " + this.getNombre() + " - Precio: " + this.getPrecio();
    }

}