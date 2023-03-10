// prob: https://school.programmers.co.kr/learn/courses/30/lessons/161989

package programmers.덧칠하기;

public class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintedPoint = 0;
        for (int point : section) {
            if (paintedPoint > n) {
                break;
            }
            if (point < paintedPoint) {
                continue;
            }
            paintedPoint = point + m;
            answer++;
        }
        return answer;
    }

}
