
/**
 *
 * @author riwakaram
 *
 * Solution of a differential equation using Runge Kutta Method Algorithm
 */
import java.util.Scanner;

public class RungeKuttaMethod {

    public static double f(double x, double y) {
        return (y - 2 * Math.sin(x));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double h, k1, k2, k3, k4;
        double[] x = new double[20];
        double[] y = new double[20];
        int i, n;

        // input
        System.out.println("Runge Kutta Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the initial value of x: ");
        x[0] = input.nextDouble();
        System.out.println("Enter the initial value of y: ");
        y[0] = input.nextDouble();
        System.out.println("Enter the number of steps n: ");
        n = input.nextInt();
        System.out.println("Enter the value of x to calculate its y: ");
        x[n] = input.nextDouble();

        // Runge Kutta method
        h = (x[n] - x[0]) / n;
        System.out.printf("\n%-6s%-9s%-9s%-9s%-9s%-9s%-9s",
                "i", "x[i]", "y[i]", "k1", "k2", "k3", "k4");
        System.out.printf("\n%-3s %8.4f %8.4f", " ", x[0], y[0]);
        for (i = 0; i < n; i++) {
            k1 = h * f(x[i], y[i]);
            k2 = h * f(x[i] + h / 2, y[i] + k1 / 2);
            k3 = h * f(x[i] + h / 2, y[i] + k2 / 2);
            k4 = h * f(x[i] + h, y[i] + k3);

            System.out.printf("\n%-3d %8.4f %8.4f %8.4f %8.4f %8.4f %8.4f",
                    i, x[i], y[i], k1, k2, k3, k4);

            y[i + 1] = y[i] + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x[i + 1] = x[i] + h;
        }

        // output
        System.out.printf("\n\nx = %f y = %f\n", x[n], y[n]);

    }

}
