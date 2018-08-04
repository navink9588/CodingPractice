package bitmanipulations;

/**
 * @author Navin Kumar
 * @date 7/14/18
 *
 * Imp question
 * Cracking the coding interview, Page 250
 */
public class BitSwapRequired {
    private int bitSwapRequired(int a, int b) {
        int count = 0;
        for(int c = a ^ b; c != 0; c = c >> 1) {
            count += (c & 1);
        }
        return count;
    }

    private int bitSwapRequired2(int a, int b) {
        int count = 0;
        for(int c = a ^ b; c != 0; c = c & (c-1))
            count++;
        return count;
    }

    public static void main(String[] args) {
        BitSwapRequired required = new BitSwapRequired();
        int a = 12;
        int b = 15;
        int count = required.bitSwapRequired(a, b);
        System.out.printf("[Method 1] %d to %d: %d\n", a, b, count);

        count = required.bitSwapRequired2(a, b);
        System.out.printf("[Method 2] %d to %d: %d\n", a, b, count);
    }
}
