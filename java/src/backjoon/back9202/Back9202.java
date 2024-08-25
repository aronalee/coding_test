// prob: https://www.acmicpc.net/problem/9202

package backjoon.back9202;

import java.util.List;
import java.util.Set;

public class Back9202 {

    private final Trie trie;

    public Back9202(List<String> words) {
        this.trie=new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
    }

    public List<Object> simulateBoggleGame(char[][] map) {
        Set<String> words = trie.findAllUniqueWords(map);
        int score = words.stream()
            .mapToInt(word -> {
                switch (word.length()) {
                    case 1:
                        return 0;
                    case 2:
                        return 0;
                    case 3:
                        return 1;
                    case 4:
                        return 1;
                    case 5:
                        return 2;
                    case 6:
                        return 3;
                    case 7:
                        return 5;
                    case 8:
                        return 11;
                    default:
                        throw new IllegalStateException();
                }
            }).sum();
        String wordLongest=findWordMaxLength(words);
        long count = words.size();
        return List.of(score, wordLongest, count);
    }


    private String findWordMaxLength(Set<String> words) {
        int maxLength=0;
        String wordMaxLength = "";
        for (String word : words) {
            if (word.length() < maxLength) {
                continue;
            }
            if (word.length() == maxLength && word.compareTo(wordMaxLength)>=0) {
                continue;
            }
            maxLength = word.length();
            wordMaxLength = word;
        }
        return wordMaxLength;
    }

}

