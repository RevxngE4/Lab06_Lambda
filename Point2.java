import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Point2 {
    public static void analizarLineas(List<String> lineas) {
        // a)
        Predicate<String> predicadoCincoLetras = palabra -> palabra.length() == 5;
        int numeroPalabrasCincoLetras = contarPalabras(lineas, predicadoCincoLetras);
        System.out.println("Número de palabras de cinco letras: " + numeroPalabrasCincoLetras);

        // b)
        Predicate<String> predicadoPalindromo = Point2::esPalindromo;
        int numeroPalindromos = contarPalabras(lineas, predicadoPalindromo);
        System.out.println("Número de palíndromos: " + numeroPalindromos);

        // c)
        Predicate<String> predicadoLetraW = palabra -> palabra.contains("W");
        List<String> palabrasConLetraW = obtenerPalabras(lineas, predicadoLetraW);
        System.out.println("Palabras con la letra 'W': " + palabrasConLetraW);
    }

    public static int contarPalabras(List<String> lineas, Predicate<String> predicado) {
        int contador = 0;
        for (String linea : lineas) {
            String[] palabras = linea.split("\\s+");
            for (String palabra : palabras) {
                if (predicado.test(palabra)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static List<String> obtenerPalabras(List<String> lineas, Predicate<String> predicado) {
        List<String> palabrasEncontradas = new ArrayList<>();
        for (String linea : lineas) {
            String[] palabras = linea.split("\\s+");
            for (String palabra : palabras) {
                if (predicado.test(palabra)) {
                    palabrasEncontradas.add(palabra);
                }
            }
        }
        return palabrasEncontradas;
    }

    public static boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase();
        int i = 0;
        int j = palabra.length() - 1;
        while (i < j) {
            if (palabra.charAt(i) != palabra.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> lineas = Arrays.asList(
                "Hola Mundo",
                "Anita lava la tina",
                "OpenAI es increíble",
                "No x in Nixon",
                "Wikipedia es una fuente de información");

        analizarLineas(lineas);
    }
}

