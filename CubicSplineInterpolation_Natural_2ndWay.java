
/**
 *
 * @author riwakaram
 *
 * Natural Cubic Spline Interpolation
 */
import java.util.Scanner;

public class CubicSplineInterpolation_Natural_2ndWay {

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
        double xx, yy;
        int m, n;

        // input
        System.out.println("Natural Cubic Spline Interpolation Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of points: ");
        m = input.nextInt();
        n = m - 1;

        System.out.println("Enter the value x you need to interpolate: ");
        xx = input.nextDouble();

        System.out.println("Enter the coordinates x and y: ");
        for (int i = 0; i <= n; i++) {
            x[i] = input.nextDouble();
            fx[i] = input.nextDouble();
        }

        // procedure
        for (int i = 0; i < n; i++) {
            h[i] = x[i + 1] - x[i];
        }

        for (int i = 1; i < n; i++) {
            alpha[i] = ((3 / h[i]) * (fx[i + 1] - fx[i]))
                    - ((3 / h[i - 1]) * (fx[i] - fx[i - 1]));
        }

        l[0] = 1;
        mu[0] = 0;
        z[0] = 0;

        for (int i = 1; i < n; i++) {
            l[i] = (2 * (x[i + 1] - x[i - 1])) - (h[i - 1] * mu[i - 1]);
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i] - (h[i - 1] * z[i - 1])) / l[i];
        }

        l[n] = 1;
        z[n] = 0;
        c[n] = 0;

        for (int j = (n - 1); j >= 0; j--) {
            c[j] = z[j] - (mu[j] * c[j + 1]);
            b[j] = ((fx[j + 1] - fx[j]) / h[j])
                    - (h[j] * (c[j + 1] + 2 * c[j]) / 3);
            d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
        }

        // output
        for (int i = 0; i <= n; i++) {
            System.out.printf("\n %8.4f %8.4f %8.4f %8.4f",
                    fx[i], b[i], c[i], d[i]);
        }
        System.out.println("");

        yy = 0;
        for (int i = 0; i < n; i++) {
            if (xx >= x[i] && xx < x[i + 1]) {
                yy = fx[i] + (b[i] * (xx - x[i]))
                        + (c[i] * Math.pow((xx - x[i]), 2))
                        + (d[i] * Math.pow((xx - x[i]), 3));
            }
        }

        System.out.printf("\nThe interpolation of x = %4.4f is y = %4.4f\n",
                xx, yy);

    }

}
