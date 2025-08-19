package Practicas.TrabajoClases;
import Practicas.TrabajoClases.Producto;
import java.util.HashMap;
import java.util.Map;

public class Carrito {
    private Map<Producto, Integer> productos;

    public Carrito() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }

    public void mostrarContenido() {
        if (productos.isEmpty()) {
            System.out.println("El carrito esta vacio.");
            return;
        }
        System.out.println("--- Contenido del carrito ---");
        productos.forEach((producto, cantidad) ->
                System.out.println(cantidad + " x " + producto.getNombre() + " (s/" + String.format("%.2f", producto.getPrecio()) + ")")
        );
        System.out.println("Total de : "+" s/"+calcularTotal());
        System.out.println("-----------------------------");
    }
    public Map<Producto, Integer> getProductos() {
        return productos;
    }
    public void vaciar() {
        productos.clear();
    }
}