
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;
    private Cliente cliente;

    public Pedido(Cliente cliente)
    {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p)
    {
        if (p != null)
        {
            productos.add(p);
        }
    }

    public double calcularTotal()
    {
        double total = 0.0;
        for (Producto p : productos)
        {
            total += p.calcularPrecioFinal();
        }
        return total;
    }

    public void mostrarResumen()
    {
        System.out.println("RESUMEN DEL PEDIDO:");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Productos: ");
        for (Producto p : productos)
        {
            System.out.println(" - " + p.getNombre() + ". Precio: " + p.getPrecio());
        }
        System.out.println("Importe total del pedido: " + calcularTotal());

    }
    
}
