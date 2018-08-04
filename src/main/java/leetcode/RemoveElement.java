package leetcode;

/**
 * @author Navin Kumar
 * @date 6/30/18
 *
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {

    private int remove(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] a = {3,2,2,3};
        int count = removeElement.remove(a, 3);
        System.out.println("Count = " + count);
    }

}
