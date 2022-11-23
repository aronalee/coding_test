// prob: https://school.programmers.co.kr/learn/courses/30/lessons/84512

package programmers.모음사전;

import java.util.LinkedList;
import java.util.List;

class Solution {

    private final String[] VOWELS = new String[]{"A", "E", "I", "O", "U"};

    private void addWordsInDictionary(List<String> dictionary, String current, int depth) {
        if (depth > 5) {
            return;
        }
        dictionary.add(current);
        for (final String vowel : VOWELS) {
            addWordsInDictionary(dictionary, current + vowel, depth + 1);
        }
    }

    private List<String> createDictionary() {
        List<String> dictionary = new LinkedList<>();
        addWordsInDictionary(dictionary, "", 0);
        return dictionary;
    }

    public int solution(String word) {
        List<String> dictionary = createDictionary();
        return dictionary.indexOf(word);
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AAAAE"));
        System.out.println(s.solution("AAAE"));
        System.out.println(s.solution("I"));
        System.out.println(s.solution("EIO"));
    }

}
