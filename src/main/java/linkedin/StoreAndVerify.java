package linkedin;

import java.util.HashSet;
import java.util.Set;

/**
 * LinkedIn Problem
 * https://www.careercup.com/question?id=5651199228379136
 *
 * Implement below function to store numbers in a DS:
 * void store(v);
 * Then implement below function to test if the given number
 * is present as sum of 2 numbers from DS
 * bool test(v);
 */
public class StoreAndVerify {

    Set<Integer> originalVals = new HashSet<>();

    public void store(int v) {
        originalVals.add(v);
    }

    public boolean test(int v) {
        for(int val : originalVals) {
            if(originalVals.contains(v - val)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StoreAndVerify storeAndVerify = new StoreAndVerify();

        storeAndVerify.store(1);
        storeAndVerify.store(1);
        storeAndVerify.store(3);
        storeAndVerify.store(5);
        storeAndVerify.store(6);

        int num = 4;
        if(storeAndVerify.test(num)) {
            System.out.println("Found 2 numbers which add up to " + num);
        } else {
            System.out.println("Din't find 2 numbers which add up to " + num);
        }

        num = 5;
        if(storeAndVerify.test(num)) {
            System.out.println("Found 2 numbers which add up to " + num);
        } else {
            System.out.println("Din't find 2 numbers which add up to " + num);
        }
    }
}
