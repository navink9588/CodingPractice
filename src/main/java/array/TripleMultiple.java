package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class TripleMultiple {

    private List<List<Integer>> combinations(int[] input, int num) {

        Arrays.sort(input);

        List<List<Integer>> combinations = new ArrayList<>();

        int n = input.length;
        for(int i = 0; i < n - 2; i++) {

            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                int sum = input[i] + input[l] + input[r];
                if(sum == num) {
                    List<Integer> combo = Arrays.asList(input[i], input[l], input[r]);
                    combinations.add(combo);
                    break;
                } else if (sum < num) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return combinations;
    }

    public static void main(String[] args) {
        int[] input = {100, -1, -1, 0, 0, 1, 2, 3, 4, -101};
        int num = -1;

        TripleMultiple tripleMultiple = new TripleMultiple();

        List<List<Integer>> combinations = tripleMultiple.combinations(input, num);

        System.out.println(combinations);
    }
}
