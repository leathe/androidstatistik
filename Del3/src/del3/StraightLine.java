/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

/**
 *
 * @author Cracker0
 */
public class StraightLine {

    private double _m;
    private double _k;
    private double _y;
    public StraightLine(double[] a, double[] b) {
        double _nomM = ((getSumOfArray(b)*getPowerOfArraySum(a))-(getSumOfArray(a) * getArrayMulti(a, b)));
        double _denomM = a.length * getPowerOfArraySum(a) - Math.pow(getSumOfArray(a), 2);
        _m = _nomM / _denomM;
        
        double _nomK = (a.length*getArrayMulti(a, b)) - (getSumOfArray(a)*getSumOfArray(b));
        double _denomK = ( a.length*(getPowerOfArraySum(a)) - ( Math.pow(getSumOfArray((a)),2)));
        _k = _nomK / _denomK;
    }
    
    private double getSumOfArray(double[] Array) {
        double ArraySum = 0;
        for (int i = 0; i < Array.length; i++) {
            ArraySum += Array[i];
        }
        return ArraySum;
    }
    private double getArrayMulti(double[] Array, double[] Array2) {
        double ArraySum = 0;
        for (int i = 0; i < Array.length; i++) {
            ArraySum += Array[i]*Array2[i];
        }
        return ArraySum;
    }
    private double getPowerOfArraySum(double[] Array) {
        double ArrayPow = 0;
        for (int i = 0; i < Array.length; i++) {
            ArrayPow += Math.pow(Array[i], 2);
        }
        return ArrayPow;
    }
    
    public double getY(double x) {
        return _y = (_k * x)+ _m;
    }

    @Override
    public String toString() {
       return "y="+_k+"x "+_m;
    }
}
