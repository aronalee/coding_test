// prob: https://school.programmers.co.kr/learn/courses/30/lessons/131701

package programmers.연속부분수열합의개수;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> createdNumberSet = new HashSet<>();
        for (int length = 1; length <= elements.length; length++) {
            List<Integer> sumSubSequences = createSumSubSequencesByLength(elements, length);
            createdNumberSet.addAll(sumSubSequences);
        }
        return createdNumberSet.size();
    }

    private List<Integer> createSumSubSequencesByLength(int[] elements, int length) {
        List<Integer> sumSubSequences = new LinkedList<>();
        for (int start = 0; start < elements.length; start++) {
            int end = start + length;
            int number = addElementsByStart2End(elements, start, end);
            sumSubSequences.add(number);
        }
        return sumSubSequences;
    }

    private int addElementsByStart2End(int[] elements, int start, int end) {
        int acc = 0;
        for (int i = start; i < end; i++) {
            acc += elements[i % elements.length];
        }
        return acc;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{7, 9, 1, 1, 4}) == 18);
    }
}
