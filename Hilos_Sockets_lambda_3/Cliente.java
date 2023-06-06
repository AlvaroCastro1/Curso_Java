import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) {
        final String host = "localhost";
        final int puerto = 1234;

        try {
            Socket socket = new Socket(host,puerto);
            System.out.println("Conectado al servidor: " + socket);

            // Obtener el flujo de entrada y salida del socket
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Solicitar al usuario una frase
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese una frase: ");
            String frase = reader.readLine();

            // Enviar la frase al servidor
            outputStream.writeObject(frase);
            outputStream.flush();

            // Recibir las impresiones del servidor
            String impresion1 = (String) inputStream.readObject();
            String impresion2 = (String) inputStream.readObject();
            String impresion3 = (String) inputStream.readObject();

            // Mostrar las impresiones
            System.out.println("Impresión 1: " + impresion1);
            System.out.println("Impresión 2: " + impresion2);
            System.out.println("Impresión 3: " + impresion3);

            // Cerrar la conexión
            socket.close();
            System.out.println("Desconectado del servidor: " + socket);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
