// prob: https://school.programmers.co.kr/learn/courses/30/lessons/150367

package programmers.표현_가능한_이진트리;

import java.util.List;

public class Solution {

    private final List<Integer> BIN_SIZES = List.of(2, 4, 8, 16, 32, 64);

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        for (long number : numbers) {
            String binNumber = createBinNumber(number);
            if (isPrefectBinaryTree(binNumber.toCharArray())) {
                answer[idx] = 1;
            }
            idx++;
        }
        return answer;
    }

    private String createBinNumber(long number) {
        String bin = Long.toBinaryString(number);
        StringBuilder builder = new StringBuilder(bin);
        builder.reverse();
        while (!BIN_SIZES.contains(builder.length())) {
            builder.append('0');
        }
        builder.reverse();
        return builder.toString();
    }

    private boolean isPrefectBinaryTree(char[] bin) {
        int root = bin.length / 2;
        return inOrder(bin, root, root / 2);
    }

    private boolean inOrder(char[] bin, int node, int step) {
        if (node % 2 == 1 || node == 0) {
            return true;
        }
        int leftNode = node - step;
        int rightNode = node + step;
        if (bin[node] == '0' && (bin[leftNode] == '1' || bin[rightNode] == '1')) {
            return false;
        }
        int nextStep = step / 2;
        return inOrder(bin, leftNode, nextStep) && inOrder(bin, rightNode, nextStep);
    }
}
