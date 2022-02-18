
/**
 *
 * @author riwakaram
 *
 * Newton Method Algorithm
 */
import java.util.Scanner;

public class NewtonMethod {

    public static double f(double x) {
        return (Math.sin(x) - 0.5);
    }

    public static double fp(double x) {
        return (Math.cos(x));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a, delta = 0, eps = 0.01;

        // input
        System.out.println("Newton Method Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Guess an initial value a: ");
        a = input.nextDouble();

        // Newton Method
        System.out.printf("\n%8s%8s%8s%8s", "a", "f(a)", "fp(a)", "delta");

        delta = f(a) / fp(a);
        System.out.printf("\n%8.4f%8.4f%8.4f%8.4f", a, f(a), fp(a), delta);

        while ((Math.abs(delta)) > eps) {
            a -= delta;
            delta = f(a) / fp(a);
            System.out.printf("\n%8.4f%8.4f%8.4f%8.4f", a, f(a), fp(a), delta);
        }

        a -= delta;
        delta = f(a) / fp(a);

        System.out.printf("\n%8.4f%8.4f%8.4f%8.4f", a, f(a), fp(a), delta);
        System.out.printf("\n\nsin(%5.4f) = %12.10f", a, (f(a) + 0.5));
        System.out.printf("\nsin(%5.4f) - 0.5 = %12.10f", a, f(a));

        // output
        a -= delta;
        System.out.printf("\n\nThe root is: %.4f\n", a);

    }

}
