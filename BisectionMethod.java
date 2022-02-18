
/**
 *
 * @author riwakaram
 *
 * Bisection Method Algorithm
 */
import java.util.Scanner;

public class BisectionMethod {

    public static double f(double x) {
        return (Math.sin(x) - 0.5);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double root, a, b, m, eps = 0.01;

        // input
        System.out.println("Bisection Method Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the lower boundary a: ");
        a = input.nextDouble();

        System.out.println("Enter the upper boundary b: ");
        b = input.nextDouble();

        // bissection
        System.out.printf("%9s %9s %9s %9s %9s %9s %9s\n", "a", "b", "m",
                "f(m)", "f(b)", "f(m)*f(b)", "b - a");
        while ((Math.abs(b - a)) > eps) {
            m = (a + b) / 2;

            System.out.printf("%9.4f %9.4f %9.4f %9.4f %9.4f %9.4f %9.4f\n", a,
                    b, m, f(m), f(b), (f(m) * f(b)), (b - a));

            if (f(m) * f(b) < 0) {
                a = m;
            } else {
                b = m;
            }
        }

        // output
        root = (a + b) / 2;
        System.out.printf("%9.4f %9.4f %9.4f %9.4f %9.4f %9.4f %9.4f\n", a,
                b, root, f(root), f(b), (f(root) * f(b)), (b - a));
        System.out.printf("\nThe root is: %.4f\n", root);

    }

}
