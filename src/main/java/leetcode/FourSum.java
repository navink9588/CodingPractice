package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 6/27/18
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * Solution
 * https://www.programcreek.com/2013/02/leetcode-4sum-java/
 *
 */
public class FourSum {

    private List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int n = arr.length;
        if(n < 4) return result;

        Arrays.sort(arr);

        for(int i = 0; i < n - 3; i++) {
            if(i != 0 && arr[i] == arr[i-1])
                continue;
            for(int j = i + 1; j < n - 2; j++) {
                if(j != i + 1 && arr[j] == arr[j-1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum > target)
                        l--;
                    else if(sum < target)
                        k++;
                    else {
                        List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        result.add(quad);

                        k++;
                        l--;

                        while (k < l && arr[k] == arr[k+1])
                            k++;

                        while (k < l && arr[l] == arr[l-1])
                            l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(arr, 0));
    }

}
