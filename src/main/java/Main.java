import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inventario compartido entre todos los roles
        ArrayList<Producto> inventario = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // Instanciando los roles con acceso al inventario compartido
        Administrador administrador = new Administrador(inventario, pedidos);

        Almacenero almacenero = new Almacenero(inventario, pedidos);
        Contador contador = new Contador(inventario);



        // Menú principal para elegir el rol
        while (true) {
            System.out.println("Menú de Roles:");
            System.out.println("1. Administrador");
            System.out.println("2. Almacenero");
            System.out.println("3. Contador");
            System.out.println("4. Salir");

            System.out.print("Seleccione su rol: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    administrador.menu(scanner);
                    break;
                case 2:
                    almacenero.menu(scanner);
                    break;
                case 3:
                    contador.menu(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
