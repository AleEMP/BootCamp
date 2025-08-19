package Practicas.TrabajoClases;
import Practicas.TrabajoClases.Producto;
import Practicas.TrabajoClases.Cliente;
import java.util.HashMap;
import java.util.Map;
public class Tienda {
    private Map<String, Producto> inventario;
    private Map<String, Cliente> clientes;

    public Tienda() {
        this.inventario = new HashMap<>();
        this.clientes = new HashMap<>();
        inicializarDatosDePrueba();
    }
    public int getNumClientes(){
        return clientes.size();
    }
    public void agregarProducto(Producto p) {
        inventario.put(p.getId(), p);
    }
    public Producto buscarProducto(String id) {
        return inventario.get(id);
    }
    public void registrarCliente(Cliente c) {
        clientes.put(c.getId(), c);
    }
    public Cliente buscarCliente(String id) {
        return clientes.get(id);
    }
    public void mostrarInventario() {
        System.out.println("\n---Inventario disponible---");
        for (Producto p : inventario.values()) {
            System.out.println(p.mostrarInformacion());
        }
        System.out.println("-----------------------------");
    }

    public void mostrarClientes() {
        System.out.println("\n--- Clientes registrados ---");
        clientes.values().forEach(cliente -> System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre()));
        System.out.println("----------------------------");
    }

    private void inicializarDatosDePrueba() {
        agregarProducto(new Producto("P1", "Laptop", 2300.00, 15));
        agregarProducto(new Producto("P2", "Mouse", 25.00, 100));
        agregarProducto(new Producto("P3", "Teclado", 75.00, 50));
        registrarCliente(new Cliente("C1", "Ana Pérez"));
        registrarCliente(new Cliente("C2", "Luis García"));
    }
}