package linkedin;

import java.util.Map;
import java.util.TreeMap;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * Convert integer to roman
 *
 * Solutions:
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 *
 * TreeMap
 * https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html
 */
public class IntegerToRoman {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    private static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }

    private static String toRomanIterative(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            Map.Entry<Integer, String> entry = map.floorEntry(num);
            builder.append(entry.getValue());
            num = num - entry.getKey();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        /*
            M  - 1000
            CM -  900
            XC -   90
            IV -    4
            ---------
                 1994
         */
        int val = 1994;
        System.out.printf("Int = %d; Roman = %s\n", val, toRoman(val));
        System.out.printf("Int = %d; RomanIterative = %s\n", val, toRomanIterative(val));

        /*
            L  - 50
            X  - 10
            IV -  4
            -------
                 64
         */
        val = 64;
        System.out.printf("Int = %d; Roman = %s\n", val, toRoman(val));
        System.out.printf("Int = %d; RomanIterative = %s\n", val, toRomanIterative(val));
    }

}
