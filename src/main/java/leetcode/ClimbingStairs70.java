package leetcode;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs70 {

    public int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;

        if(n == 2) return 2;

        return (n - 1) + (n - 2);
    }

    public static void main(String[] args) {
        ClimbingStairs70 stairs = new ClimbingStairs70();
        System.out.println("2 Stairs: " + stairs.climbStairs(2));
        System.out.println("3 Stairs: " + stairs.climbStairs(3));
        System.out.println("4 Stairs: " + stairs.climbStairs(4));
    }

}
