
/**
 *
 * @author riwakaram
 *
 * Natural Cubic Spline Interpolation
 */
import java.util.Scanner;

public class CubicSplineInterpolation_Clamped_2ndWay {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] x = new double[30];
        double[] fx = new double[30];
        double[] h = new double[30];
        double[] alpha = new double[30];
        double[] l = new double[30];
        double[] mu = new double[30];
        double[] z = new double[30];
        double[] c = new double[30];
        double[] b = new double[30];
        double[] d = new double[30];
        double xx, yy, FP0, FPN;
        int m, n;

        // input
        System.out.println("Clamped Cubic Spline Interpolation Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of points: ");
        n = input.nextInt();

        System.out.println("Enter the value x you need to interpolate: ");
        xx = input.nextDouble();

        System.out.println("Enter the coordinates x and y: ");
        for (int i = 0; i < n; i++) {
            x[i] = input.nextDouble();
            fx[i] = input.nextDouble();
        }

        System.out.println("Enter f'(x0):");
        FP0 = input.nextDouble();
        System.out.println("Enter f'(xn):");
        FPN = input.nextDouble();

        // procedure
        for (int i = 0; i < n; i++) {
            h[i] = x[i + 1] - x[i];
        }

        alpha[0] = (3 * (fx[1] - fx[0])) - (3 * FP0);
        alpha[n] = (3 * FPN) - (3 * (fx[n] - fx[n - 1]) / h[n - 1]);

        for (int i = 1; i < n; i++) {
            alpha[i] = ((3 / h[i]) * (fx[i + 1] - fx[i]))
                    - ((3 / h[i - 1]) * (fx[i] - fx[i - 1]));
        }

        l[0] = 2 * h[0];
        mu[0] = 0.5;
        z[0] = alpha[0] / l[0];

        for (int i = 1; i < n; i++) {
            l[i] = (2 * (x[i + 1] - x[i - 1])) - (h[i - 1] * mu[i - 1]);
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i] - (h[i - 1] * z[i - 1])) / l[i];
        }

        l[n] = h[n - 1] * (2 - mu[n - 1]);
        z[n] = (alpha[n] - (h[n - 1] * z[n - 1])) / l[n];
        c[n] = z[n];

        for (int j = (n - 1); j >= 0; j--) {
            c[j] = z[j] - (mu[j] * c[j + 1]);
            b[j] = ((fx[j + 1] - fx[j]) / h[j])
                    - (h[j] * (c[j + 1] + 2 * c[j]) / 3);
            d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
        }

        // output
        for (int i = 0; i <= n; i++) {
            System.out.printf("\n%8.4f%8.4f%8.4f%8.4f\n",
                    fx[i], b[i], c[i], d[i]);
        }

        yy = 0;
        for (int i = 0; i < n; i++) {
            if (xx >= x[i] && xx < x[i + 1]) {
                yy = fx[i] + (b[i] * (xx - x[i]))
                        + (c[i] * Math.pow((xx - x[i]), 2))
                        + (d[i] * Math.pow((xx - x[i]), 3));
            }
        }

        System.out.printf("\nThe interpolation of x = %8.6f is y = %8.6f\n",
                xx, yy);

    }

}
