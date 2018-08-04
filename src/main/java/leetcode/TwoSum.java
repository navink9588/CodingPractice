package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Navin Kumar
 * @date 6/19/18
 *
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    private Set<Integer> findSumIndices(int[] arr, int sum) {
        Set<Integer> indices = new HashSet<>();
        Map<Integer, Integer> vals = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!vals.isEmpty()) {
                int diff = Math.abs(sum - arr[i]);
                if(vals.containsKey(diff)) {
                    indices.add(i);
                    indices.add(vals.get(diff));
                    break;
                }
            }
            vals.put(arr[i], i);
        }

        return indices;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, -4};
        TwoSum twoSum = new TwoSum();
        Set<Integer> indices = twoSum.findSumIndices(arr, 11);
        System.out.println(indices);
    }

}
