import java.util.function.Function;
import java.util.stream.Collectors;

public class temp {

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

    public static void main(String[] args) {
        String impresion1 = reemplazarNumeros.apply("Hola123 que4");
        String impresion2 = letrasAntesDeQ.apply("hola que haces ahora qeqe");
        String impresion3 = Sin_Numero_Letras_signo.apply("H0l@ M1 Mundo! #OpenAI %");
        System.out.println(impresion1);
        System.out.println(impresion2);
        System.out.println(impresion3);
    }
}