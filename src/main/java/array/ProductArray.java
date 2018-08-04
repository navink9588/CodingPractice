package array;

import java.util.Arrays;

import sun.jvm.hotspot.utilities.Assert;

/**
 * https://www.geeksforgeeks.org/a-product-array-puzzle/
 *
 * Algorithm:
 * 1) Construct a temporary array left[] such that left[i] contains product of all elements
 *      on left of arr[i] excluding arr[i].
 * 2) Construct another temporary array right[] such that right[i] contains product of all
 *      elements on on right of arr[i] excluding arr[i].
 * 3) To get prod[], multiply left[] and right[].
 */
public class ProductArray {
    private int[] productArray(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];

        int productSoFar = 1;
        for(int i = 0; i < n; i++) {
            output[i] = productSoFar;
            productSoFar *= arr[i];
        }

        productSoFar = 1;
        for(int i = n - 1; i >= 0; i--) {
            output[i] *= productSoFar;
            productSoFar *= arr[i];
        }

        return output;
    }

    public static void main(String[] args) {
        ProductArray productArray = new ProductArray();
        int[] input = {10, 3, 5, 6, 2};
        int[] expected = {180, 600, 360, 300, 900};

        int[] output = productArray.productArray(input);
        Assert.that(Arrays.equals(output, expected), "incorrect product array");
    }
}
