package leetcode;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 */
public class SQRT69 {

    private int mySqrt(int x) {
        if (x <= 1) return x;

        int l = 0, h = x;
        int sqrt = 0;

        while (l <= h) {
            int m = (l + h) / 2;

            int sqr = m * m;
            if(sqr == x)
                return m;
            else if (sqr < x) {
                sqrt = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return sqrt;
    }

    public static void main(String[] args) {
        SQRT69 sqrt = new SQRT69();
        System.out.println(sqrt.mySqrt(4));
    }

}
