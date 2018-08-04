package linkedin;

import java.util.HashSet;
import java.util.Set;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * Write a program to list factors of a given number
 */
public class Factors {

    private static Set<Integer> factors(int val) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(val);

        for(int i = 2; i < val/2; i++) {
            if(!factors.contains(i) && val%i == 0) {
                factors.add(i);
                factors.add(val/i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Factors of 12 : " + factors(12));
    }
}
