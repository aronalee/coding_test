// prob: https://www.acmicpc.net/problem/5446

package backjoon.back5446;

public class Trie {
    private static final char ROOT_NODE = ' ';
    private final char node;
    private final Trie[] children;

    private boolean isEndOfWord = false;
    private boolean canDelete = true;

    public Trie() {
        this.node = ROOT_NODE;
        this.children = new Trie[127];
    }

    private Trie(char node) {
        this.node = node;
        this.children = new Trie[127];
    }

    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c] == null) {
                current.children[c] = new Trie(c);
            }
            current = current.children[c];
        }
        current.isEndOfWord = true;
    }

    public void markingCanNotDelete(String word) {
        Trie current = this;
        this.canDelete = false;
        for (char c : word.toCharArray()) {
            if (current.children[c] == null) {
                return;
            }
            current = current.children[c];
            current.canDelete = false;
        }
    }


    public int countCanDelete() {
        int count = 0;
        if (this.isEndOfWord && !this.canDelete) {
            count++;
        }
        if (this.canDelete) {
            return ++count;
        }
        for (Trie child : this.children) {
            if (child == null) {
                continue;
            }
            count += child.countCanDelete();
        }
        return count;
    }
}
