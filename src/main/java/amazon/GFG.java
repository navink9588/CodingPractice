package amazon;

/**
 * @author Navin Kumar
 * @date 6/22/18
 *
 * https://www.geeksforgeeks.org/active-inactive-cells-k-days/
 */
public class GFG {

    // cells[] - store current status
    // of cells n - Number of cells
    // temp[] - to perform intermediate operations
    // k - number of days
    // active - count of active cells after k days
    // inactive - count of active cells after k days
    static void activeAndInactive(boolean cells[],
        int n, int k)
    {
        // copy cells[] array into temp [] array
        boolean temp[] = new boolean[n];
        System.arraycopy(cells, 0, temp, 0, n);

        // Iterate for k days
        while (k-- > 0) {

            // Finding next values for corner cells
            temp[0] = false ^ cells[1];
            temp[n - 1] = false ^ cells[n - 2];

            // Compute values of intermediate cells
            // If both cells active or inactive, then
            // temp[i]=0 else temp[i] = 1.
            for (int i = 1; i <= n - 2; i++)
                temp[i] = cells[i - 1] ^ cells[i + 1];

            // Copy temp[] to cells[] for next iteration
            System.arraycopy(temp, 0, cells, 0, n);
        }

        // count active and inactive cells
        int active = 0, inactive = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%b, ", cells[i]);
            if (cells[i])
                active++;
            else
                inactive++;
        }
        System.out.println();

        System.out.print("Active Cells = " + active + ", " +
            "Inactive Cells = " + inactive);
    }

    // Driver code
    public static void main(String[] args)
    {
        boolean cells[] = {false, true, false, true,
            false, true, false, true};
        int k = 3;
        int n = cells.length;
        activeAndInactive(cells, n, k);
    }

}
