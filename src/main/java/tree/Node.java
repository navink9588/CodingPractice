package tree;

/**
 * @author FogHorn Systems, Inc.
 */
public class Node<T> {
    private T val;
    private Node<T> l, r;

    public Node (T val) {
        this.val = val;
        this.l = null;
        this.r = null;
    }

    public T getVal() {
        return val;
    }

    public Node<T> getL() {
        return l;
    }

    public Node<T> getR() {
        return r;
    }

    public Node<T> left(Node<T> l) {
        this.l = l;
        return this;
    }

    public Node<T> right(Node<T> r) {
        this.r = r;
        return this;
    }
}
