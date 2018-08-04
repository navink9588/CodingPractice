package linkedin;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * Write a function to compute n^k. Handle -ve exponents.
 */
public class Exponent {

    // My own solution - O(n)
    private static double exponent(int n, int k) {
        boolean negativeExponent = false;

        if(k == 0) {
            return 1;
        } else if(k < 0) {
            negativeExponent = true;
            k *= -1;
        }

        int val = 1;
        for(int i = 0; i < k; i++) {
            val *= n;
        }

        return negativeExponent ? (1.0/val) : val;
    }

    // https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
    // O(log(k))
    private static float pow(float n, int k) {
        if(k == 0) {
            return 1;
        }
        float tmp = pow(n, k/2);
        if(k % 2 == 0) {
            return tmp * tmp;
        } else {
            if (k > 0) {
                return n * tmp * tmp;
            } else {
                return (tmp * tmp) / n;
            }
        }
    }

    // https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y/
    // O(log(y))
    private static float powIter(int x, int y) {
        if(x == 0) return 0;
        if(y == 0) return 1;
        float pow = 1;
        boolean neg = false;
        if(y < 0) {
            neg = true;
            y = -y;
        }
        while (y > 0) {
            if(y % 2 != 0)
                pow = pow * x;

            y = y / 2;
            x = x * x;
        }
        return neg ? 1/pow : pow;
    }

    public static void main(String[] args) {
        System.out.println("2^4 : " + powIter(2, 4));
        System.out.println("2^6 : " + powIter(2, 6));
        System.out.println("2^-6 : " + powIter(2, -6));
    }
}
