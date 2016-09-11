package array;

/**
 * Created by keets on 9/4/16.
 */
public class PowerBig {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            return 1 / Power(base, -exponent);
        }
        double result = Power(base, exponent / 2);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }
        return result;
    }
}
