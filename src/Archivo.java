import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
    public static void guardar(String ruta, String datos) {
        try (FileWriter writer = new FileWriter(ruta, true)) {
            writer.write(datos + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}