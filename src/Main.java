import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador("1", "admin", "1234");

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
                System.out.println("2. Crear cita");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if (opcion == 1) {
                    System.out.println("=== Alta de doctor ===");
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();

                    Doctor doctor = new Doctor(id, nombre, especialidad);
                    Archivo.guardar("doctores.txt", doctor.toString());
                    System.out.println("Doctor guardado.");
                } else if (opcion == 2) {
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
                    Archivo.guardar("citas.txt", cita.toString());
                    System.out.println("Cita guardada.");
                } else if (opcion == 3) {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                } else {
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
}
