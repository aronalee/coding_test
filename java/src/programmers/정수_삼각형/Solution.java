// prob: https://school.programmers.co.kr/learn/courses/30/lessons/43105

package programmers.정수_삼각형;

public class Solution {

    public int solution(int[][] triangle) {
        int[][] m = new int[triangle.length][triangle[triangle.length - 1].length];
        System.arraycopy(triangle[triangle.length - 1], 0, m[triangle.length - 1], 0,
            triangle[triangle.length - 1].length);
        fillInMaxValue(triangle, m);
        return m[0][0];
    }

    private void fillInMaxValue(final int[][] triangle, final int[][] m) {
        for (int depth = triangle.length - 2; depth >= 0; depth--) {
            for (int i = 0; i < triangle[depth].length; i++) {
                m[depth][i] = Math.max(m[depth + 1][i], m[depth + 1][i + 1]) + triangle[depth][i];
            }
        }
    }
}
