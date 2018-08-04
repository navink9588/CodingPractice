package linkedin;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * Write the sqrt function. Return the floor of the root if the number
 * is not a perfect square
 *
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 */
public class FloorSqrt {

    private static int floorSqrt(int x) {

        if(x == 0 || x == 1) {
            return x;
        }

        int start = 0, end = x, sqrt = 0;

        while (start <= end) {

            int mid = (start + end) / 2;

            int midSqur = mid * mid;

            if(midSqur == x) {
                return mid;
            } else if (midSqur < x) {
                start = mid + 1;
                sqrt = mid;
            } else {
                end = mid - 1;
            }
        }

        return sqrt;
    }

    public static void main(String[] args) {
        System.out.println("Sqrt of 4 : " + floorSqrt(4));
        System.out.println("Sqrt of 5 : " + floorSqrt(5));
        System.out.println("Sqrt of 11 : " + floorSqrt(11));
    }
}
