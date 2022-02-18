
/**
 *
 * @author riwakaram
 *
 * Solution of a system of linear equations using Gauss-Jordan Algorithm
 */
import java.util.Scanner;

public class GaussJordanMethod {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[][] a = new double[20][20];
        double alpha, betta;
        int i, j, k, n;

        // input
        System.out.println("Gauss Jordan Method Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the dimension n of the matrix: ");
        n = input.nextInt();
        System.out.println("Enter the matrix coefficients: ");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= n; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        // matrix
        System.out.printf("\nThe matrix coefficients are:\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= n; j++) {
                System.out.printf("%8.4f", a[i][j]);
            }
            System.out.println("");
        }

        // Gauss-Jordan
        for (i = 0; i < n; i++) {
            alpha = a[i][i];
            for (j = 0; j <= n; j++) {
                a[i][j] /= alpha;
            }
            for (k = 0; k < n; k++) {
                if (k != i) {
                    betta = a[k][i];
                    for (j = 0; j <= n; j++) {
                        a[k][j] -= (betta * a[i][j]);
                    }
                }
            }
        }

        // output
        System.out.printf("\nThe solution is:\n");
        for (i = 0; i < n; i++) {
            System.out.printf("x%d =%8.4f\n", i, a[i][n]);
        }

    }

}
