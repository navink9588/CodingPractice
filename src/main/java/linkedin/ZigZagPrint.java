package linkedin;

import java.util.Stack;

import tree.Node;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * print binary tree level by level and zig-zag order.
 *
 * https://www.geeksforgeeks.org/zigzag-tree-traversal/
 */
public class ZigZagPrint {

    public static void printZigZag(Node<Integer> root) {
        if(root == null) {
            return;
        }

        Stack<Node> current = new Stack<>();
        Stack<Node> next = new Stack<>();

        current.push(root);
        boolean leftToRight = true;

        System.out.println("[");
        boolean begin = true;
        while (!current.isEmpty()) {
            Node n = current.pop();

            if(begin) {
                System.out.print("[ ");
                begin = false;
            }
            System.out.print(n.getVal() + " ");

            if(leftToRight) {
                if(n.getL() != null) {
                    next.push(n.getL());
                }
                if(n.getR()!=null) {
                    next.push(n.getR());
                }
            } else {
                if(n.getR()!=null) {
                    next.push(n.getR());
                }
                if(n.getL() != null) {
                    next.push(n.getL());
                }
            }

            if(current.isEmpty()) {
                leftToRight = !leftToRight;
                current.addAll(next);
                next.clear();
                System.out.print("]");
                System.out.println();
                begin = true;
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Node<Integer> r = new Node<>(1);
        Node<Integer> r_l = new Node<>(2);
        Node<Integer> r_r = new Node<>(3);
        r.left(r_l).right(r_r);

        Node<Integer> r_l_l = new Node<>(7);
        Node<Integer> r_l_r = new Node<>(6);
        r_l.left(r_l_l).right(r_l_r);

        printZigZag(r);
    }


}
