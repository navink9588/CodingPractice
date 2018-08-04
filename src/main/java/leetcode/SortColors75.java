package leetcode;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors75 {

    // Solution - https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    private void sortColors(int[] nums) {
        print("Original", nums);
        int n = nums.length;
        if(n <= 1) return;

        int l = 0, m = 0, h = n - 1;
        while (m <= h) {
            if(nums[m] == 0) {
                if(l != m) {
                    int tmp = nums[l];
                    nums[l] = nums[m];
                    nums[m] = tmp;
                }
                l++;
                m++;
            } else if(nums[m] == 1)
                m++;
            else if(nums[m] == 2) {
                if (h != m) {
                    int tmp = nums[h];
                    nums[h] = nums[m];
                    nums[m] = tmp;
                }
                h--;
            }
        }
        print("Sorted", nums);
    }

    private void print(String what, int[] nums) {
        System.out.print(what + ": [ ");
        for (int n : nums)
            System.out.print(n + " ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        SortColors75 sortColors = new SortColors75();
        int[] nums = {2,0,2,1,1,0};
        sortColors.sortColors(nums);

        nums = new int[]{0,1};
        sortColors.sortColors(nums);

        nums = new int[]{1,2,0};
        sortColors.sortColors(nums);
    }


}
