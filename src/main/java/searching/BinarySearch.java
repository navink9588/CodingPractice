package searching;

/**
 * @author FogHorn Systems, Inc.
 */
public class BinarySearch {

    public int search(int[] input, int val) {
        return search(input, val, 0, input.length-1);
    }

    private int search(int[] input, int val, int l, int r) {
        if(r >= l) {
            int m = (l+r)/2;

            if(val == input[m]) {
                return m;
            } else if(val < input[m]) {
                return search(input, val, l, m-1);
            } else {
                return search(input, val, m+1, r);
            }
        }

        return -1;
    }
}
