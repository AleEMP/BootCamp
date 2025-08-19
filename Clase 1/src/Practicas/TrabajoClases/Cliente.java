package Practicas.TrabajoClases;
import  Practicas.TrabajoClases.Producto;
import  Practicas.TrabajoClases.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String id;
    private String nombre;
    private Carrito carrito;
    private List<Pedido> historialCompras;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.carrito = new Carrito();
        this.historialCompras = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Carrito getCarrito() {
        return carrito;
    }
    public List<Pedido> getHistorialCompras() {
        return historialCompras;
    }
    public void agregarAlHistorial(Pedido pedido) {
        historialCompras.add(pedido);
    }
}


