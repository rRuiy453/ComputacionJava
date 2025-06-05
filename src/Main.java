import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador("1", "admin", "1234");

        // Asegurar existencia de archivos
        verificarYCrearArchivo("db/doctores.txt");
        verificarYCrearArchivo("db/pacientes.txt");
        verificarYCrearArchivo("db/citas.txt");

        System.out.println("=== Login ===");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (admin.verificarLogin(usuario, pass)) {
            System.out.println("Login exitoso.");
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Alta doctor");
                System.out.println("2. Alta paciente");
                System.out.println("3. Crear cita");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("=== Alta de doctor ===");
                        System.out.print("ID: ");
                        String idDoc = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombreDoc = sc.nextLine();
                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();
                        Doctor doctor = new Doctor(idDoc, nombreDoc, especialidad);
                        Archivo.guardar("db/doctores.txt", doctor.toString());
                        System.out.println("Doctor guardado.");
                        break;

                    case 2:
                        System.out.println("=== Alta de paciente ===");
                        System.out.print("ID: ");
                        String idPac = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombrePac = sc.nextLine();
                        System.out.print("Contraseña: ");
                        String contraPac = sc.nextLine();
                        Paciente paciente = new Paciente(idPac, nombrePac, contraPac);
                        Archivo.guardar("db/pacientes.txt", idPac + "," + nombrePac + "," + contraPac);
                        System.out.println("Paciente guardado.");
                        break;

                    case 3:
                        System.out.println("=== Crear cita ===");
                        System.out.print("ID de cita: ");
                        String id = sc.nextLine();
                        System.out.print("Fecha y hora: ");
                        String fechaHora = sc.nextLine();
                        System.out.print("Motivo: ");
                        String motivo = sc.nextLine();
                        System.out.print("ID del doctor: ");
                        String doctorId = sc.nextLine();
                        System.out.print("ID del paciente: ");
                        String pacienteId = sc.nextLine();
                        Cita cita = new Cita(id, fechaHora, motivo, doctorId, pacienteId);
                        Archivo.guardar("db/citas.txt", cita.toString());
                        System.out.println("Cita guardada.");
                        break;

                    case 4:
                        continuar = false;
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

                if (continuar) {
                    System.out.print("\n¿Deseas realizar otra acción? (s/n): ");
                    String respuesta = sc.nextLine();
                    if (!respuesta.equalsIgnoreCase("s")) {
                        continuar = false;
                        System.out.println("Gracias por usar el sistema.");
                    }
                }
            }
        } else {
            System.out.println("Acceso denegado.");
        }

        sc.close();
    }

    public static void verificarYCrearArchivo(String ruta) {
        try {
            File archivo = new File(ruta);
            archivo.getParentFile().mkdirs(); // crear carpeta db si no existe
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + ruta);
            }
        } catch (IOException e) {
            System.out.println("Error creando archivo: " + e.getMessage());
        }
    }
}
