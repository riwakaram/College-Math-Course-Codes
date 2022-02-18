
/**
 *
 * @author riwakaram
 *
 * Cubic Spline Interpolation Algorithm
 */
import java.util.Scanner;

public class CubicSplineInterpolationWithGaussJordan {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[][] a = new double[20][20];
        double[] x = new double[20];
        double[] fx = new double[20];
        double alpha, betta, gamma, xx, yy;
        int m, n, k, l;

        // input
        System.out.println("Cubic Spline Interpolation Algorithm");
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

        // build matrix
        // initialise the matrix to 0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = 0;
            }
        }

        // main diag alpha
        for (int i = 1; i < n; i++) {
            a[i][i] = 2 * (x[i + 1] - x[i - 1]) / (x[i + 1] - x[i]);
        }

        // upper diag
        for (int i = 1; i < n; i++) {
            a[i][i + 1] = 1;
        }

        // lower diag beta
        for (int i = 2; i < n; i++) {
            a[i][i - 1] = (x[i] - x[i - 1]) / (x[i + 1] - x[i]);
        }

        // gamma
        for (int i = 1; i < n; i++) {
            a[i][n] = 6 * (((fx[i + 1] - fx[i])
                    / Math.pow((x[i + 1] - x[i]), 2))
                    - ((fx[i] - fx[i - 1])
                    / ((x[i + 1] - x[i]) * (x[i] - x[i - 1]))));
        }

        // output of the matrix
        System.out.println("\nThe matrix is: ");
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%10.4f ", a[i][j]);
            }
            System.out.println("");
        }

        // Gauss-Jordan
        for (int i = 1; i < n; i++) {
            alpha = a[i][i];
            for (int j = 1; j <= n; j++) {
                a[i][j] /= alpha;
            }
            for (k = 1; k < n; k++) {
                if (k != i) {
                    betta = a[k][i];
                    for (int j = 1; j <= n; j++) {
                        a[k][j] -= (betta * a[i][j]);
                    }
                }
            }
        }

        // output
        a[0][n] = a[n][n] = 0;
        System.out.printf("\nThe solution of the matrix is:\n");
        System.out.printf("g''(x%d) =%8.4f\n", 0, a[0][n]);
        for (int i = 1; i < n; i++) {
            System.out.printf("g''(x%d) =%8.4f\n", i, a[i][n]);
        }
        System.out.printf("g''(x%d) =%8.4f\n", n, a[n][n]);

        // Interpolation
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (xx >= x[i] && xx <= x[i + 1]) {
                temp = i;
                break;
            }
        }

        yy = ((a[temp][n] / 6) * ((Math.pow((x[temp + 1] - xx), 3)
                / (x[temp + 1] - x[temp])) - ((x[temp + 1] - x[temp])
                * (x[temp + 1] - xx))))
                + ((a[temp + 1][n] / 6) * ((Math.pow((xx - x[temp]), 3)
                / (x[temp + 1] - x[temp])) - ((x[temp + 1] - x[temp])
                * (xx - x[temp]))))
                + (fx[temp] * ((x[temp + 1] - xx) / (x[temp + 1] - x[temp])))
                + (fx[temp + 1] * ((xx - x[temp]) / (x[temp + 1] - x[temp])));

        System.out.printf("\nThe solution by cubic spline interpolation of x = %8.4f is y = %8.4f\n", xx, yy);
    }

}
