import java.util.ArrayList;
import java.util.Scanner;

public class Contador {
    private ArrayList<Producto> inventario;

    public Contador(ArrayList<Producto> inventario) {
        this.inventario = inventario;
    }


    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú Contador:");
            System.out.println("1. Ver Inventario");
            System.out.println("2. Generar Informe PDF");
            System.out.println("3. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verInventario();
                    break;
                case 2:
                    generarInformePDF();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void verInventario() {
        System.out.println("Inventario:");
        for (Producto p : inventario) {
            System.out.println(p);  // Muestra los productos
        }
    }

    public void generarInformePDF() {
        // Aquí va la implementación para generar el informe PDF
        // (suponiendo que ya está funcionando correctamente)
    }
}
