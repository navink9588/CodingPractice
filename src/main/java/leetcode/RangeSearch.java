package leetcode;

/**
 * @author Navin Kumar
 * @date 7/7/18
 *
 * https://leetcode.com/problems/search-for-a-range/description/
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class RangeSearch {

    // My solution starts
    private int[] range(int[] a, int v) {
        int[] range = new int[2];
        int l = -1;
        int h = -1;

        int n = a.length - 1;
        int index = search(a, v, 0, n);

        if(index != -1) {
            l = index - 1;
            while (l >= 0 && a[l] == v)
                l--;
            l++;
            h = index + 1;
            while (h <= n && a[h] == v)
                h++;
            h--;
        }

        range[0] = l;
        range[1] = h;

        return range;
    }

    private int search(int[] a, int v, int l, int h) {
        if(l > h) return -1;

        int m = (l+h)/2;
        if(a[m] == v) return m;
        return a[m] < v ? search(a, v, m+1, h) : search(a, v, l, m-1);
    }
    // My solution ends

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    private int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    public static void main(String[] args) {
        RangeSearch search = new RangeSearch();
        int[] a = {5,7,7,7,8,8,10};
        int v = 8;
        int[] range = search.range(a, v);
        System.out.printf("Range for %d: [%d, %d]\n", v, range[0], range[1]);

        v = 6;
        range = search.range(a, v);
        System.out.printf("Range for %d: [%d, %d]\n", v, range[0], range[1]);

        v = 7;
        range = search.range(a, v);
        System.out.printf("Range for %d: [%d, %d]\n", v, range[0], range[1]);

        v = 8;
        range = search.searchRange(a, v);
        System.out.printf("Range for %d: [%d, %d]\n", v, range[0], range[1]);

        v = 6;
        range = search.searchRange(a, v);
        System.out.printf("Range for %d: [%d, %d]\n", v, range[0], range[1]);

        v = 7;
        range = search.searchRange(a, v);
        System.out.printf("Range for %d: [%d, %d]\n", v, range[0], range[1]);
    }

}
