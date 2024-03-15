// prob: https://www.acmicpc.net/problem/16472

package backjoon.back16472;

import java.util.List;

public class Back16472 {
    public int findLCS(int n, List<Character> sequence) {
        int start = 0;
        int end = 0;
        int lcs = 1;
        int[] usedCharCounts = new int[26];
        usedCharCounts[convertCharToIdx(0, sequence)] = 1;
        for (int i = 1; i < sequence.size(); i++) {
            end++;
            int endIdx = convertCharToIdx(end, sequence);
            usedCharCounts[endIdx]++;
            while (countUsedAlphabet(usedCharCounts) > n) {
                int startIdx = convertCharToIdx(start, sequence);
                usedCharCounts[startIdx]--;
                start++;
            }
            lcs = Math.max(lcs, end - start + 1);
        }
        return lcs;
    }

    private int convertCharToIdx(int idx, List<Character> sequence) {
        return sequence.get(idx) - 'a';
    }

    private int countUsedAlphabet(int[] usedCharCounts) {
        int count = 0;
        for (int usedCharCount : usedCharCounts) {
            if (usedCharCount == 0) {
                continue;
            }
            count++;
        }
        return count;
    }

}
