package leetcode;

/**
 * @author Navin Kumar
 * @date 6/21/18
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class MaxArea {
    private int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int left = heights[l];
            int right = heights[r];
            int newMaxArea = Math.min(left, right) * (r - l);
            maxArea = Math.max(maxArea, newMaxArea);

            if(left < right) l++;
            else r--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea maxArea = new MaxArea();
        System.out.println("Max area = " + maxArea.maxArea(heights));
    }
}
