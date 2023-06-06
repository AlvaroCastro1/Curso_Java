import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int puerto = 1234;
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("El servidor esta esperando conexiones...");

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado " + cliente.getInetAddress().getHostAddress());
                // se crea un hilo para atender al cliente
                Thread Atender_Cliente = new Thread(new Atender_Cliente(cliente));
                Atender_Cliente.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// se crea una clase para hacer un hilo y atender a un cliente
class Atender_Cliente implements Runnable {
    // se guarda el socket del cliente
    private Socket cliente;

    public Atender_Cliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

            boolean continuar = true;
            while (continuar) {
                int numeroOctal = entrada.readInt();

                if (numeroOctal == -1) {
                    continuar = false;
                    System.out.println("cliente desconectado");
                } else {
                    int numeroDecimal = convertirOctalADecimal(numeroOctal);
                    salida.writeInt(numeroDecimal);
                    System.out.println("se envio respuesta al cliente "+ cliente.getInetAddress()+"\n\t octal="+numeroOctal+"\tDecimal="+numeroDecimal+"\n");
                }
            }

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo para poder transformar un numero a decimal
    private int convertirOctalADecimal(int octal) {
        int decimal = 0;
        int base = 1;

        while (octal != 0) {
            int digito = octal % 10;
            decimal += digito * base;
            octal /= 10;
            base *= 8;
        }

        return decimal;
    }
}
