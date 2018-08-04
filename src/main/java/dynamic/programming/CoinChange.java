package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/15/18
 *
 * https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChange {

    private int changes(int[] coins, int val) {
        int n = coins.length;

        int[] table = new int[val+1];
        table[0] = 1;

        for(int i = 0; i<n; i++) {
            for(int j = coins[i]; j <= val; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        return table[val];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int n = 4;
        CoinChange cc = new CoinChange();
        int count = cc.changes(arr, n);
        System.out.println(count);
    }

}
