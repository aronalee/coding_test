// prob: https://school.programmers.co.kr/learn/courses/30/lessons/181188

package programmers.요격_시스템;

import java.util.Arrays;

public class Solution {

    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (t1, t2) -> {
            if (t1[0] == t2[0]) {
                return Integer.compare(t1[1], t2[1]);
            }
            return Integer.compare(t1[0], t2[0]);
        });
        int endPosition = Integer.MAX_VALUE;
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            if (endPosition <= start) {
                answer++;
                endPosition = end;
                continue;
            }
            if (endPosition > end) {
                endPosition = end;
            }
        }
        return answer;
    }
}
