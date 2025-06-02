public class Doctor {
    private String id;
    private String nombre;
    private String especialidad;

    public Doctor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + especialidad;
    }
}