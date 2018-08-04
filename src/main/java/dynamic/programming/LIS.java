package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/14/18
 * Longest Increasing Sub-sequence
 */
public class LIS {

    // https://www.geeksforgeeks.org/longest-increasing-subsequence/
    private int lisLength(Integer[] a) {
        int n = a.length;
        if(n <= 1) return n;
        int[] lis = new int[n];

        for(int i=0; i<n; i++) {
            lis[i] = 1;
        }

        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(a[i] > a[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i : lis) {
            max = Math.max(i, max);
        }

        return max;

//        Alternatively, sort the lis array and return the last value
//        Arrays.sort(lis);
//        return lis[n-1];
    }

    // https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
    private Integer[] lis(Integer[] a) {
        int n = a.length;
        if(n <= 1) return a;

        List<List<Integer>> lis = new ArrayList<>();
        for (Integer ignored : a) {
            lis.add(new ArrayList<>());
        }
        lis.get(0).add(a[0]);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j] && lis.get(i).size() < lis.get(j).size() + 1) {
                    lis.get(i).clear();
                    lis.get(i).addAll(lis.get(j));
                    lis.get(i).add(a[i]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i < lis.size(); i++) {
            if(lis.get(i).size() > lis.get(max).size()) {
                max = i;
            }
        }

        return lis.get(max).toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        Integer[] a = {10, 22, 9, 33, 21, 50, 41, 60};
        int longestSubSeqLength = lis.lisLength(a);
        System.out.printf("Longest sub-seq length: %d\n", longestSubSeqLength);
        Integer[] longestSubSeq = lis.lis(a);
        System.out.print("Longest sub-seq: [ ");
        for(int i : longestSubSeq) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

}
