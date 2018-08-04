package sorting;

/**
 * @author FogHorn Systems, Inc.
 */
public class MergeSort extends Sort {

    @Override
    public void sort(int[] input) {
        sort(input, 0, input.length-1);
    }

    private void sort(int[] input, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            sort(input, l, m);
            sort(input, m+1, r);

            merge(input, l, m, r);
        }
    }

    private void merge(int[] input, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) {
            L[i] = input[l + i];
        }
        for(int i = 0; i < n2; i++) {
            R[i] = input[m + i + 1];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                input[k++] = L[i++];
            } else {
                input[k++] = R[j++];
            }
        }

        while(i < n1) {
            input[k++] = L[i++];
        }

        while(j < n2) {
            input[k++] = R[j++];
        }
    }
}
