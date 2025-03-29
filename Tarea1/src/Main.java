import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Inicializando cosas necesarias
        Usuarios usuario = new Usuarios("admin", "123");
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        String name = "", pass = "";

        //test products
        Productos computador = new Productos("Computador", "Computador de escritorio", 10, 100000, "Electronicos");
        Productos telefono = new Productos("Telefono", "Telefono celular", 10, 10000, "Electronicos");
        Productos limpieza = new Productos("Limpieza", "Limpieza de casa", 10, 1000, "Hogar");
        Productos pintura = new Productos("Pintura", "Pintura de casa", 10, 100, "Hogar");
        inventario.agregar_producto(computador, 10);
        inventario.agregar_producto(telefono, 100);
        inventario.agregar_producto(limpieza, 62);
        inventario.agregar_producto(pintura, 1);

        //Menu
        //User handling
        while (!usuario.check_usuario(usuario, name, pass)){
            System.out.println("""
               \t Bienvenido al inventario de productos
               \t Ingresa tu Usuario
            """);
            name = scanner.nextLine();
            System.out.println("\t Ingresa tu password");
            pass = scanner.nextLine();
            if(!usuario.check_usuario(usuario, name, pass)){
                System.out.println("Usuario o password incorrecto, intenta nuevamente");
            }
        }
        while (true){
            try {
                System.out.println("""
                        \tBienvenido al inventario de productos, seleccione una opcion:
                        1) Agregar producto al inventario
                        2) Ver inventario                        
                        3) Actualizar inventario                        
                        4) Eliminar producto                        
                        5) Buscar por categoria                        
                        6) Buscar por producto                        
                        7) Generar reporte de inventario                        
                        8) Salir                        
                        """);
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingresa el nombre del producto");
                        scanner.nextLine();
                        String nombre = scanner.nextLine();
                        System.out.println("Ingresa la descripcion del producto");
                        String descripcion = scanner.nextLine();
                        System.out.println("Ingresa la cantidad del producto");
                        int cantidad = scanner.nextInt();
                        System.out.println("Ingresa el precio del producto");
                        double precio = scanner.nextDouble();
                        scanner.nextLine(); //Esto limpia el buffer ya que nextDouble no consume \n
                        System.out.println("Ingresa la categoria del producto");
                        String categoria = scanner.nextLine();
                        try {
                            Productos producto = new Productos(nombre, descripcion, cantidad, precio, categoria);
                            if (producto.getCantidad() < 0 || producto.getPrecio() < 0) {
                                throw new IllegalArgumentException("La cantidad o el precio no pueden ser negativos.");
                            } else {
                                inventario.agregar_producto(producto, cantidad);
                                System.out.println("Producto agregado");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("La cantidad o el precio no pueden ser negativos. Por favor ingresa de nuevo el producto" + e.getMessage());
                        }
                    }
                    case 2 -> inventario.print_Inventario();
                    case 3 -> {
                        System.out.println("Ingresa el nombre producto que deseas actualizar");
                        scanner.nextLine();
                        String producto_update = scanner.nextLine();
                        Productos current_producto = inventario.check_producto(producto_update);
                        if (current_producto == null) break;
                        System.out.println("1) Agregar cantidad\n2) Eliminar cantidad");
                        switch (scanner.nextInt()) {
                            case 1 -> {
                                System.out.println("Cantidad a agregar");
                                int plus = scanner.nextInt();
                                inventario.agregar_cantidad(current_producto, plus);
                                System.out.println("Producto actualizado");
                            }
                            case 2 -> {
                                System.out.println("Cantidad a eliminar");
                                int minus = scanner.nextInt();
                                inventario.eliminar_cantidad(current_producto, minus);
                                System.out.println("Producto actualizado");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Ingresa el nombre del producto que deseas eliminar");
                        scanner.nextLine();
                        String producto_delete = scanner.nextLine();
                        inventario.eliminar_producto(inventario.check_producto(producto_delete));
                        System.out.println("Producto eliminado");
                    }
                    case 5 -> {
                        System.out.println("Ingresa la categoria del producto que deseas buscar");
                        scanner.nextLine();
                        String categoria_search = scanner.nextLine();
                        inventario.print_categoria(categoria_search);
                    }
                    case 6 -> {
                        System.out.println("Ingresa el nombre del producto que deseas buscar");
                        scanner.nextLine();
                        String producto_search = scanner.nextLine();
                        inventario.check_producto(producto_search);
                    }
                    case 7 -> inventario.reporte_inventario();
                    case 8 -> System.exit(0);
                }
            }catch (InputMismatchException e) {
                System.out.println("Ingresa un numero valido" + e.getMessage());
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Error: No se encontraron más elementos en la entrada." + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Error: El scanner ya está cerrado." + e.getMessage());
            }
        }
    }
}