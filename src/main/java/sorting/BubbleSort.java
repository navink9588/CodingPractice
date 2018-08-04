package sorting;

/**
 * @author FogHorn Systems, Inc.
 */
public class BubbleSort extends Sort {

    public void sort(int[] input) {
        int n = input.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if (input[j] > input[j+1]) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
    }
}
