package leetcode;

/**
 * @author Navin Kumar
 * @date 6/28/18
 */
public class Node {
    public int v;
    public Node next = null;
    public Node(int v) {
        this.v = v;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node tmp = this;
        while (tmp != null) {
            builder.append(tmp.v);
            tmp = tmp.next;
            if(tmp != null) builder.append(" -> ");
        }
        builder.append("\n");

        return builder.toString();
    }
}
