package sorting;

/**
 * @author FogHorn Systems, Inc.
 */
public class SelectionSort extends Sort {

    public void sort(int[] input) {

        for(int i = 0; i< input.length; i++) {
            int minPosition = i;
            for(int j = i+1; j < input.length; j++) {
                if(input[j] < input[minPosition]) {
                    minPosition = j;
                }
            }

            if(minPosition != i) {
                int tmp = input[i];
                input[i] = input[minPosition];
                input[minPosition] = tmp;
            }
        }
    }
}
