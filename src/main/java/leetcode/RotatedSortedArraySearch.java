package leetcode;

/**
 * @author Navin Kumar
 * @date 7/7/18
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * Solution
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class RotatedSortedArraySearch {

    private int search(int[] a, int v) {
        int n = a.length;
        int pivot = findPivot(a, 0, n - 1);
        if(pivot == -1) return -1;

        if (a[pivot] == v)
            return pivot;
        if (a[0] <= v)
            return search(a, v, 0, pivot-1);
        return search(a, v, pivot+1, n-1);
    }

    private int findPivot(int[] a, int l, int h) {
        if(l > h) return -1;

        if(l == h) return l;

        int m = (l+h)/2;
        if(m < h && a[m] > a[m+1])
            return m;
        if(m > l && a[m] < a[m-1])
            return m-1;
        if(a[l] >= a[m])
            return findPivot(a, l, m-1);
        return findPivot(a, m+1, h);
    }

    private int search(int[] a, int v, int l, int h) {
        if(l > h) return -1;

        int m = (l+h)/2;
        if(a[m] == v) return m;
        if(a[m] > v) return search(a, v, l, m-1);
        return search(a, v, m+1, h);
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch search = new RotatedSortedArraySearch();
        int[] a = {4,5,6,7,0,1,2};
        int v = 0;
        int index = search.search(a, v);
        System.out.printf("Index of %d = %d\n", v, index);

        v = 6;
        index = search.search(a, v);
        System.out.printf("Index of %d = %d\n", v, index);
    }

}
