import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Point1 {
    public static void tabularFunciones(double a, double b, double dx, Function<Double, Double>[] funciones,
                                        Predicate<Double> predicado) {
        int totalValoresNegativos = 0;
        int totalValoresEnIntervalo = 0;

        for (Function<Double, Double> funcion : funciones) {
            int valoresNegativos = 0;
            int valoresEnIntervalo = 0;

            for (double x = a; x <= b; x += dx) {
                double resultado = funcion.apply(x);

                if (predicado.test(resultado)) {
                    valoresNegativos++;
                }

                if (resultado >= -1 && resultado <= 1) {
                    valoresEnIntervalo++;
                }

                System.out.println("f(" + x + ") = " + resultado);
            }

            System.out.println("Valores negativos de la función: " + valoresNegativos);
            System.out.println("Valores en el intervalo [-1, 1]: " + valoresEnIntervalo);
            System.out.println();

            totalValoresNegativos += valoresNegativos;
            totalValoresEnIntervalo += valoresEnIntervalo;
        }

        System.out.println("Total valores negativos de todas las funciones: " + totalValoresNegativos);
        System.out.println("Total valores en el intervalo [-1, 1] de todas las funciones: " + totalValoresEnIntervalo);
    }

    public static void main(String[] args) {
        Function<Double, Double>[] funciones = new Function[5];

        funciones[0] = Math::cos;

        funciones[1] = x -> 2 * Math.sqrt(Math.abs(x - 1)) + 1;

        funciones[2] = x -> -(Math.pow(x / Math.PI, 2)) - 2 * x + 5 * Math.PI;

        funciones[3] = x -> {
            double resultado = 0;
            for (int k = 1; k <= 100; k++) {
                resultado += ((x / (Math.PI * k)) - 1) * ((x / (Math.PI * k)) - 1);
            }
            return resultado;
        };

        funciones[4] = x -> {
            if (x < 0) {
                return (1.0 / 4) * Math.pow(Math.sin(x), 2) + 1;
            } else {
                return (1.0 / 2) * Math.cos(x) - 1;
            }
        };

        Predicate<Double> predicado = valor -> valor < 0;
        tabularFunciones(-2 * Math.PI, 2 * Math.PI, Math.PI / 6, funciones, predicado);
        int n = 10;
        System.out.println();
        System.out.println("Encontrar mínimo y máximo para puntos aleatorios:");
        encontrarMinMaxParaPuntosAleatorios(n, funciones);
    }
    public static void encontrarMinMaxParaPuntosAleatorios(int n, Function<Double, Double>[] funciones) {
        Random random = new Random();
        double[] puntosX = new double[n];
        double[] puntosY = new double[n];

        for (int i = 0; i < n; i++) {
            puntosX[i] = -10 + (random.nextDouble() * 20);
            puntosY[i] = -10 + (random.nextDouble() * 20);
        }

        for (Function<Double, Double> funcion : funciones) {
            double minimo = Double.MAX_VALUE;
            double maximo = Double.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                double x = puntosX[i];
                double y = puntosY[i];

                double resultado = funcion.apply(x);

                if (resultado < minimo) {
                    minimo = resultado;
                }

                if (resultado > maximo) {
                    maximo = resultado;
                }
            }

            System.out.println("Mínimo para la función: " + minimo);
            System.out.println("Máximo para la función: " + maximo);
            System.out.println();
        }
    }
}

