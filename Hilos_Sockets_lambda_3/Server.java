import java.io.*;
import java.net.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Server {

	public static void main(String[] args) {
        final int puerto = 1234;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(puerto);
			System.out.println("El servidor esta esperando conexiones...");

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Cliente conectado: " + socket.getInetAddress());

				// Crear un hilo para manejar la conexión con el cliente
				// usando funciones lambda
				Thread hiloCliente = new Thread(() -> {
					try {
						// flujo de entrada y salida del socket
						ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

						// Leer la frase enviada por el cliente
						String frase = (String) inputStream.readObject();
						System.out.println("Frase recibida: \'" + frase + "\' de " + socket.getInetAddress());

						// Realizar las impresiones utilizando funciones lambda
						String impresion1 = reemplazarNumeros.apply(frase);
						String impresion2 = letrasAntesDeQ.apply(frase);
						String impresion3 = Sin_Numero_Letras_signo.apply(frase);

						// Enviar las impresiones al cliente
						outputStream.writeObject(impresion1);
						outputStream.writeObject(impresion2);
						outputStream.writeObject(impresion3);
						// asegurar y mandar todos los datos
						outputStream.flush();

						// Cerrar la flujo
						socket.close();
					} catch (IOException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				});

				hiloCliente.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Function<T, R>: Representa una función que recibe un argumento de tipo T
	// y devuelve un resultado de tipo R.
	public static Function<String, String> reemplazarNumeros = frase -> {
		// devuelve un String
		return frase.chars()
				// convierte el string a valores enteros usando chars()
				// se verifica si el caracter correspondiente es un dígito
				// cuando sea true se reemplaza
				.mapToObj(c -> Character.isDigit((char) c) ? "#" : String.valueOf((char) c))
				// juntar todos los strings en un solo string
				.collect(Collectors.joining());
	};

	public static Function<String, String> letrasAntesDeQ = frase -> {
		// devuelve un String
		return frase.chars()
				// "filtra" si el caracter correspondiente sea jerarquicamente menor a Q/q
				.filter(c -> Character.isLetter(c) && Character.toUpperCase(c) < 'Q')
				// mapea c/valor a una char
				.mapToObj(c -> String.valueOf((char) c))
				// juntar todos los strings en un solo string
				.collect(Collectors.joining());
	};

	public static Function<String, String> Sin_Numero_Letras_signo = frase -> {
		// devuelve un String
		return frase.chars()
				//quita las letras y digitos ademas del signo 
				.filter(c -> !Character.isLetterOrDigit(c) && c != '%')
				// mapea c/valor a una char
				.mapToObj(c -> String.valueOf((char) c))
				// juntar todos los strings en un solo string
				.collect(Collectors.joining());
	};

}
