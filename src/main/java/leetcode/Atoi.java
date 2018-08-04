package leetcode;

/**
 * @author Navin Kumar
 * @date 6/21/18
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class Atoi {
    // https://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
    private int atoi(String str) {
        if (str == null || str.isEmpty())
            return 0;

        // trim white spaces
        str = str.trim();

        boolean neg = false;

        // check negative or positive
        int i = 0;
        if (str.charAt(i) == '-') {
            neg = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && Character.isDigit(str.charAt(i))) {
            result = result * 10 + Character.getNumericValue(str.charAt(i));
            i++;
        }

        if(result == 0) return 0;

        result = neg ? -result : result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("    -91283432"));
    }

}
