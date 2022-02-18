
/**
 *
 * @author riwakaram
 *
 * Trapezoidal and Simpson Integrations Algorithm
 */
import java.util.Scanner;

public class TrapezoidalAndSimpsonIntegrations {

    public static double f(double x) {
        return (x * x - 4);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] x = new double[20];
        double[] fx = new double[20];
        double a, b, area, h, s = 0, s1 = 0, s2 = 0;

        // input
        System.out.println("Trapezoidal and Simspon Integrations Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of panels n (n must be even "
                + "and <= 20): ");
        int n = input.nextInt();
        System.out.println("Enter the lower boundary a: ");
        a = input.nextDouble();
        System.out.println("Enter the upper boundary b: ");
        b = input.nextDouble();

        // trapezoidal
        h = (b - a) / n;
        for (int i = 1; i < n; i++) {
            s += f(a + i * h);
        }
        area = h / 2 * (f(a) + f(b) + 2 * s);

        // output of trapezoidal
        System.out.printf("\nThe integral of (x^2 - 4) from a = %f to b = %f "
                + "using the trapezoidal method is: \n%f\n", a, b, area);

        // Simspon
        h = (b - a) / n;
        for (int i = 1; i < n; i += 2) {
            s1 += f(a + i * h);
        }
        for (int i = 2; i < (n - 1); i += 2) {
            s2 += f(a + i * h);
        }
        area = h / 3 * (f(a) + f(b) + 4 * s1 + 2 * s2);

        // output of Simpson
        System.out.printf("\nThe integral of (x^2 - 4) from a = %f to b = %f "
                + "using the Simpson method is: \n%f\n", a, b, area);

    }

}
