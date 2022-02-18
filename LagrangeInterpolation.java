
/**
 *
 * @author riwakaram
 *
 * Lagrange Interpolation Algorithm
 */
import java.util.Scanner;

public class LagrangeInterpolation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] x = new double[20];
        double[] fx = new double[20];
        double[] p = new double[20];
        double xx, yy;

        // input
        System.out.println("Lagrange Interpolation Algorithm");
        System.out.println("Riwa Karam, UoB\n");

        System.out.println("Enter the number of points n: ");
        int n = input.nextInt();

        System.out.println("Enter the value x you need to interpolate: ");
        xx = input.nextDouble();

        System.out.println("Enter the coordinates x and y: ");
        for (int i = 0; i < n; i++) {
            x[i] = input.nextDouble();
            fx[i] = input.nextDouble();
        }

        // Lagrange
        yy = 0;
        for (int j = 0; j < n; j++) {
            p[j] = 1;
            for (int i = 0; i < n; i++) {
                if (i != j) {
                    p[j] *= ((xx - x[i]) / (x[j] - x[i]));
                }
            }
            yy += ((fx[j]) * (p[j]));
        }

        // output
        for (int i = 0; i < n; i++) {
            System.out.printf("\nP%d = %.4f", i, p[i]);
        }

        System.out.printf("\n\nThe solution by Lagrange interpolation is:"
                + "\nx = %f ; y = %.4f\n", xx, yy);
    }

}
