# Requerimientos
Un emprendedor nos ha solicitado una aplicación sencilla para gestionar su inventario de productos en la bodega de su negocio. 
Nos ha dicho que, con tanta tecnología, necesita algo práctico y funcional.

---
## ¿Cómo especificarías mejor el requerimiento? (Validación)

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
Para este caso, podemos utilizar los casos de usos presentados anteriormente, asi como tambien las instrucciones especificadas en el mismo enunciado de la tarea, con esto podemos hacer pruebas de funcionamiento contrastando los artifactos de especifiaciones que tenemos con el programa como tal, buscando como resultado que nuestro programa responda como se tiene esperado que responda.

## Organización, explicar cómo se organizó el proyecto y el flujo de trabajo de éste.

Trabajamos con [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow#:~:text=What%20is%20Gitflow%3F,lived%20branches%20and%20larger%20commits.), con ello separamos el proyecto en 3 categorías de branches:
  - Main
  - Develop
  - Features (ejemplo: feature_branch, log4j_branch, etc.)

Dentro de estas definimos roles para hacer los pull request y merges dentro del repositorio. En estos se definió que cualquiera de los integrantes puede iniciar un pull request, pero este debe ser aprobado (con un review) por el otro compañero, asignándolo como reviewer en el pull request y solo haciendo efectivo el merge una vez aprobado dicho pull request.

Con ello tenemos que en la branch main se tendrá la versión más actualizada terminada del programa, es decir, por ejemplo la versión 1.0.0 con todas las funcionalidades terminadas (ejemplo como en producción), en Develop estará el código a trabajar para integrar features, y en features estarán funcionalidades a desarrollar.

En cuanto al desarrollo como tal, se crean branches a partir de develop para hacer features, una vez terminadas estas se mergean a develop, y una vez listas todas las features planteadas para el lanzamiento (en este caso todo lo pedido por la tarea) se mergea develop con main.

En cuanto a la protección de las branches, se definió un ruleset para proteger la branch main de posibles borrados accidentales de datos, así como también la regla de que se debe hacer un pull request antes de hacer un merge hacia esta, y dicho pull request debe ser aprobado por al menos una persona (para seguir la lógica de lo explicado anteriormente).

También se configuro Slack, para tener notificaciones sobre la actividad realizada en el repositorio.

## Incluir evidencia de flujo de trabajo y configuraciones realizadas (Imágenes de pantalla).
![image](https://github.com/user-attachments/assets/6f308cc6-3bea-4d9e-ac48-44a68e829787)
![image](https://github.com/user-attachments/assets/a4262e7e-6aa9-40c2-b217-e26ebb75d31a)
![image](https://github.com/user-attachments/assets/67db821a-e9ad-4fe3-88f7-1d3fbf2ed264)
![image](https://github.com/user-attachments/assets/55f0624b-68e1-43a6-bcca-b4a718f8d8fa)
![image](https://github.com/user-attachments/assets/fb85d0c3-202e-430b-9a7f-40d045d0dbec)
![image](https://github.com/user-attachments/assets/3f39fd76-6227-4868-9705-d310fdf0bd65)
![image](https://github.com/user-attachments/assets/1801b227-72d1-49e1-b67a-60b104b1271a)


## Problemas encontrados y cómo se solucionaron.
- Uno de los problemas que encontramos como consecuencia de cómo se creó el proyecto en una primera instancia, fue que al añadir la feature de log4j, se tuvo que cambiar mayormente la estructura del proyecto al integrar Maven. Se solucionó haciendo el merge como se haría normalmente de la branch de log4j hacia develop y después integrando los cambios de la branch de excepciones manualmente, ya que estos no eran mayores.
- Otro de los problemas fue en cuanto a la especificación de los requerimientos, con la cual se hicieron varios supuestos razonables en base a la información que teníamos disponible, así también como a preguntas que se le realizaron en clase al profesor acerca de la tarea.

# Pruebas
Se utilizó greentest.ai, y en una primera instancia hicimos pruebas solamente para la verificación de nuestro programa, enfocándonos en el correcto funcionamiento del CRUD en el inventario:
![image](https://github.com/user-attachments/assets/61b1331d-c87b-4e75-aebf-93423a047e79)
Dentro de una segunda instancia se añadieron pruebas para probar fallos comunes dentro del funcionamiento del programa, como por ejemplo opciones no válidas dentro del menú, o tratar de borrar un producto no existente en el inventario.
![image](https://github.com/user-attachments/assets/6f1ae47d-76c3-4ab6-90d2-4b8637bc2377)
También se probó la generación con IA de las pruebas, y aunque en este caso no se utilizaron ocuparon, quedaron el borrador para tenerlas en cuenta en un posible nuevo ciclo de pruebas
![image](https://github.com/user-attachments/assets/60fc8408-c7a2-4735-90cf-062493f6ad55)

![image](https://github.com/user-attachments/assets/071af148-f2e7-4382-8788-2a2a71ca35b1)

### Feedback Greentest.ai
[Video](https://www.youtube.com/watch?v=T-8TOh-8kKM)




