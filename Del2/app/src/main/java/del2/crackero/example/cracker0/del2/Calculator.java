package del2.crackero.example.cracker0.del2;

/**
 * Created by Cracker0 on 20.3.2018.
 */


public class Calculator {


    double CriticalValue = 0.0;
    double Xsqr = 0.0;
    private double[] f;
    private int maxSize;

    public Calculator() {

    }

    public static double chiSquare(final int[][] counts) {

        int nRows = counts.length;
        int nCols = counts[0].length;

        // compute row, column and total sums
        double[] rowSum = new double[nRows];
        double[] colSum = new double[nCols];
        double total = 0.0d;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                rowSum[row] += counts[row][col];
                colSum[col] += counts[row][col];
                total += counts[row][col];
            }
        }

        // compute expected counts and chi-square
        double sumSq = 0.0d;
        double expected = 0.0d;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                expected = (rowSum[row] * colSum[col]) / total;
                sumSq += ((counts[row][col] - expected) *
                        (counts[row][col] - expected)) / expected;
            }
        }
        return sumSq;
    }

    public static double probTable(double chiSquare) {

        double p = 0;

        if (chiSquare >= 7.879 || chiSquare <= 7.879 && chiSquare > 6.635) {
            p = 0.005;
        }
        else if (chiSquare == 6.635 || chiSquare <= 6.635 && chiSquare > 5.024) {
            p = 0.01;
        }
        else if (chiSquare == 5.024 || chiSquare <= 5.024 && chiSquare > 3.841) {
            p = 0.025;
        }
        else if (chiSquare == 3.841 || chiSquare <= 3.841 && chiSquare > 2.706) {
            p = 0.05;
        }
        else if (chiSquare == 2.706 || chiSquare <= 2.706 && chiSquare > 0.016) {
            p = 0.10;
        }
        else if (chiSquare == 0.016 || chiSquare <= 0.015 && chiSquare > 0.004) {
            p = 0.90;
        }
        else if (chiSquare == 0.004 || chiSquare <= 0.004 && chiSquare > 0.001) {
            p = 0.95;
        }
        else if (chiSquare <= 0.001 && chiSquare > 0.0009) {
            p = 0.975;
        } else {
            p = 1;
        }
        return p;
    }



}
