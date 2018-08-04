package linkedin;

import java.util.HashSet;
import java.util.Set;

/**
 * LinkedIn Problem
 * https://www.careercup.com/question?id=5644785908973568
 * https://stackoverflow.com/questions/18305843/find-all-subsets-that-sum-to-a-particular-value
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * Preferred solution based on ease of understanding and implementation
 */
public class PerfectSum3 {

    Set<String> set;
    public void sum(int[] arr, int target) {
        set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            sum(arr, target, i, arr[i], String.valueOf(arr[i]));
        }
        System.out.println(set);
    }

    private void sum(int[] arr, int target, int index, int sum, String ramp) {
        if(sum == target) {
            set.add(ramp);
            return;
        }

        for(int j = index + 1; j < arr.length; j++) {
            if(sum + arr[j] == target) {
                set.add(ramp + " " +arr[j]);
            } else if(sum + arr[j] < target) {
                sum(arr, target, j, sum + arr[j], ramp + " " +arr[j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 2, 3, 1, 5, 6, 8};
        int target = 8;

        PerfectSum3 perfectSum3 = new PerfectSum3();
        perfectSum3.sum(numbers, target);

        int[] a = {10,1,2,7,6,1,5};
        perfectSum3.sum(a, target);
    }

}
