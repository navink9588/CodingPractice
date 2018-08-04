package linkedin;

import sun.jvm.hotspot.utilities.Assert;

/**
 * https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * https://practice.geeksforgeeks.org/problems/closest-strings/0
 *
 * For example:
 * (“the”, “quick”, “brown”, “fox”, “quick”)
 * distance(“fox”,”the”) = 3
 * distance(“quick”, “fox”) = 1
 */
public class MinDistance {

    private static int minDistance(String[] arr, String first, String second) {
        int i;
        int prev = -1;
        int minDistance = Integer.MAX_VALUE;

        int n = arr.length;
        for(i = 0; i < n; i++) {
            if(arr[i].equals(first) || arr[i].equals(second)) {
                prev = i;
                break;
            }
        }

        if(prev == -1) {
            return prev;
        }

        for(; i < n; i++) {
            if(arr[i].equals(first) || arr[i].equals(second)) {
                if(!arr[i].equals(arr[prev]) && minDistance > i - prev) {
                    minDistance = i - prev;
                    if(minDistance == 1) return minDistance;
                }
                prev = i;
            }
        }

        if(minDistance == Integer.MAX_VALUE) {
            return -1;
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] arr = {"the", "quick", "brown", "fox", "quick"};
        Assert.that(minDistance(arr, "quick", "fox") == 1, "Invalid distance between quick and fox");
        Assert.that(minDistance(arr, "the", "fox") == 3, "Invalid distance between the and fox");
    }
}
