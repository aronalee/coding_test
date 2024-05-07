// prob: https://www.acmicpc.net/problem/19585

package backjoon.back19585;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    private final Trie[] nexts = new Trie[26];
    private boolean isEndWord = false;

    public void insert(String word) {
        Trie current = this;
        for (int idx = 0; idx < word.length(); idx++) {
            char c = word.charAt(idx);
            if (current.nexts[c - 'a'] == null) {
                current.nexts[c - 'a'] = new Trie();
            }
            current = current.nexts[c - 'a'];
        }
        current.isEndWord = true;
    }

    public List<Integer> findEndOfWordPositions(String word) {
        List<Integer> positions = new LinkedList<>();
        Trie current = this;
        for (int idx = 0; idx < word.length(); idx++) {
            char c = word.charAt(idx);
            if (current.nexts[c - 'a'] == null) {
                break;
            }
            current = current.nexts[c - 'a'];
            if (current.isEndWord) {
                positions.add(idx);
            }
        }
        return positions;
    }
}
