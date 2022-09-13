// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12981

package 영어끝말잇기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Node {
    private final Map<Character, Node> children = new HashMap<>();

    private boolean end;

    public Map<Character, Node> getChildren() {
        return children;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}

class Trie {
    private final Node root = new Node();

    void insert(String str) {
        Node node = this.root;
        for (int i = 0; i < str.length(); i++) {
            node = node.getChildren().computeIfAbsent(str.charAt(i), key -> new Node());
        }
        node.setEnd(true);
    }

    boolean search(String str) {
        Node node = this.root;
        for (int i = 0; i < str.length(); i++) {
            node = node.getChildren().getOrDefault(str.charAt(i), null);
            if (node == null) {
                return false;
            }
        }
        return node.isEnd();
    }
}

class Solution {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Trie trie = new Trie();
        trie.insert(words[0]);
        for (int i = 1; i < words.length; i++) {
            String beforeWord = words[i - 1];
            String word = words[i];
            if (word.charAt(0) != beforeWord.charAt(beforeWord.length() - 1)
                    || trie.search(word)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            trie.insert(word);
        }

        return answer;
    }
}