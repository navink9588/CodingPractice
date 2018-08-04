package leetcode;

/**
 * @author Navin Kumar
 * @date 6/19/18
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class ListSumReverse {

    private static class Node {
        public Integer val;
        public Node next = null;

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(val);
            Node tmp = next;
            while (tmp != null) {
                builder.append(" -> ")
                    .append(tmp.val);
                tmp = tmp.next;
            }
            return builder.toString();
        }
    }

    public Node sum(Node num1, Node num2) {
        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);

        Node dummy = new Node();

        Node tmp = dummy;
        int carry = 0;
        while (num1 != null || num2 != null) {
            int v1 = (num1 != null) ? num1.val : 0;
            int v2 = (num2 != null) ? num2.val : 0;
            int sum = carry + v1 + v2;
            carry = sum/10;

            tmp.next = new Node();
            tmp = tmp.next;
            tmp.val = sum%10;

            num1 = (num1 != null) ? num1.next : null;
            num2 = (num2 != null) ? num2.next : null;
        }

        if(carry > 0) {
            tmp.next = new Node();
            tmp = tmp.next;
            tmp.val = carry;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node num1Val1 = new Node();
        num1Val1.val = 2;
        Node num1Val2 = new Node();
        num1Val2.val = 4;
        num1Val1.next = num1Val2;
        Node num1Val3 = new Node();
        num1Val3.val = 2;
        num1Val2.next = num1Val3;

        Node num2Val1 = new Node();
        num2Val1.val = 5;
        Node num2Val2 = new Node();
        num2Val2.val = 6;
        num2Val1.next = num2Val2;
        Node num2Val3 = new Node();
        num2Val3.val = 4;
        num2Val2.next = num2Val3;


        ListSumReverse listSumReverse = new ListSumReverse();
        Node sum = listSumReverse.sum(num1Val1, num2Val1);
        System.out.println("Sum: " + sum);
    }

}
