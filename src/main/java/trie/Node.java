package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FogHorn Systems, Inc.
 */
public class Node {
    public Character self;
    public Map<Character, Node> children;
    public Character longest;
    public Integer size;

    public Node() {
        this(null);
    }

    public Node(Character self) {
        this.self = self;
        children = new HashMap<>();
        longest = null;
        size = null;
    }
}
