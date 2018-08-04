package array;

/**
 * https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
 *
 * Given an array of n elements which contains elements from 0 to n-1, with
 * any of these numbers appearing any number of times. Find these repeating
 * numbers in O(n) and using only constant memory space.
 *
 * Time - O(n)
 * Space - O(1)
 */
public class Duplicates {

    private void duplicates(int[] in) {
        int n = in.length;

        for(int i = 0; i < n; i++) {
            int index = in[i] % n;
            in[index] += n;
        }

        for(int i = 0; i < n; i++) {
            if(in[i]/n > 1) {
                System.out.println(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Duplicates duplicates = new Duplicates();

        int[] in = {1, 6, 0, 1, 0, 4, 6,};
        duplicates.duplicates(in);

    }

}
