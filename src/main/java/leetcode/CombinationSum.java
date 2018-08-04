package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Navin Kumar
 * @date 7/7/18
 *
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {

    private Set<List<Integer>> set;
    private static final String SEPARATOR =  " ";
    public void sum(int[] arr, int target) {
        set = new HashSet<>();
        for (int anArr : arr) {
            sum(arr, target, anArr, String.valueOf(anArr));
        }
        System.out.println(set);
    }

    private void sum(int[] arr, int target, int sum, String ramp) {
        if(sum == target) {
            addComb(ramp);
            return;
        }

        for (int anArr : arr) {
            if (sum + anArr == target) {
                addComb(ramp + SEPARATOR + anArr);
            } else if (sum + anArr < target) {
                sum(arr, target, sum + anArr, ramp + SEPARATOR + anArr);
            }
        }
    }

    private void addComb(String ramp) {
        String[] strings = ramp.split(SEPARATOR);
        List<Integer> comb = new ArrayList<>();
        for(String s : strings) {
            comb.add(Integer.valueOf(s));
        }
        Collections.sort(comb);
        set.add(comb);
    }

    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int s = 7;

        CombinationSum sum = new CombinationSum();
        sum.sum(a, s);

        int[] a1 = {2,3,5};
        s = 8;
        sum.sum(a1, s);
    }

}
