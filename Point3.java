import java.util.function.Function;

public class Point3 {
    public static void main(String[] args) {
        // a)
        double raizA = encontrarRaiz(x -> x * Math.sin(x) - 0.5, 0, Math.PI);
        System.out.println("Raíz de la ecuación x * sin(x) - 0.5 = 0: " + raizA);

        // b)
        double raizB = encontrarRaiz(x -> Math.log(x * x - 3 * x + 2), 0, 0.9);
        System.out.println("Raíz de la ecuación log(x^2 - 3x + 2) = 0: " + raizB);

        // c)
        double raizC = encontrarRaiz(x -> Math.log(x * x - 3 * x + 2), 2.1, 5);
        System.out.println("Raíz de la ecuación log(x^2 - 3x + 2) = 0: " + raizC);

        // d)
        double raizD = encontrarRaiz(x -> 0.5 * Math.tan(2.0 / 3.0 * (x + Math.PI / 4)) - 1, Math.PI, 2 * Math.PI);
        System.out.println("Raíz de la ecuación 0.5 * tan(2/3(x + pi/4)) - 1 = 0: " + raizD);
    }

    public static double encontrarRaiz(Function<Double, Double> funcion, double a, double b) {
        double en = 0.0001;
        double raiz = 0;

        if (funcion.apply(a) * funcion.apply(b) >= 0) {
            throw new IllegalArgumentException("La función no cumple con el requisito de tener signos opuestos en los extremos del intervalo.");
        }

        while ((b - a) >= en) {
            raiz = (a + b) / 2;
            double valorRaiz = funcion.apply(raiz);

            if (valorRaiz == 0.0) {
                break;
            } else if (valorRaiz * funcion.apply(a) < 0) {
                b = raiz;
            } else {
                a = raiz;
            }
        }

        return raiz;
    }
}
