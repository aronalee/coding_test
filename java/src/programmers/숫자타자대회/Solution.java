// prob: https://school.programmers.co.kr/learn/courses/30/lessons/136797

package programmers.숫자타자대회;


import java.util.Arrays;

public class Solution {

    private final int[][] costOfSrcToDst = new int[][]{
        {1, 7, 6, 7, 5, 4, 5, 3, 2, 3}, // 0
        {7, 1, 2, 4, 2, 3, 5, 4, 5, 6}, // 1
        {6, 2, 1, 2, 3, 2, 3, 5, 4, 5}, // 2
        {7, 4, 2, 1, 5, 3, 2, 6, 5, 4}, // 3
        {5, 2, 3, 5, 1, 2, 4, 2, 3, 5}, // 4
        {4, 3, 2, 3, 2, 1, 2, 3, 2, 3}, // 5
        {5, 5, 3, 2, 4, 2, 1, 5, 3, 2}, // 6
        {3, 4, 5, 6, 2, 3, 5, 1, 2, 4}, // 7
        {2, 5, 4, 5, 3, 2, 3, 2, 1, 2}, // 8
        {3, 6, 5, 4, 5, 3, 2, 4, 2, 1} // 9
    };

    private int[][][] memoization;
    private char[] numbersOfPositions;

    public int solution(String numbers) {
        init(numbers);
        return getMinWeight(0, 4, 6);
    }

    private void init(String numbers) {
        numbersOfPositions = numbers.toCharArray();
        memoization = new int[numbersOfPositions.length][10][10];
        for (final int[][] ints : memoization) {
            for (final int[] anInt : ints) {
                Arrays.fill(anInt, Integer.MAX_VALUE);
            }
        }
    }

    private int getMinWeight(final int position, final int left, final int right) {
        if (position == numbersOfPositions.length) {
            return 0;
        }
        if (memoization[position][left][right] != Integer.MAX_VALUE) {
            return memoization[position][left][right];
        }
        int next = numbersOfPositions[position] - '0';
        int result = Integer.MAX_VALUE;
        if (next != left) {
            int cost = getMovedCost(right, next);
            result = Math.min(getMinWeight(position + 1, left, next) + cost, result);
        }
        if (next != right) {
            int cost = getMovedCost(left, next);
            result = Math.min(getMinWeight(position + 1, next, right) + cost, result);
        }
        return memoization[position][left][right] = result;
    }

    private int getMovedCost(final int src, final int dst) {
        return costOfSrcToDst[src][dst];
    }

}
