public class Usuarios {
    private String usuario;
    private String contrasena;

    Usuarios(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    protected boolean check_usuario(Usuarios user, String name, String pass){
        return user.getUsuario().equals(name) && user.getContrasena().equals(pass);
    }

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
