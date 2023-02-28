// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42898

package programmers.등굣길;

public class Solution {

    private final int PUDDLE = Integer.MIN_VALUE;

    public int solution(int m, int n, int[][] puddles) {
        int[][] memoization = createMemoization(m, n, puddles);
        return countDstCases(memoization, n - 1, m - 1);
    }


    private int[][] createMemoization(int m, int n, int[][] puddles) {
        int[][] memoization = new int[n][m];
        for (int[] puddle : puddles) {
            int y = puddle[1] - 1;
            int x = puddle[0] - 1;
            memoization[y][x] = PUDDLE;
        }
        if (m > 1 && memoization[0][1] != PUDDLE) {
            memoization[0][1] = 1;
        }
        if (n > 1 && memoization[1][0] != PUDDLE) {
            memoization[1][0] = 1;
        }
        return memoization;
    }

    private int countDstCases(int[][] memoization, int y, int x) {
        if (y < 0 || y >= memoization.length || x < 0 || x >= memoization[y].length
            || memoization[y][x] == PUDDLE) {
            return 0;
        }
        if (memoization[y][x] != 0) {
            return memoization[y][x];
        }
        return memoization[y][x] = (
            countDstCases(memoization, y - 1, x) +
                countDstCases(memoization, y, x - 1)
        ) % 1_000_000_007;
    }
}
