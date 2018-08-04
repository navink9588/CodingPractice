package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/14/18
 *
 * https://www.geeksforgeeks.org/knapsack-problem/
 */
public class Knapsack {

    private int knapsack(int W, int[] wt, int[] val) {
        int n = val.length;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (int v = 0; v <= n; v++)
        {
            for (int w = 0; w <= W; w++)
            {
                if (v == 0 || w == 0)
                    K[v][w] = 0;
                else if (wt[v-1] <= w)
                    K[v][w] = Math.max(val[v-1] + K[v-1][w-wt[v-1]],  K[v-1][w]);
                else
                    K[v][w] = K[v-1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsack(W, wt, val));
    }

}
