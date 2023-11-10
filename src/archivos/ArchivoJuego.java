package archivos;

import Game.User;

public class ArchivoJuego {

    public static void escribirUsuario(User user) {
        String line;
        line = user.getRanking() + ";" + user.getName() + ";" + user.getScore() + ";" + user.getGmTime().toString() + "\n";
        Archivos.ActualizarArchivo("archivos/usuarios.txt", line);
    }

    public static void escribirUsuarios(User users[]) {
    }

    public static void buscarUsuario(User user) {

    }
}
