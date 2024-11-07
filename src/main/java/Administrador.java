import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {
    private ArrayList<Producto> inventario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pedido> pedidos;

    public Administrador(ArrayList<Producto> inventario, ArrayList<Pedido> pedidos) {
        this.inventario = inventario;
        this.usuarios = new ArrayList<>();
        this.pedidos = pedidos;
    }

    public ArrayList<Producto> getInventario() {
        return inventario;
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú Administrador:");
            System.out.println("1. Ver Inventario");
            System.out.println("2. Agregar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Gestionar Usuarios");
            System.out.println("5. Generar Informe PDF");
            System.out.println("6. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verInventario();
                    break;
                case 2:
                    agregarProducto(scanner);
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    gestionarUsuarios(scanner);
                    break;
                case 5:
                    generarInformePDF();
                    break;
                case 6:
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
            System.out.println(p);
        }
    }
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto producto = new Producto(nombre, precio, cantidad);
        inventario.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    public void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto productoEliminar = null;
        for (Producto p : inventario) {
            if (p.getId() == id) {
                productoEliminar = p;
                break;
            }
        }

        if (productoEliminar != null) {
            inventario.remove(productoEliminar);
            System.out.println("Producto eliminado: " + productoEliminar);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void gestionarUsuarios(Scanner scanner) {
        System.out.println("Gestión de Usuarios:");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Eliminar Usuario");
        System.out.println("3. Asignar Rol a Usuario");

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                agregarUsuario(scanner);
                break;
            case 2:
                eliminarUsuario(scanner);
                break;
            case 3:
                asignarRol(scanner);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void agregarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el rol del usuario (Administrador/Almacenero/Contador): ");
        String rol = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, rol);
        usuarios.add(usuario);
        System.out.println("Usuario creado: " + usuario);
    }

    public void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a eliminar: ");
        String nombre = scanner.nextLine();

        Usuario usuarioEliminar = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                usuarioEliminar = usuario;
                break;
            }
        }

        if (usuarioEliminar != null) {
            usuarios.remove(usuarioEliminar);
            System.out.println("Usuario eliminado: " + usuarioEliminar);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void asignarRol(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a quien asignar el rol: ");
        String usuarioNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo rol: ");
        String nuevoRol = scanner.nextLine();

        for (Usuario usuarioExistente : usuarios) {
            if (usuarioExistente.getNombre().equals(usuarioNombre)) {
                usuarioExistente.setRol(nuevoRol);
                System.out.println("Rol actualizado para el usuario " + usuarioNombre);
                return;
            }
        }

        System.out.println("Usuario no encontrado.");
    }

    public void generarInformePDF() {
        // Aquí va la implementación para generar el informe PDF
        System.out.println("Generando informe PDF...");
    }
}
