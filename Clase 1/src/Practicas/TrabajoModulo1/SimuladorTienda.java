package Practicas.TrabajoModulo1;
import java.util.Scanner;
import java.util.List;

public class SimuladorTienda {
    private static Tienda tienda = new Tienda();
    private static Scanner scanner = new Scanner(System.in);
    private static Cliente clienteActual = null;

    public static void main(String[] args) {
        System.out.println("---Simulador de tienda---");
        mostrarMenuInicial();
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    tienda.mostrarInventario();
                    break;
                case 2:
                    agregarProductoAlCarrito();
                    break;
                case 3:
                    clienteActual.getCarrito().mostrarContenido();
                    break;
                case 4:
                    realizarCompra();
                    break;
                case 5:
                    mostrarHistorial();
                    break;
                case 6: salir = true;
                break;
                default: System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private static void iniciarSesion() {
        System.out.println("\n--- Iniciar sesion ---");
        tienda.mostrarClientes();
        System.out.print("Ingrese su ID de cliente: ");
        String id = scanner.nextLine();
        clienteActual = tienda.buscarCliente(id);
        if (clienteActual != null) {
            System.out.println("Bienvenido, " + clienteActual.getNombre());
        } else {
            System.out.println("Cliente no encontrado....");
            System.exit(0);
        }
    }
    private static void mostrarMenuInicial() {
        System.out.println("Hola ¿Eres cliente? (s/n)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            System.out.println("Por favor, inicia sesion");
            iniciarSesion();
        } else {
            System.out.println("No te preocupes, puedes registrarte");
            crearCliente();
        }
    }
    private static void crearCliente(){
        String idTemp= "C"+(tienda.getNumClientes()+1);
        System.out.print("Ingresa tu nombre: ");
        String nombre= scanner.nextLine();
        tienda.registrarCliente(new Cliente(idTemp,nombre));
        System.out.println("¡Listo, estás dentro, "+nombre+"!");
        iniciarSesion();
    }
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1. Ver inventario de la tienda");
        System.out.println("2. Agregar producto a mi carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Realizar compra");
        System.out.println("5. Ver mi historial de compras");
        System.out.println("6. Salir");
        System.out.print("Elija una opcion: ");
    }

    private static void agregarProductoAlCarrito() {
        tienda.mostrarInventario();
        System.out.print("Ingrese el ID del producto a agregar: ");
        String idProducto = scanner.nextLine();
        Producto producto = tienda.buscarProducto(idProducto);

        if (producto != null) {
            System.out.print("Ingrese la cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            if (producto.getStock() >= cantidad) {
                clienteActual.getCarrito().agregarProducto(producto, cantidad);
                producto.setStock(producto.getStock() - cantidad);
                System.out.println("Producto(s) agregado(s) al carrito");
            } else {
                System.out.println("No hay suficiente stock disponible");
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void realizarCompra() {
        Carrito carrito = clienteActual.getCarrito();
        carrito.mostrarContenido();
        double total = carrito.calcularTotal();
        System.out.println("El total de su compra es: s/" + String.format("%.2f", total));
        if (total > 500) {
            double descuento = total * 0.10;
            total -= descuento;
            System.out.println("¡Felicidades! Se ha aplicado un 10% de descuento. Descuento: s/" + String.format("%.2f", descuento));
            System.out.println("Nuevo total con descuento: s/" + String.format("%.2f", total));
        }

        System.out.print("¿Desea confirmar la compra? (s/n): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            Pedido nuevoPedido = new Pedido(carrito.getProductos(), total);
            clienteActual.agregarAlHistorial(nuevoPedido);
            carrito.vaciar();
            System.out.println("Compra realizada con éxito. Su pedido ha sido registrado");
        } else {
            System.out.println("Compra cancelada");
        }
    }
    private static void mostrarHistorial(){
        List<Pedido> pedidosCliente = clienteActual.getHistorialCompras();
        int i=1;
        for (Pedido p : pedidosCliente){
            System.out.println("-----> Pedido #"+i);
            p.obtenerResumen();
            i++;
        }
    }
}