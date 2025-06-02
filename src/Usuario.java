public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String contrasena;

    public Usuario(String id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public boolean verificarLogin(String inputNombre, String inputContrasena) {
        return this.nombre.equals(inputNombre) && this.contrasena.equals(inputContrasena);
    }
}