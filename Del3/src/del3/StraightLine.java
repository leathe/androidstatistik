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

    private float _x;
    private float _m;
    private float _k;
    private float _y;
    
    public StraightLine(float[] a, float[] b) {
        _x = (Statistics.getCorrelationCoefficient(a, b));
        _m = Statistics.getAverage(b) - (_x*Statistics.getAverage(a));
    }

    public float getY(float x) {
        float m = _m;
        float k = 10;
        _y = (k * _x) + m;
        return _y;
    }

    @Override
    public String toString() {
        return "y="+_y+"x + "+_m;
    }
}
