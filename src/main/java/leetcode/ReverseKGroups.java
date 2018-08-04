package leetcode;

import java.util.LinkedList;

/**
 * @author Navin Kumar
 * @date 7/6/18
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 *
 * Not working
 */
public class ReverseKGroups {

    private Node reverse(Node head, int k) {
        if(k < 2) return head;
        Node dummy = head;
        for(int i = 1; i <= k; i++) {
            if (dummy == null) return head;
            dummy = dummy.next;
        }
        dummy = new Node(0);
        dummy.next = head;

        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addLast(head);
        for(int i = 2; i <= k; i++) {
            Node cur = nodes.getLast();
            nodes.addLast(cur.next);
        }

        while (nodes.size() == k) {
            Node cur = nodes.removeLast();
            Node next = null;
            if(nodes.size() == k - 1) {
                next = cur.next;
            }
            while (!nodes.isEmpty()) {
                Node prev = nodes.getLast();
                cur.next = prev;
                cur = prev;
            }
            cur.next = next;
            nodes.addLast(cur);
            for(int i = 2; i<=k; i++) {
                if(cur.next != null) {
                    cur = cur.next;
                    nodes.addLast(cur);
                } else
                    break;
            }
        }

        return dummy.next;
    }


    private Node reverse2(Node head, int k)
    {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    public static void main(String[] args) {
        ReverseKGroups reverseKGroups = new ReverseKGroups();

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

        Node head = reverseKGroups.reverse2(n1, 3);
        System.out.println(head.toString());
    }

}
