// prob: https://school.programmers.co.kr/learn/courses/30/lessons/140107

package programmers.점찍기;

public class Solution {

    public long solution(int k, int d) {
        long answer = 1;
        for (int x = 0; x < d; x += k) {
            double y = createSideByDistance(x, d);
            answer += Math.floor(y / k);
        }
        answer += d / k;
        return answer;
    }

    public double createSideByDistance(double x, double d) {
        return Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
    }

}
