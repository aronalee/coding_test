// prob: https://school.programmers.co.kr/learn/courses/30/lessons/134239

package programmers.우박수열정적분;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Long> sequence = createSequence(k);
        List<Double> integrals = createDefiniteIntegrals(sequence);
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int start = range[0];
            int end = sequence.size() - 1 + range[1];
            if (Math.abs(range[1]) > sequence.size() - 1 || end < start) {
                answer[i] = -1;
                continue;
            }
            if (end == start) {
                answer[i] = 0;
                continue;
            }
            for (int idx = end - 1; idx >= start; idx--) {
                answer[i] += integrals.get(idx);
            }
        }
        return answer;
    }

    private List<Long> createSequence(final int k) {
        long value = k;
        List<Long> sequence = new ArrayList<>();
        while (value > 1) {
            sequence.add(value);
            if (value % 2 == 0) {
                value /= 2;
                continue;
            }
            value = value * 3 + 1;
        }
        sequence.add(1L);
        return sequence;
    }

    private List<Double> createDefiniteIntegrals(List<Long> sequence) {
        List<Double> results = new ArrayList<>();
        for (int i = 1; i < sequence.size(); i++) {
            long top = sequence.get(i);
            long bottom = sequence.get(i - 1);
            results.add((top + bottom) / 2.0);
        }
        return results;
    }
}
