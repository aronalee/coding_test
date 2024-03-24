// prob: https://www.acmicpc.net/problem/15918

package backjoon.back15198;

import java.util.Arrays;

public class Back15198 {
    private static final int EMPTY = -1;
    private final int n;
    private final int x;
    private final int y;
    private int count;

    public Back15198(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public int countLanPerdenSequence() {
        this.count = 0;
        int[] sequence = new int[2 * n];
        boolean[] isUsed = new boolean[n + 1];
        Arrays.fill(sequence, EMPTY);
        sequence[y] = y - x - 1;
        sequence[x] = y - x - 1;
        isUsed[y - x - 1] = true;
        fillCountUsingDFS(0, sequence, isUsed);
        return count;
    }

    private void fillCountUsingDFS(int idx, int[] sequence, boolean[] isUsed) {
        if (idx == sequence.length) {
            count++;
            return;
        }
        if (sequence[idx] == EMPTY) {
            for (int number = 1; number <= n; number++) {
                if (isUsed[number]) {
                    continue;
                }
                if (idx + number + 1 < sequence.length && sequence[idx + number + 1] == EMPTY) {
                    sequence[idx] = number;
                    sequence[idx + number + 1] = number;
                    isUsed[number] = true;
                    fillCountUsingDFS(idx + 1, sequence, isUsed);
                    isUsed[number] = false;
                    sequence[idx] = EMPTY;
                    sequence[idx + number + 1] = EMPTY;
                }
            }
        } else {
            fillCountUsingDFS(idx + 1, sequence, isUsed);
        }
    }


}
