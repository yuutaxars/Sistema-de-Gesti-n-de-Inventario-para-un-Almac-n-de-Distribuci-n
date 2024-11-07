public class Pedido {
    private int id;
    private String estado;
    private Producto producto;

    public Pedido(int id, Producto producto) {
        this.id = id;
        this.producto = producto;
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID Pedido: " + id + " | Producto: " + producto.getNombre() + " | Estado: " + estado;
    }
}
