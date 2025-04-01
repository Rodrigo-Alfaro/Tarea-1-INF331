public class Productos {

    //Fields
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String categoria;

    //Constructor
    Productos(String nombre, String descripcion, int cantidad, double precio, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Productos that = (Productos) obj;
        return nombre.equals(that.nombre) &&
               descripcion.equals(that.descripcion) &&
               categoria.equals(that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, categoria);
    }

     */

    //Setters and Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
