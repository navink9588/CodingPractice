package searching;

/**
 * @author FogHorn Systems, Inc.
 */
public class LinearSearch {

    public boolean search(int[] input, int val) {
        for(int i : input) {
            if(i == val)
                return true;
        }

        return false;
    }
}
