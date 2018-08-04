package leetcode;

/**
 * @author Navin Kumar
 * @date 6/21/18
 *
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {

    private int reverse(int n) {
        int m = 0;
        while (n != 0) {
            m = (m * 10) + (n % 10);
            n = n / 10;
        }
        return m;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(120));
    }
}
