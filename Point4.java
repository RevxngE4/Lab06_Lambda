import java.util.function.Function;

    public class Point4 {
        public static void main(String[] args) {
            double resultadoA = calcularIntegral(x -> 2 * Math.sin(x) + 1, Math.PI, -Math.PI);
            System.out.println("Resultado de la integral a): " + resultadoA);

            double resultadoB = calcularIntegral(x -> -(Math.pow(x / Math.PI, 2)) - 2 * x + 5 * Math.PI, Math.PI, -Math.PI);
            System.out.println("Resultado de la integral b): " + resultadoB);

            double resultadoC = calcularIntegral(x -> 0.5 * Math.pow(Math.cos(x), 2) + 1, Math.PI, -Math.PI);
            System.out.println("Resultado de la integral c): " + resultadoC);
        }

        public static double calcularIntegral(Function<Double, Double> funcion, double a, double b) {
            int numeroRectangulos = 1000;
            double dx = (b - a) / numeroRectangulos;
            double sumaAreas = 0;

            for (int i = 0; i < numeroRectangulos; i++) {
                double xi = a + i * dx;
                double area = funcion.apply(xi) * dx;
                sumaAreas += area;
            }

            return sumaAreas;
        }
    }


