package leetcode;

/**
 * @author Navin Kumar
 * @date 6/30/18
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {

    private int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;

        int pos = 0;

        for(int i = 1; i < n; i++) {
            while (i < n && arr[pos] == arr[i])
                i++;
            if(i != n) {
                pos = pos+1;
                arr[pos] = arr[i];
            }
        }

        for(int i = 0; i <= pos; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return pos + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] arr = {1,1,2};
        int count = removeDuplicates.removeDuplicates(arr);
        System.out.println(count);

        int[] arr1 = {0,0,1,1,1,2,2,3,3,4};
        count = removeDuplicates.removeDuplicates(arr1);
        System.out.println(count);
    }

}
