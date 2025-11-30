public class ProductoDigital extends Producto {
    private double tamanyoDescarga;
    private double porcientoIva;
    private double descuento;

    public ProductoDigital (String nombre, double precio, double tamanyoDescarga, double porcientoIva, double descuento)
    {
        super(nombre, precio);
        this.tamanyoDescarga = tamanyoDescarga;
        this.porcientoIva = porcientoIva;
        this.descuento = descuento;
    }

    public double getTamanyoDescarga()
    {
        return this.tamanyoDescarga;
    }

    public double getPorcientoIva()
    {
        return this.porcientoIva;
    }

    public double getDescuento()
    {
        return this.descuento;
    }

    @Override
    public double calcularPrecioFinal()
    {
        double ivaAplicado = getPrecio() * (1.0 + this.porcientoIva / 100.0);
        double precioFinal = ivaAplicado - this.descuento;
        return Math.max(0.0, precioFinal);
    }

    @Override
    public String toString()
    {
        return "Nombre del producto digital: " + this.getNombre() + " - Precio: " + this.getPrecio();
    }
}
