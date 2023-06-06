import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final String host = "localhost";
        final int puerto = 1234;
        try {
            Socket socket = new Socket(host, puerto);
            //para leer los numeros
            Scanner leer = new Scanner(System.in);

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            System.out.println("Conectado!!\n\n");
            //loop para hacer que pare hasta que el usuario quiera
            boolean continuar = true;
            while (continuar) {
                System.out.print("Ingresa un número octal o (-1)> ");
                String input = leer.nextLine();

                try {
                    //leer dato ingresado
                    int numeroOctal = Integer.parseInt(input);
                    //enviar al servidor
                    salida.writeInt(numeroOctal);
                    // si es -1 se sale del bucle y se cierra
                    if (numeroOctal == -1) {
                        continuar = false;
                    } else {
                        // el numero que ingreso se convierte con el metodo del Servidor y lo recibe
                        int numeroDecimal = entrada.readInt();
                        System.out.println("El Octal " + numeroOctal + " es " + numeroDecimal + " en Decimal");
                    }
                } catch (Exception e) {
                    System.out.println("Error.\n"+ e);
                }
            }
            // se cierra el flujo
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
