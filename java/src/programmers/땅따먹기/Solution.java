// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12913

package programmers.땅따먹기;

import java.util.Arrays;

public class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] += Math.max(
                        land[i - 1][(j + 1) % 4],
                        Math.max(
                                land[i - 1][(j + 2) % 4], land[i - 1][(j + 3) % 4]
                        ));
            }
        }
        return Arrays.stream(land[land.length - 1]).max().orElseThrow();
    }
}
