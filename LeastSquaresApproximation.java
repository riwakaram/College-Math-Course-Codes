
/**
 *
 * @author riwakaram
 *
 * Least Squares Approximation Algorithm
 */
import java.util.Scanner;

public class LeastSquaresApproximation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[][] a = new double[20][20];
        double alpha, betta;
        double[] x = new double[20];
        double[] y = new double[20];
        int i, j, k, l, n, m, r;

        // input
        System.out.println("Least Squares Approximation Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the degree of the polynomial: ");
        r = input.nextInt();
        System.out.println("Enter the number of points: ");
        n = input.nextInt();
        System.out.println("Enter the coordinates X & Y:");
        for (i = 0; i < n; i++) {
            x[i] = input.nextDouble();
            y[i] = input.nextDouble();
        }
        System.out.println("");

        // LS
        for (k = 0; k <= r; k++) {
            for (l = 0; l <= r; l++) {
                a[k][l] = 0;
                for (i = 0; i < n; i++) {
                    a[k][l] = a[k][l] + Math.pow(x[i], (k + l));
                }
                System.out.printf("%12.4f ", a[k][l]);
            }
            a[k][r + 1] = 0;
            for (i = 0; i < n; i++) {
                a[k][r + 1] = a[k][r + 1] + y[i] * Math.pow(x[i], k);
            }
            System.out.printf("%12.4f\n", a[k][r + 1]);
        }

        // Gauss-Jordan
        for (i = 0; i <= r; i++) {
            alpha = a[i][i];
            for (j = 0; j <= (r + 1); j++) {
                a[i][j] /= alpha;
            }
            for (k = 0; k <= r; k++) {
                if (k != i) {
                    betta = a[k][i];
                    for (j = 0; j <= (r + 1); j++) {
                        a[k][j] -= (betta * a[i][j]);
                    }
                }
            }
        }

        // output
        System.out.println("\nThe coefficients of the polynomial are:");
        for (i = 0; i <= r; i++) {
            System.out.printf("a%d = %8.4f\n", i, a[i][r + 1]);
        }
        System.out.println("\nThe polynomial is:");
        System.out.printf("%8.4f", a[0][r + 1]);
        for (i = 1; i <= r; i++) {
            System.out.printf(" + %8.4f * x^%d", a[i][r + 1], i);
        }
        System.out.println("");

    }

}
