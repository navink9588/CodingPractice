package leetcode;

/**
 * @author Navin Kumar
 * @date 6/27/18
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNode {

    private static class Node {
        private int v;
        public Node next = null;
        public Node(int v) {
            this.v = v;
        }
    }

    private Node removeNthNode(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node first = dummy;
        Node second = dummy;

        for(int i = 1; i <= n+1; i++) {
            first = first.next;
        }

        System.out.println("First = " + first.v);

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println("Second = " + second.v);

        second.next = second.next.next;

        return dummy.next;
    }

    private String toString(Node node) {
        StringBuilder builder = new StringBuilder();
        Node tmp = node;
        while (tmp != null) {
            builder.append(tmp.v)
                .append(" -> ");
            tmp = tmp.next;
        }
        builder.append(" null");
        return builder.toString();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        RemoveNthNode removeNthNode = new RemoveNthNode();
        Node head = removeNthNode.removeNthNode(n1, 2);
        System.out.println(removeNthNode.toString(head));
    }

}
