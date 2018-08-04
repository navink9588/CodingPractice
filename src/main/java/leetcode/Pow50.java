package leetcode;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/powx-n/description/
 */
public class Pow50 {

    private double pow(double x, int n) {
        double y = 1.0;
        boolean neg = n < 0;
        if(neg) n = Math.abs(n);
        while (n > 0) {
            if(n % 2 != 0)
                y *= x;
            n = n / 2;
            x *= x;
        }

        return neg ? 1/y : y;
    }

    public static void main(String[] args) {
        Pow50 pow = new Pow50();
        double x = 2.0;
        int n = 10;
        System.out.printf("Pow(%f, %d) = %f\n", x, n, pow.pow(x, n));

        x = 2.10;
        n = 3;
        System.out.printf("Pow(%f, %d) = %f\n", x, n, pow.pow(x, n));

        x = 2.0;
        n = -2;
        System.out.printf("Pow(%f, %d) = %f\n", x, n, pow.pow(x, n));
    }

}
