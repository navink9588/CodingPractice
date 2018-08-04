package linkedin;

/**
 * @author Navin Kumar
 * @date 7/5/18
 * https://www.careercup.com/question?id=5642960319283200
 *
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
 *
 */
public class NumberOfSteps {

    private int hops(int n) {
        if(n == 0 || n == 1) return 1;

        if(n == 2) return 2;

        return hops(n - 1) + hops(n - 2) + hops(n - 3);
    }

    public static void main(String[] args) {
        NumberOfSteps steps = new NumberOfSteps();
        System.out.println(steps.hops(4));
    }

}
