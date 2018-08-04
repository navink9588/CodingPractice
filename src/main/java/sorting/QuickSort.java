package sorting;

/**
 * @author FogHorn Systems, Inc.
 */
public class QuickSort extends Sort {
    @Override public void sort(int[] input) {
        sort(input, 0, input.length-1);
    }

    private void sort(int[] input, int l, int h) {
        if(l < h) {
            int pi = partition(input, l, h);

            sort(input, l, pi-1);
            sort(input, pi+1, h);
        }
    }

    private int partition(int[] input, int l, int h) {
        int pivot = input[h];

        int i = l;

        for(int j = l; j < h; j++) {
            if(input[j] <= pivot) {
                int tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
                i++;
            }
        }

        int tmp = input[i];
        input[i] = input[h];
        input[h] = tmp;

        return i;
    }
}
