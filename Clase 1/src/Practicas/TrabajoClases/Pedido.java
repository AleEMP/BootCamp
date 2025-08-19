package Practicas.TrabajoClases;
import  Practicas.TrabajoClases.Producto;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Date fecha;
    private double total;
    private Map<Producto, Integer> items;

    public Pedido(Map<Producto, Integer> items, double total) {
        this.fecha = new Date();
        this.items = new HashMap<>(items);
        this.total = total;
    }

    public void obtenerResumen() {
        System.out.println("Fecha del Pedido: "+fecha);
        System.out.println("Total: s/"+String.format("%.2f", total));
        System.out.println("Items:");
        for(Map.Entry<Producto, Integer> entry : items.entrySet()){
            System.out.println("  - "+entry.getValue()+" x "+entry.getKey().getNombre());
        }
    }
}