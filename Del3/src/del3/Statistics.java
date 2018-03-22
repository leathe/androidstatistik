
package del3;

import java.util.Arrays;

public class Statistics{
    public static double getAverage(double[] values){
        float average = 0;
        for(int i = 0; i < values.length; i++){
            average += values[i];
        }
        average = average / values.length;
        return average;
    }
//    public static float getStdev(float[] values) {
//        float m = getAverage(values);
//        float n = values.length;
//        float diffSum = 0;
//        for(int i = 0; i < n; i++) {
//            diffSum += (values[i] - m)*(values[i] - m);
//        }
//        diffSum = diffSum/n;
//        float stdev = (float) Math.sqrt(diffSum);
//        return stdev;
//    }
//    public static float getMedian(float[] values) {
//        Arrays.sort(values);
//        if((values.length % 2) != 0){
//            return values[values.length/2];
//        }
//        else{
//            return (values[values.length/2] + values[values.length/2 - 1])/2;
//        }
//    }
//    public static float getMin(float[] values){
//        Arrays.sort(values);
//        return values[0];
//    }
//    public static float getMax(float[] values){
//        Arrays.sort(values);
//        return values[values.length-1];
//    }
//    public static float getLq(float[] values){
//        Arrays.sort(values);
//        return Math.round(values.length*25/100);
//    }
//    public static float getUq(float[] values){
//        Arrays.sort(values);
//        return Math.round(values.length*75/100);
//    }
//    public static float getIqr(float[] values){
//        Arrays.sort(values);
//        return (Math.round(values.length*75/100)-Math.round(values.length*25/100));
//    }
//    public static float sum(float a, float b) {
//        return a + b;
//    }
//    public static float div(float a, float b) {
//        return a / b;
//    }

    public static double getCorrelationCoefficient(double[] a, double[] b) {
        double r = 0;
        double x = 0;
        double y = 0;
        double xx = 0;
        double yy = 0;
        double xy = 0;
        double n = a.length;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                x += a[i];
                y += b[i];
                xx += Math.pow(a[i], 2);
                yy += Math.pow(b[i], 2);
                xy += (a[i]*b[i]);
            }
            double numerator = (xy - ((x * y) / n));
            double denominator1 = (xx - (Math.pow(x, 2) / n));
            double denominator2 = (yy - (Math.pow(y, 2) / n));
            r = numerator / (Math.sqrt(denominator1) * Math.sqrt(denominator2));
        } else {
            System.out.println("Array sizes did not match.");
        }
        return r;
    }
    public static StraightLine getLinearRegressionLine(double[] a, double[] b) {
        StraightLine sl = new StraightLine(a, b);
        sl.getY(getCorrelationCoefficient(a, b));
        return sl;
    }
}
