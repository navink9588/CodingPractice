package leetcode;

/**
 * @author Navin Kumar
 * @date 6/30/18
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * Solution
 * https://www.programcreek.com/2014/04/leetcode-swap-nodes-in-pairs-java/
 *
 * My own solution
 *
 */
public class SwapNodePairs {

    private Node swapPairs(Node head) {
        if(head == null || head.next == null)
            return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node n1 = dummy;
        Node n2 = n1.next;
        Node n3 = n2.next;

        while(n2 != null && n3 != null){
            n1.next = n3;
            n2.next = n3.next;
            n3.next = n2;

            n1 = n2;
            n2 = n1.next;
            n3 = n2 != null ? n2.next : null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodePairs swap = new SwapNodePairs();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        Node n6 = new Node(6);
        n5.next = n6;

        Node head = swap.swapPairs(n1);
        System.out.println(head.toString());
    }

}
