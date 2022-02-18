
/**
 *
 * @author riwakaram
 *
 * Divided Differences Newton Interpolation (Backward) Algorithm
 */
import java.util.Scanner;

public class DividedDifferencesNewtonInterpolation_Backward {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] x = new double[20];
        double[] fx = new double[20];
        double[][] F = new double[20][20];
        double xx, yy, p;

        // input
        System.out.println("Divided Differences Newton Interpolation "
                + "(Backward) Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of points n: ");
        int n = input.nextInt();

        System.out.println("Enter the value x you need to interpolate: ");
        xx = input.nextDouble();

        System.out.println("Enter the coordinates x and y: ");
        for (int i = 0; i < n; i++) {
            x[i] = input.nextDouble();
            fx[i] = input.nextDouble();
            F[i][0] = fx[i];
        }

        // procedure and output
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                F[i][j] = (F[i][j - 1] - F[i - 1][j - 1]) / (x[i] - x[i - j]);
            }
        }

        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%12.8f ", F[i][j]);
            }
            System.out.println("");
        }

        System.out.println("\nThe coefficients are:");
        for (int j = 0; j < n; j++) {
            System.out.printf("%12.8f", F[n - 1][j]);
        }

        yy = F[n - 1][0];
        p = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                p *= (xx - x[n - j]);
            }
            yy += (F[n - 1][i] * p);
            p = 1;
        }

        System.out.printf("\n\nThe solution by newton interpolation (backward "
                + "divided differences) of x = %12.8f is: \ny = % 12.8f\n",
                xx, yy);

    }

}
