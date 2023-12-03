package archivos;

import Game.User;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class ArchivoJuego {

    static User users[] = new User[7];
    static int posicion;
    private static final String ruta = "archivos/usuarios.txt";

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

    public static void cargarUsuarios() {
        crearArchivo(ruta);
        try {
            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            posicion = 0;
            while ((linea = bufferedReader.readLine()) != null) {
                String datos[] = linea.split(";");
                users[posicion] = new User(Integer.parseInt(datos[0]), datos[1], Long.parseLong(datos[2]), datos[3]);
                posicion++;
            }
            bufferedReader.close();
            ordenarArray(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ordenarArray(User users[]) {
        Arrays.sort(users, Comparator
                .<User, Long>comparing(user -> user != null ? user.getScore() : null, Comparator.nullsLast(Comparator.naturalOrder()))
                .reversed());

        // Actualizar los rankings
    }

    public static void arrayToArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, false))) {
            // Escribimos cada usuario en una línea del archivo
            int rank = 1;
            for (User user : users) {
                if (user != null) {
                    user.setRanking(rank++);
                    writer.write(user.getRanking() + ";" + user.getName() + ";" + user.getScore() + ";" + user.getGmTime());
                    writer.newLine();
                }
            }
            System.out.println("Array de usuarios escrito en el archivo exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        posicion = 0;
        users = new User[7];
    }

    public static boolean isNewRecord(User user) {
        boolean record;
        cargarUsuarios();
        if (posicion > 7) {
            User[] tempArray = Arrays.copyOf(users, users.length + 1);
            tempArray[tempArray.length - 1] = user;
            ordenarArray(tempArray);
            if (user != tempArray[tempArray.length - 1]) {
                record = true;
                System.arraycopy(tempArray, 0, users, 0, users.length);
            } else {
                record = false;
            }
        } else {
            users[posicion] = user;
            ordenarArray(users);
            record = true;
        }
        return record;
    }

    public static void escribirUsuario(User user) {
        for(User u: users){
            if(u != null && u == user){
                u.setName(user.getName());
                break;
            }
        }
        arrayToArchivo();
    }
}
