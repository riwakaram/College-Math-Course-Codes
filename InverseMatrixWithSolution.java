
/**
 *
 * @author riwakaram
 *
 * Matrix Inverse Using Gauss-Jordan Algorithm
 */
import java.util.Scanner;

public class InverseMatrixWithSolution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[][] a = new double[20][20];
        double[] b = new double[20];
        double[] y = new double[20];
        double alpha, betta;
        int i, j, k, n;

        // input
        System.out.println("Matrix Inverse Using Gauss-Jordan Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the dimension n of the matrix: ");
        n = input.nextInt();
        System.out.println("Enter the matrix coefficients: ");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        // matrix
        System.out.printf("\nThe matrix coefficients are:\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.printf("%8.4f", a[i][j]);
            }
            System.out.println("");
        }

        // compl
        for (i = 0; i < n; i++) {
            for (j = n; j < 2 * n; j++) {
                if (i + n - j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = 0;
                }
            }
        }

        // Gauss-Jordan
        for (i = 0; i < n; i++) {
            alpha = a[i][i];
            for (j = 0; j <= 2 * n; j++) {
                a[i][j] /= alpha;
            }
            for (k = 0; k < n; k++) {
                if (k != i) {
                    betta = a[k][i];
                    for (j = 0; j <= 2 * n; j++) {
                        a[k][j] -= (betta * a[i][j]);
                    }
                }
            }
        }

        // inverse output
        System.out.printf("\nThe inverse of the matrix is:\n");
        for (i = 0; i < n; i++) {
            for (j = n; j < 2 * n; j++) {
                System.out.printf("%8.4f", a[i][j]);
            }
            System.out.println("");
        }

        // input b
        System.out.println("\nEnter the coefficients of the matrix B:");
        for (i = 0; i < n; i++) {
            b[i] = input.nextDouble();
        }
        System.out.println("\nThe matrix B is:");
        for (i = 0; i < n; i++) {
            System.out.printf("B%d = %8.4f\n", (i + 1), b[i]);
        }

        // solution and output
        System.out.println("\nThe solution of this system is:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                y[i] += (a[i][j + n] * b[j]);
            }
            System.out.printf("y%d = %8.4f\n", (i + 1), y[i]);
        }

    }

}
