package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Navin Kumar
 * @date 6/28/18
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKList {

    private Node mergeKList(List<Node> lists) {
        Node dummy = new Node(0);
        Node merged = dummy;

        TreeMap<Integer, List<Node>> helper = new TreeMap<>();

        for(Node node : lists) {
            int val = node.v;
            if(!helper.containsKey(val)) {
                helper.put(val, new ArrayList<>());
            }
            helper.get(val).add(node);
        }

        while (!helper.isEmpty()) {
            Map.Entry<Integer, List<Node>> entry = helper.pollFirstEntry();
            int val = entry.getKey();
            for(Node node : entry.getValue()) {
                merged.next = new Node(val);
                merged = merged.next;
                if(node.next != null) {
                    int nextVal = node.next.v;
                    if(!helper.containsKey(nextVal)) {
                        helper.put(nextVal, new ArrayList<>());
                    }
                    helper.get(nextVal).add(node.next);
                }
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node n2 = new Node(4);
        h1.next = n2;
        n2.next = new Node(5);

        Node h2 = new Node(1);
        Node n4 = new Node(3);
        h2.next = n4;
        n4.next = new Node(4);

        Node h3 = new Node(2);
        h3.next = new Node(6);

        MergeKList mergeKList = new MergeKList();
        Node merged = mergeKList.mergeKList(Arrays.asList(h1, h2, h3));

        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(merged.toString());
    }

}
