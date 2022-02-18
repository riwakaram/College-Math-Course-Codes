
/**
 *
 * @author riwakaram
 *
 * Integration using cubic interpolation algorithm
 *
 * Extra homework for extra credit
 */
import java.util.Scanner;

public class IntegrationUsingCubicInterpolation {

    public static double f(double x) {
        return (x * x * x - 4);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] x = new double[20];
        double[] fx = new double[20];
        double a, b, area, h, s = 0;

        // input
        System.out.println("Integration using cubic interpolation Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of panels n (n must be a multiple "
                + "of 3 and <= 20): ");
        int n = input.nextInt();
        System.out.println("Enter the lower boundary a: ");
        a = input.nextDouble();
        System.out.println("Enter the upper boundary b: ");
        b = input.nextDouble();

        // integration
        h = (b - a) / n;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0) {
                s += 2 * f(a + i * h);
            } else {
                s += 3 * f(a + i * h);
            }
        }

        area = (3 * h / 8) * (f(a) + f(b) + s);

        // output
        System.out.printf("\nThe integral of (x^3 - 4) from a = %f to b = %f "
                + "using cubic interpolation is: \n%12.8f\n", a, b, area);
    }

}
