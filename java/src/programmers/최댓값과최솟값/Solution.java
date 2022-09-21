// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12939

package programmers.최댓값과최솟값;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        return "" + Arrays.stream(s.split(" ")).parallel().mapToInt(Integer::parseInt).min().orElseThrow()
                + " " + Arrays.stream(s.split(" ")).parallel().mapToInt(Integer::parseInt).max().orElseThrow();
    }
}
