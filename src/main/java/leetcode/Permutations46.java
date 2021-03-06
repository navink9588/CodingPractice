package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations46 {

    // Solution - https://www.programcreek.com/2013/02/leetcode-permutations-java/
    private List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        permute(num, 0, result);
        return result;
    }

    private void permute(int[] num, int start, List<List<Integer>> result) {
        if (start == num.length) {
            List<Integer> item = convertArrayToList(num);
            result.add(item);
            return;
        }

        for (int j = start; j < num.length; j++) {
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }

    private List<Integer> convertArrayToList(int[] num) {
        List<Integer> item = new ArrayList<>();
        for (int aNum : num) {
            item.add(aNum);
        }
        return item;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations46 p = new Permutations46();
        List<List<Integer>> result = p.permute(nums);
        System.out.println(result);
    }

}
