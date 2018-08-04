package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
public class SlidingWindow {

    private List<Integer> maxSubArray(int[] input, int k) {
        int n = input.length;
        if(n < k) {
            throw new RuntimeException("array size can't be smaller than k");
        }
        List<Integer> subArray = new ArrayList<>();

        LinkedList<Integer> interestingList = new LinkedList<>();

        int i = 0;
        for(; i < k; i++) {
            updateInterestingList(interestingList, input, i);
        }

        subArray.add(input[interestingList.peek()]);

        for(; i < n; i++) {
            while (!interestingList.isEmpty() && interestingList.peek() <= i-k) {
                interestingList.removeFirst();
            }

            updateInterestingList(interestingList, input, i);

            subArray.add(input[interestingList.peek()]);
        }

        return subArray;
    }

    private void updateInterestingList(LinkedList<Integer> interestingList, int[] in, int i) {
        while (!interestingList.isEmpty() && in[i] >= in[interestingList.peekLast()])
            interestingList.removeLast();
        interestingList.addLast(i);
    }

    public static void main(String[] args) {
        int[] input = {79, 1, 78, 90, 57, 89, 56};
        int k = 3;

        SlidingWindow slidingWindow = new SlidingWindow();
        List<Integer> subArr = slidingWindow.maxSubArray(input, k);
        System.out.println(subArr);
    }

}
