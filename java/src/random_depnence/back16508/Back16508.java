// prob: https://www.acmicpc.net/problem/16508

package random_depnence.back16508;

import java.util.*;

public class Back16508 {
    public int computeMinPrice(String word, Map<String, Integer> bookToPrice) {
        List<String> books = new ArrayList<>(bookToPrice.keySet());
        return findBookCombinations(new LinkedList<>(), new LinkedList<>(), books, 0)
                .stream()
                .filter(combination -> isMakeWord(combination, word))
                .mapToInt(combination -> {
                    int sum = 0;
                    for (String book : combination) {
                        sum += bookToPrice.get(book);
                    }
                    return sum;
                }).min().orElse(-1);
    }

    private List<List<String>> findBookCombinations(List<List<String>> combinations, LinkedList<String> combination, List<String> books, int startIdx) {
        if (combination.size() == books.size()) {
            return combinations;
        }
        for (int idx = startIdx; idx < books.size(); idx++) {
            combination.addLast(books.get(idx));
            combinations.add(new LinkedList<>(combination));
            findBookCombinations(combinations, combination, books, idx + 1);
            combination.removeLast();
        }
        return combinations;
    }

    private boolean isMakeWord(List<String> books, String word) {
        char[] elements = word.toCharArray();
        boolean[] isUsedElements = new boolean[word.length()];
        Map<String, Map<Character, Integer>> bookToWordMap = createWordMaps(books);
        for (String book : books) {
            for (int i = 0; i < elements.length; i++) {
                if (isUsedElements[i]) {
                    continue;
                }
                char element = elements[i];
                int remainCount = bookToWordMap.get(book).computeIfAbsent(element, key -> 0);
                if (remainCount > 0) {
                    bookToWordMap.get(book).put(element, remainCount - 1);
                    isUsedElements[i] = true;
                }
            }
        }
        for (boolean isUsedElement : isUsedElements) {
            if (!isUsedElement) {
                return false;
            }
        }
        return true;
    }

    private Map<String, Map<Character, Integer>> createWordMaps(List<String> books) {
        Map<String, Map<Character, Integer>> wordMaps = new HashMap<>();
        for (String book : books) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char element : book.toCharArray()) {
                wordMap.putIfAbsent(element, 0);
                wordMap.computeIfPresent(element, (key, value) -> value + 1);
            }
            wordMaps.put(book, wordMap);
        }
        return wordMaps;
    }

}
