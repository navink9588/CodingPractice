package searching;

/**
 * @author FogHorn Systems, Inc.
 */
public class SearchMain {

    public static void main(String[] args) {
        int[] input = {64, 25, 12, 22, 11};

        LinearSearch linearSearch = new LinearSearch();
        boolean found = linearSearch.search(input, 10);
        System.out.println("Linear Found 10: " + found);
        found = linearSearch.search(input, 11);
        System.out.println("Linear Found 11: " + found);

        int[] input1 = {1, 2, 3, 5, 6, 9, 10};
        BinarySearch binarySearch = new BinarySearch();
        int pos = binarySearch.search(input1, 10);
        System.out.println("Linear Found 10: " + pos);
        pos = binarySearch.search(input1, 11);
        System.out.println("Linear Found 11: " + pos);
    }
}
