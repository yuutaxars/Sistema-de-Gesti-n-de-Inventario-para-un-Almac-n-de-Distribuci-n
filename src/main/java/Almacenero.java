import java.util.ArrayList;
import java.util.Scanner;

public class Almacenero {
    private ArrayList<Producto> inventario;
    private ArrayList<Pedido> pedidos;

    public Almacenero(ArrayList<Producto> inventario, ArrayList<Pedido> pedidos) {
        this.inventario = inventario;
        this.pedidos = pedidos;
    }

    public void verInventario() {
        System.out.println("Inventario:");
        for (Producto p : inventario) {
            System.out.println(p);
        }
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú Almacenero:");
            System.out.println("1. Ver Inventario");
            System.out.println("2. Gestionar Pedidos");
            System.out.println("3. Confirmar Envío");
            System.out.println("4. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verInventario();
                    break;
                case 2:
                    gestionarPedidos();
                    break;
                case 3:
                    confirmarEnvio(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }



    public void gestionarPedidos() {
        // Implementación para gestionar pedidos
    }

    public void confirmarEnvio(Scanner scanner) {
        System.out.print("Ingrese el ID del producto a enviar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto productoEnvio = null;
        for (Producto p : inventario) {
            if (p.getId() == id) {
                productoEnvio = p;
                break;
            }
        }

        if (productoEnvio != null) {
            System.out.println("Confirmando envío de: " + productoEnvio.getNombre());
            productoEnvio.setCantidad(productoEnvio.getCantidad() - 1);
            System.out.println("Envío confirmado. Cantidad actual de " + productoEnvio.getNombre() + ": " + productoEnvio.getCantidad());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
