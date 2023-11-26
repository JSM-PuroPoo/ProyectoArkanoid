package archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {

    public static void crearArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.createNewFile()) {
                System.out.println("El archivo se ha creado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
    }

    
    
    
    
    
    
    
    
    
    public static void ActualizarArchivo(String ruta, String contenido) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, true)); // El segundo parámetro (true) permite continuar escribiendo en el archivo
            escritor.write(contenido);
            escritor.close();

        } catch (IOException e) {
            System.err.println("Ocurrió un error al continuar escribiendo en el archivo: " + e.getMessage());
        }
    }

    public static void sobreescribirArchivo(String nombreArchivo, String[] contenido) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, false));
            for (String linea : contenido) {
                escritor.write(linea);
            }
            escritor.close();

        } catch (IOException e) {
            System.err.println("Ocurrió un error al sobrescribir el archivo: " + e.getMessage());
        }
    }
}
