
/**
 *
 * @author riwakaram
 *
 * Solution of a differential equation using Euler Method Algorithm
 */
import java.util.Scanner;

public class EulerMethod {

    public static double f(double y, double x) {
        return (y -2 * Math.sin(x));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double h;
        double[] x = new double[20];
        double[] y = new double[20];
        int i, n;

        // input
        System.out.println("Euler Method Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the initial value of x: ");
        x[0] = input.nextDouble();
        System.out.println("Enter the initial value of y: ");
        y[0] = input.nextDouble();
        System.out.println("Enter the number of steps n: ");
        n = input.nextInt();
        System.out.println("Enter the value of x to calculate its y: ");
        x[n] = input.nextDouble();

        // Euler method
        h = (x[n] - x[0]) / n;
        System.out.printf("\nx[0] = %4.4f y[0] = %4.4f", x[0], y[0]);
        for (i = 0; i < n; i++) {
            y[i + 1] = y[i] + h * f(y[i], x[i]);
            x[i + 1] = x[i] + h;
            System.out.printf("\nx[%d] = %4.4f y[%d] = %4.4f",
                    i + 1, x[i + 1], i + 1, y[i + 1]);
        }

        // output
        System.out.printf("\n\nx = %f y = %f\n", x[n], y[n]);

    }

}
