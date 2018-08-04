package leetcode;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/rotate-list/description/
 * Solution - https://gist.github.com/luoxiaoxun/5855264
 */
public class RotateList61 {

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode rotateRight(ListNode head, int k) {

        if(head == null) return null;

        ListNode cur = head;
        int len = 1;

        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        cur.next = head;
        int preLen = len - 1 - (k % len);

        ListNode pre = head;
        while(preLen > 0){
            pre = pre.next;
            preLen--;
        }

        head = pre.next;
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateList61 rotate = new RotateList61();

        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;

        ListNode head = rotate.rotateRight(n1, 4);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("null\n");

    }

}
