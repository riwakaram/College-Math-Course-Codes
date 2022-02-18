
/**
 *
 * @author riwakaram
 *
 * Trapezoidal Integration Algorithm
 */
import java.util.Scanner;

public class TrapezoidalIntegration {

    public static double f(double x) {
        return (x * x - 4);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a, b, area, h, s = 0;

        // input
        System.out.println("Trapezoidal Integration Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of panels n (n <= 20): ");
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

        // output
        System.out.printf("\nThe integral of (x^2 - 4) from a = %f to b = %f "
                + "is:\n%f\n", a, b, area);

    }

}
