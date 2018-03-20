
package del3;

import java.util.Arrays;

public class Statistics{
    public static float getAverage(float[] values){
        float average = 0;
        for(int i = 0; i < values.length; i++){
            average += values[i];
        }
        average = average / values.length;
        return average;
    }
    public static float getStdev(float[] values) {
        float m = getAverage(values);
        float n = values.length;
        float diffSum = 0;
        for(int i = 0; i < n; i++) {
            diffSum += (values[i] - m)*(values[i] - m);
        }
        diffSum = diffSum/n;
        float stdev = (float) Math.sqrt(diffSum);
        return stdev;
    }
    public static float getMedian(float[] values) {
        Arrays.sort(values);
        if((values.length % 2) != 0){
            return values[values.length/2];
        }
        else{
            return (values[values.length/2] + values[values.length/2 - 1])/2;
        }
    }
    public static float getMin(float[] values){
        Arrays.sort(values);
        return values[0];
    }
    public static float getMax(float[] values){
        Arrays.sort(values);
        return values[values.length-1];
    }
    public static float getLq(float[] values){
        Arrays.sort(values);
        return Math.round(values.length*25/100);
    }
    public static float getUq(float[] values){
        Arrays.sort(values);
        return Math.round(values.length*75/100);
    }
    public static float getIqr(float[] values){
        Arrays.sort(values);
        return (Math.round(values.length*75/100)-Math.round(values.length*25/100));
    }
    public static float sum(float a, float b) {
        return a + b;
    }
    public static float div(float a, float b) {
        return a / b;
    }
    
    public static float getCorrelationCoefficient(float[] a, float[] b) {
        float k = 0;
        float x = 0;
        float y = 0;
        float xx = 0;
        float yy = 0;
        float xy = 0;
        float n = a.length;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                
                x += a[i];
                y += b[i];
                xx += (float)Math.pow(a[i], 2);
                yy += (float)Math.pow(b[i], 2);
                xy += (a[i]*b[i]);
                
            }

            float numerator = (xy - ((x * y) / n));
            float denominator1 = (xx - (float)(Math.pow(x, 2) / n));
            float denominator2 = (yy - (float)(Math.pow(y, 2) / n));
            k = numerator / ((float)Math.sqrt(denominator1) * (float)Math.sqrt(denominator2));

        } else {
            System.out.println("Array sizes did not match.");
        }
        return k;
    }
    public static StraightLine getLinearRegressionLine(float[] a, float[] b) {
        StraightLine sl = new StraightLine(a, b);
        return sl;
    }
    
}
