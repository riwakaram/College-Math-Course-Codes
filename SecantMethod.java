
/**
 *
 * @author riwakaram
 *
 * Secant Method Algorithm
 */
import java.util.Scanner;

public class SecantMethod {

    public static double f(double x) {
        return (Math.sin(x) - 0.5);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a, b, delta = 0, eps = 0.001;

        // input
        System.out.println("Secant Method Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Guess the first initial value a: ");
        a = input.nextDouble();

        System.out.println("Guess the second initial value b: ");
        b = input.nextDouble();

        // secant method
        System.out.printf("%8s%8s%8s%8s", "a", "b", "f(x)", "delta");
        delta = f(b) * ((b - a) / (f(b) - f(a)));
        System.out.printf("\n%8.4f%8.4f%8.4f%8.4f", a, b, f(a), delta);

        while ((Math.abs(delta)) > eps) {
            a = b;
            b -= delta;
            delta = f(b) * ((b - a) / (f(b) - f(a)));
            System.out.printf("\n%8.4f%8.4f%8.4f%8.4f", a, b, f(a), delta);
        }

        a = b;
        b -= delta;
        delta = f(b) * ((b - a) / (f(b) - f(a)));
        System.out.printf("\n%8.4f%8.4f%8.4f%8.4f", a, b, f(a), delta);

        // output
        b -= delta;
        System.out.printf("\n\nThe root is: %8.6f\n", b);

    }

}
