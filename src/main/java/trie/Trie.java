package trie;

import java.util.Scanner;

/**
 * @author FogHorn Systems, Inc.
 */
public class Trie {
    private Node root;

    private Trie() {
        root = new Node();
    }

    public void add(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;

        Node parent = root;
        int i;
        for(i = 0; i < n-1; i++) {
            char current = chars[i];
            char next = chars[i+1];
            if(parent.children.containsKey(current)) {
                parent = parent.children.get(current);
                if(parent.size == null || parent.size < n) {
                    parent.longest = next;
                    parent.size = n;
                }
            } else {
                Node child = new Node(current);
                child.longest = next;
                child.size = n;
                parent.children.put(current, child);
                parent = child;
            }
        }
        Node child = new Node(chars[i]);
        parent.children.put(chars[i], child);
    }

    private String find_longest(String prefix) {
        Node parent = root;
        for(char c : prefix.toCharArray()) {
            if(!parent.children.containsKey(c)) {
                throw new RuntimeException("Invalid Prefix");
            }
            parent = parent.children.get(c);
        }
        StringBuilder prefixBuilder = new StringBuilder(prefix);
        while (parent.longest != null) {
            prefixBuilder.append(parent.longest);
            parent = parent.children.get(parent.longest);
        }
        return prefixBuilder.toString();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"corollary", "corroboration", "corroborate", "collaborate",
            "collaboration", "collaboratively", "car", "care", "carrot", "cannon"};
        for(String word : words) {
            trie.add(word);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a valid prefix [q to exit]: ");
            String prefix = scanner.next();
            if(prefix.equals("q")) {
                break;
            }
            System.out.printf("Longest word with Prefix '%s' is: '%s'.\n\n", prefix, trie.find_longest(prefix));
        }
    }
}
