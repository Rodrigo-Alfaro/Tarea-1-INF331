import org.w3c.dom.ls.LSOutput;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Inventario {

    private Map<Productos, Integer> inventario;

    Inventario() {
        this.inventario = new HashMap<>();
    }

    //Crud Related
    protected void agregar_producto(Productos producto, int cantidad) {
        try {
            inventario.put(producto, cantidad);
        } catch (Exception e) {
            System.out.println("Error al agregar el producto" + e.getMessage());
        }
    }

    protected void eliminar_cantidad(Productos producto, int cantidad) {
        try {
            int cantidad_disponible = inventario.get(producto) - cantidad;
            inventario.put(producto, cantidad_disponible);
        } catch (Exception e) {
            System.out.println("Error al eliminar la cantidad del producto" + e.getMessage());
        }
    }

    protected void eliminar_producto(Productos producto){
        try {
            inventario.remove(producto);
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto" + e.getMessage());
        }
    }

    protected void agregar_cantidad(Productos producto, int cantidad){
        try {
            int cantidad_disponible = inventario.get(producto) + cantidad;
            inventario.put(producto, cantidad_disponible);
        } catch (Exception e) {
            System.out.println("Error al agregar la cantidad del producto" + e.getMessage());
        }
    }

    protected Productos check_producto(String name) {
        for (Productos producto : inventario.keySet()) {
            if (producto.getNombre().equals(name)) {
                System.out.println("Actualmente hay " + inventario.get(producto) + " unidades");
                return producto;
            }
        }
        //System.out.println("Producto no encontrado"); Se comenta para evitar doble mensaje.
        return  null;
    }

    //reporte
    protected void reporte_inventario(){
        System.out.println("Inventario actual:");
        int val = 0;
        Vector<String> agotados = new Vector<>();
        for (Map.Entry<Productos, Integer> entry : inventario.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.printf("- Producto: %s (Cantidad: %d)%n", producto.getNombre(), cantidad);
            val += (int) (producto.getPrecio() * cantidad);
            if (cantidad == 0) agotados.add(producto.getNombre());
        }
        System.out.println("Valor Inventario: " + val);
        System.out.println("Productos agotados: ");
        for (String producto : agotados) {
            System.out.println(producto);
        }
    }

    //Print related
    protected void print_categoria(String categoria){
        System.out.println("Inventario actual:");
        for (Map.Entry<Productos, Integer> entry : inventario.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();
            if(producto.getCategoria().equals(categoria)){
                System.out.printf("- Producto: %s (Cantidad: %d)%n", producto.getNombre(), cantidad);
            }
        }
    }

    protected void print_Inventario() {
        System.out.println("Inventario actual:");
        for (Map.Entry<Productos, Integer> entry : inventario.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.printf("- Producto: %s (Cantidad: %d)%n", producto.getNombre(), cantidad);
        }
    }
}