package leetcode;

import java.util.ArrayList;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/
 *
 * Din't understand the solution.
 *
 * Could use Permutations46 solution
 */
public class PermutationSequence60 {

    // Solution - https://leetcode.com/problems/permutation-sequence/description/
    private String getPermutation(int n, int k) {
        // initialize all numbers
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }

        // change k to be index
        k--;

        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        StringBuilder result = new StringBuilder();

        // find sequence
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            // find the right number(curIndex) of
            int curIndex = k / mod;
            // update k
            k = k % mod;

            // get number according to curIndex
            result.append(numberList.get(curIndex));
            // remove from list
            numberList.remove(curIndex);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        PermutationSequence60 seq = new PermutationSequence60();
        int n = 4, k = 9;
        String perm = seq.getPermutation(n, k);
        System.out.printf("%d -- %d: %s\n", n, k, perm);
    }

}
