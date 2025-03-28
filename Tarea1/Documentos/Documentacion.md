# Requerimientos
Un emprendedor nos ha solicitado una aplicación sencilla para gestionar su inventario de productos en la bodega de su negocio. 
Nos ha dicho que, con tanta tecnología, necesita algo práctico y funcional.

---
##¿Cómo especificarías mejor el requerimiento? (Validación)

---
Para aclarar y mejorar el requerimiento original, es necesario trabajar en la validación del mismo, aclarando los detalles y la funcionalidad que el emprendedor necesita.

Se pueden seguir los siguientes pasos:
- Revisión con el cliente: Proponer la especificación detallada al emprendedor y 
  pedirle que la revise para asegurarme de que está de acuerdo con las funcionalidades 
  y las limitaciones del sistema.

- Definición de criterios de aceptación: Especificar cómo el cliente sabrá si la aplicación cumple con sus expectativas. 
  Por ejemplo:
   - ¿Qué debe ver el cliente al ingresar un producto? (campos como nombre, cantidad, precio).
   - ¿Qué sucede cuando se elimina un producto? ¿Se debe mostrar algún mensaje de confirmación?
   - ¿Cómo se notifican las alertas de stock bajo? ¿En qué formato?
 
Respondiendo a estas preguntas se puede llegar a un entendimiento mutuo pero es tedioso y en este caso nuestro cliente es ficticio,
por lo que usaremos el concepto de Especificación por Ejemplo
### Funcionalidad principal:
La aplicación debe permitir al usuario gestionar el inventario de productos almacenados en la bodega del negocio.
```
1) Agregar producto al inventario
   Escenario: El emprendedor recibe un nuevo lote de "Camisa".
   Datos de entrada:
     - Nombre del producto: Camisa 
     - Descripcion del producto: Negra Talla L
     - Cantidad del producto: 50
     - Precio del producto: $10
     - Precio de venta: $25 (Considerar Venta)
     - Categoria del producto: Ropa
   Resultado esperado: La aplicación debe registrar 50 unidades de 
   "Camisa Negra Talla L" en el inventario, con un precio de $10 y categoría Ropa.
   
```
```
2) Ver inventario
Escenario: El emprendedor quiere ver el listado completo de los 
productos en el inventario.
Datos de entrada: Solicitud para ver el inventario.
Resultado esperado: La aplicación muestra una lista con todos los productos, 
incluyendo nombre, cantidad en stock. (Agregar precio unitario)
```
```
3) Actualizar inventario
Escenario: Llega un nuevo envío de 20 unidades de "Camisetas Azules Talla L".
Datos de entrada:
    - Producto: Camiseta Azul Talla L
    - Cantidad a añadir: 20
Resultado esperado: La aplicación aumenta la cantidad de "Camiseta Azul Talla L"
en 20 unidades.
```

```
4) Eliminar producto
Escenario: El emprendedor decide dejar de vender "Pantalones Verdes Talla S".
Datos de entrada:
    - Producto a eliminar: Pantalón Verde Talla S
Resultado esperado: El producto "Pantalón Verde Talla S" se elimina del
inventario.
```
```
5) Buscar por categoria
Escenario: El emprendedor quiere ver todos los productos de la categoría 
"Camisetas".
Datos de entrada:
    - Categoría: Camisetas
Resultado esperado: La aplicación muestra una lista de todos los productos que
pertenecen a la categoría "Camisetas"
```
```
6) Buscar por producto
Escenario: El emprendedor quiere encontrar rápidamente la "Camisa".
Datos de entrada:
    - Nombre del producto: Camisa
Resultado esperado: La aplicación muestra la información detallada de la
"Camisa", incluyendo cantidad en stock, precio de compra y precio de venta
```
```
7) Generar reporte de inventario
Escenario: El emprendedor necesita un reporte del inventario actual para fin de mes.
Datos de entrada:
    - Solicitud de reporte de inventario.
Resultado esperado: La aplicación genera un reporte por pantalla con el listado de todos los productos, cantidad en stock, valor total del inventario (calculado a partir del precio de compra), 
```
```
8) Salir
Escenario: El emprendedor no quiere seguir usando la aplicación.
Datos de entrada:
    - Solicitud de salida del programa.
Resultado esperado: La aplicación cierra la sesión y termina el programa.
```

## ¿Cómo asegurarías que el programa cumpla el requerimiento? (Verificación)

## Organización, explicar cómo se organizó el proyecto y el flujo de trabajo de éste.

## Incluir evidencia de flujo de trabajo y configuraciones realizadas (Imágenes de pantalla).

## Problemas encontrados y como se solucionaron.