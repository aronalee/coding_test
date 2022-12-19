// prob: https://school.programmers.co.kr/learn/courses/30/lessons/43163

package programmers.단어변환;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Tree {

    private final String word;
    private final Tree[] subTrees = new Tree[26];

    public Tree(final String word) {
        this.word = word;
    }

    public void addWord(String word) {
        addWord(word, 0);
    }

    private void addWord(String word, final int idx) {
        if (idx >= word.length()) {
            return;
        }
        Tree tree = getNextSegmentTree(word, idx);
        tree.addWord(word, idx + 1);
    }

    private Tree getNextSegmentTree(final String word, final int letterIdx) {
        char letter = word.charAt(letterIdx);
        int idx = letter - 'a';
        if (subTrees[idx] == null) {
            subTrees[idx] = new Tree(word.substring(0, letterIdx + 1));
        }
        return subTrees[idx];
    }

    public List<String> findNextWords(final String startWord) {
        List<String> words = new LinkedList<>();
        for (int excludeIdx = 0; excludeIdx < startWord.length(); excludeIdx++) {
            addWordInList(words, startWord, excludeIdx, 0);
        }
        return words;
    }

    private void addWordInList(final List<String> list, final String startWord,
        final int excludeDepth, final int depth) {
        if (depth == startWord.length()) {
            list.add(this.word);
            return;
        }
        char letter = startWord.charAt(depth);
        for (int i = 0; i < subTrees.length; i++) {
            Tree subTree = subTrees[i];
            if (subTree == null) {
                continue;
            }
            if (depth != excludeDepth && i != letter - 'a') {
                continue;
            }
            subTree.addWordInList(list, startWord, excludeDepth, depth + 1);
        }
    }

}

class Node {

    private final String word;
    private final Set<String> visited;
    private final int count;

    public Node(final String word, final Set<String> visited, final int count) {
        this.word = word;
        this.visited = visited;
        this.count = count;
    }

    public String word() {
        return word;
    }

    public Set<String> visited() {
        return visited;
    }

    public int count() {
        return count;
    }
}

public class Solution {

    public int solution(String begin, String target, String[] words) {
        Tree tree = new Tree("");
        for (final String word : words) {
            tree.addWord(word);
        }
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::count));
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        queue.add(new Node(begin, visited, 0));
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.word().equals(target)) {
                return now.count();
            }
            List<String> nextWords = tree.findNextWords(now.word());
            for (final String nextWord : nextWords) {
                if (now.visited().contains(nextWord)) {
                    continue;
                }
                Set<String> nextVisited = new HashSet<>(now.visited());
                nextVisited.add(nextWord);
                queue.add(new Node(nextWord, nextVisited, now.count() + 1));
            }
        }
        return 0;
    }
}
