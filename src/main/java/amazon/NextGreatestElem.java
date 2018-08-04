package amazon;

import java.util.Stack;

/**
 * @author Navin Kumar
 * @date 7/23/18
 */
public class NextGreatestElem {

    private void printNextGreatestEle(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);

        for(int i = 1; i < n; i++) {
            int next = a[i];
            while (!stack.isEmpty() && stack.peek() < next) {
                int cur = stack.pop();
                System.out.println(cur + " --> " + next);
            }

            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> -1");
        }
    }

    public static void main(String[] args) {
        NextGreatestElem nge = new NextGreatestElem();
        int arr[] = { 11, 13, 21, 3 };
        nge.printNextGreatestEle(arr);
    }
}
