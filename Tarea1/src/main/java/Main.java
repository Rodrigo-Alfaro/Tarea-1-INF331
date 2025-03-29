import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

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
        logger.info("Sistema Inicializado");
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
                logger.warn("Intento de Ingreso con Usuario o password incorrecto");
            }
        }
        logger.info("Usuario: " + name + " Ingreso al sistema");

        while (true){
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
            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del producto");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa la descripcion del producto");
                    String descripcion = scanner.nextLine();
                    System.out.println("Ingresa la cantidad del producto");
                    int cantidad = scanner.nextInt();
                    System.out.println("Ingresa el precio del producto");
                    double precio = scanner.nextDouble();
                    System.out.println("Ingresa la categoria del producto");
                    String categoria = scanner.nextLine();
                    Productos producto = new Productos(nombre, descripcion, cantidad, precio, categoria);
                    inventario.agregar_producto(producto, cantidad);
                    System.out.println("Producto agregado");
                    logger.info("Producto: " + producto.getNombre() + " agregado al inventario");
                    break;
                case 2:
                    inventario.print_Inventario();
                    logger.info("Se consulta el inventario");
                    break;
                case 3:
                    System.out.println("Ingresa el nombre producto que deseas actualizar");
                    scanner.nextLine();
                    String producto_update = scanner.nextLine();
                    Productos current_producto = inventario.check_producto(producto_update);
                    if (current_producto == null) break;
                    System.out.println("1) Agregar cantidad\n2) Eliminar cantidad");
                    switch (scanner.nextInt()){//idk if this gonna work
                        case 1:
                            System.out.println("Cantidad a agregar");
                            int plus = scanner.nextInt();
                            inventario.agregar_cantidad(current_producto, plus);
                            System.out.println("Producto actualizado");
                            break;
                        case 2:
                            System.out.println("Cantidad a eliminar");
                            int minus = scanner.nextInt();
                            inventario.eliminar_cantidad(current_producto, minus);
                            System.out.println("Producto actualizado");
                            break;
                    }
                    logger.info("Producto: " + current_producto.getNombre() + " actualizado");
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del producto que deseas eliminar");
                    scanner.nextLine();
                    String producto_delete = scanner.nextLine();
                    inventario.eliminar_producto(inventario.check_producto(producto_delete));
                    System.out.println("Producto eliminado");
                    logger.info("Producto: " + producto_delete + " eliminado");
                    break;
                case 5:
                    System.out.println("Ingresa la categoria del producto que deseas buscar");
                    scanner.nextLine();
                    String categoria_search = scanner.nextLine();
                    inventario.print_categoria(categoria_search);
                    logger.info("Se consulta por la categoria: " + categoria_search);
                    break;
                case 6:
                    System.out.println("Ingresa el nombre del producto que deseas buscar");
                    scanner.nextLine();
                    String producto_search = scanner.nextLine();
                    inventario.check_producto(producto_search);
                    logger.info("Se consulta por el producto: " + producto_search);
                    break;
                case 7:
                    inventario.reporte_inventario();
                    logger.info("Se genera el reporte de inventario");
                    break;
                case 8:
                    logger.info("Sesion finalizada");
                    System.exit(0);
            }
        }
    }
}