package linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * Convert Roman to Integer and vice-versa
 *
 * Solutions :
 * https://www.careercup.com/question?id=5667815146127360
 * http://blog.functionalfun.net/2009/01/project-euler-89-converting-to-and-from.html
 */
public class RomanToInteger {

    private static final Map<Character, Integer> romanToVal = new HashMap<>();

    static {
        romanToVal.put('I', 1);
        romanToVal.put('V', 5);
        romanToVal.put('X', 10);
        romanToVal.put('L', 50);
        romanToVal.put('C', 100);
        romanToVal.put('D', 500);
        romanToVal.put('M', 1000);
    }

    // Finds decimal value of a given romal numeral
    private int romanToDecimal(String str)
    {
        // Initialize result
        int res = 0;

        int n = str.length();
        for (int i=0; i< n; i++) {
            // Getting value of symbol s[i]
            char ch1 = Character.toUpperCase(str.charAt(i));
            int s1 = romanToVal.get(ch1);

            // Getting value of symbol s[i+1]
            if (i+1 < n) {
                char ch2 = Character.toUpperCase(str.charAt(i+1));
                int s2 = romanToVal.get(ch2);

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol is greater
                    // or equal to the next symbol
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            } else {
                res = res + s1;
            }
        }

        return res;
    }



    // Driver method
    public static void main(String args[])
    {
        RomanToInteger ob = new RomanToInteger();

        /*
            XXIL
            X  - 10
            X  - 10
            IL - 49
            -------
                 69
         */
        String roman = "XXIL";
        System.out.printf("Roman = %s; Int = %d\n", roman, ob.romanToDecimal(roman));
    }

}
