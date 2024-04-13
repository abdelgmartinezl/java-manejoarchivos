import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class EjemploLecturaEscritura {
    private static void escribirArchivo(String archivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido);
            System.out.println("Se ha escrito el archivo " + archivo);
        } catch (IOException e) {
            System.err.println("Error de escritura a " + archivo);
            e.printStackTrace();
        }
    }

    private static void agregarArchivo(String archivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.append(contenido + "\n");
            System.out.println("Se ha escrito el archivo " + archivo);
        } catch (IOException e) {
            System.err.println("Error de escritura a " + archivo);
            e.printStackTrace();
        }
    }

    private static void lecturaArchivo(String archivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));
            System.out.println("Contenido del archivo " + archivo);
            for (String linea : lineas) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: ");
        }
    }

    public static void main(String[] args) {
        String archivo = "ejemplo.txt";
        //escribirArchivo(archivo, "Hola, prueba");
        agregarArchivo(archivo, "Hola, prueba");
        lecturaArchivo(archivo);
    }
}
