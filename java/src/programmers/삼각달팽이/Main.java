// prob: https://school.programmers.co.kr/learn/courses/30/lessons/68645

package programmers.삼각달팽이;

import java.util.Arrays;


class Solution {

    private int number = 1;
    private int MAX_SIZE;

    public int[] solution(int n) {
        MAX_SIZE = n;
        int[][] sequence = new int[MAX_SIZE][];
        for (int i = 0; i < n; i++) {
            sequence[i] = new int[i + 1];
        }
        int[] point = new int[]{0, 0};
        while (checkPointInSequence(sequence, point) && sequence[point[0]][point[1]] == 0) {
            point = addTopToDown(sequence, point);
            point = addLeftToRight(sequence, point);
            point = addDownToUp(sequence, point);
        }
        return flat1DArrayBySequence(sequence);
    }

    private boolean checkPointInSequence(final int[][] sequence, int[] point) {
        return point[0] >= 0 && point[0] < sequence.length
            && point[1] >= 0 && point[1] < sequence[point[0]].length;
    }

    private int[] flat1DArrayBySequence(final int[][] sequence) {
        int answerSize = 0;
        for (final int[] subSequence : sequence) {
            answerSize += subSequence.length;
        }
        int[] answer = new int[answerSize];
        int answerIdx = 0;
        for (final int[] subSequence : sequence) {
            for (final int element : subSequence) {
                answer[answerIdx] = element;
                answerIdx++;
            }
        }
        return answer;
    }

    private int[] addTopToDown(final int[][] sequence, final int[] point) {
        int y = point[0];
        int x = point[1];
        while (y < MAX_SIZE && sequence[y][x] == 0) {
            sequence[y][x] = number;
            number++;
            y++;
        }
        return new int[]{y - 1, x};
    }

    private int[] addLeftToRight(final int[][] sequence, final int[] point) {
        int y = point[0];
        int x = point[1] + 1;
        while (x < sequence[y].length && sequence[y][x] == 0) {
            sequence[y][x] = number;
            number++;
            x++;
        }
        return new int[]{y, x - 1};
    }

    private int[] addDownToUp(final int[][] sequence, final int[] point) {
        int y = point[0] - 1;
        int x = point[1] - 1;
        while (x >= 0 && y >= 0 && sequence[y][x] == 0) {
            sequence[y][x] = number;
            number++;
            y--;
            x--;
        }
        return new int[]{y + 2, x + 1};
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(1)));
    }
}
