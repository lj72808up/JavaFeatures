package codeIntegrity;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent(可正,可负,可0)。求base的exponent次方。
 */
public class Power {
    public double Power(double base, int exponent) {
        boolean inValidInput = false;
        if (exponent==0)
            return 1;
        if (base==0 && exponent<0) {
            inValidInput = true;
            return 0;
        }
        int abs = Math.abs(exponent);
        double res = powerPositive(base,abs);
        if (exponent<0)
            return 1.0/res;
        return res;
    }

    private double powerPositive(double base, int exponent){
        double res = 1;
        while (exponent>0) {
            res = res*base;
            exponent--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(2.0,-1));;
    }
}
