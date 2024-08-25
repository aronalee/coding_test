// prob: https://www.acmicpc.net/problem/9202

package backjoon.back9202;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Trie {

    private static final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    private final Trie[] children;
    private boolean isEndWord = false;

    public Trie() {
        this.children = new Trie[26];
    }

    public void addWord(String word) {
        Trie now = this;
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            int idx = getChildIdx(character);
            if (now.children[idx] == null) {
                now.children[idx] = new Trie();
            }
            now = now.children[idx];
            if (i == characters.length - 1) {
                now.isEndWord = true;
            }
        }
    }

    public Set<String> findAllUniqueWords(char[][] map) {
        Set<String> uniqueWords = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (this.children[getChildIdx(map[i][j])] == null) {
                    continue;
                }
                Set<String> newUniqueWords = new HashSet<>();
                LinkedList<Character> characters = new LinkedList<>();
                boolean[][] visited = new boolean[4][4];
                initParams(map, characters, i, j, visited);
                addAllUniqueWords(map, this.children[getChildIdx(map[i][j])], new int[]{i, j},visited , characters,
                    newUniqueWords);
                uniqueWords.addAll(newUniqueWords);
            }
        }
        return uniqueWords;
    }

    private void initParams(char[][] map, LinkedList<Character> characters, int i, int j,
        boolean[][] visited) {
        characters.add(map[i][j]);
        visited[i][j] = true;
    }

    private void addAllUniqueWords(char[][] map, Trie trie, int[] point,
        boolean[][] visited, LinkedList<Character> charsFound, Set<String> words) {
        if (charsFound.size() == 8) {
            if (trie.isEndWord){
                words.add(charactersToString(charsFound));
            }
            return;
        }
        if (trie.isEndWord) {
            words.add(charactersToString(charsFound));
        }
        int y = point[0];
        int x = point[1];
        for (int[] direction : DIRECTIONS) {
            int nextY = y + direction[0];
            int nextX = x + direction[1];
            if (nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[nextY].length
                || visited[nextY][nextX]) {
                continue;
            }
            char character = map[nextY][nextX];
            int childIdx = getChildIdx(character);
            if (trie.children[childIdx] == null) {
                continue;
            }
            visited[nextY][nextX] = true;
            charsFound.addLast(character);
            addAllUniqueWords(map, trie.children[childIdx], new int[]{nextY, nextX}, visited,
                charsFound, words);
            charsFound.removeLast();
            visited[nextY][nextX] = false;
        }
    }

    private int getChildIdx(char character) {
        return character - 'A';
    }


    private String charactersToString(LinkedList<Character> word) {
        StringBuilder builder = new StringBuilder();
        for (Character character : word) {
            builder.append(character);
        }
        return builder.toString();
    }
}
