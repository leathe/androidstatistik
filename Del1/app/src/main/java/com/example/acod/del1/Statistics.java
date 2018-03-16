package com.example.acod.del1;

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
}
