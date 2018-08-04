package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/permutations-ii/description/
 */
public class Permutations47 {

    // Solution - https://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
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
            if (noDuplicates(num, start, j)) {
                swap(num, start, j);
                permute(num, start + 1, result);
                swap(num, start, j);
            }

        }
    }

    private boolean noDuplicates(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] == arr[end]) {
                return false;
            }
        }
        return true;
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
        int[] nums = {1,1,2};
        Permutations47 p = new Permutations47();
        List<List<Integer>> result = p.permute(nums);
        System.out.println(result);
    }
}
