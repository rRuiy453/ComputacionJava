public class Cita {
    private String id;
    private String fechaHora;
    private String motivo;
    private String doctorId;
    private String pacienteId;

    public Cita(String id, String fechaHora, String motivo, String doctorId, String pacienteId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctorId = doctorId;
        this.pacienteId = pacienteId;
    }

    @Override
    public String toString() {
        return id + "," + fechaHora + "," + motivo + "," + doctorId + "," + pacienteId;
    }
}
