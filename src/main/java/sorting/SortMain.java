package sorting;

/**
 * @author FogHorn Systems, Inc.
 */
public class SortMain {

    public static void main(String[] args) {
        Sort sort;

        sort = new SelectionSort();
        int[] SelectionSortInput = {64, 25, 12, 22, 11};
        sort.sort(SelectionSortInput);
        System.out.println("Selection Sorted : " + sort.toString(SelectionSortInput));

        sort = new BubbleSort();
        int[] BubbleSortInput = {65, 24, 13, 21, 10};
        sort.sort(BubbleSortInput);
        System.out.println("Bubble Sorted : " + sort.toString(BubbleSortInput));

        sort = new InsertionSort();
        int[] InsertionSortInput = {62, 27, 18, 23, 18};
        sort.sort(InsertionSortInput);
        System.out.println("Insertion Sorted : " + sort.toString(InsertionSortInput));

        sort = new MergeSort();
        int[] MergeSortInput = {12, 11, 13, 5, 6, 7, 1, 1};
        sort.sort(MergeSortInput);
        System.out.println("Merge Sorted : " + sort.toString(MergeSortInput));

        sort = new QuickSort();
        int[] QuickSortInput = {12, 11, 13, 5, 6, 7, 1, 1};
        sort.sort(QuickSortInput);
        System.out.println("Quick Sorted : " + sort.toString(QuickSortInput));
    }
}
