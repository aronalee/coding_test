// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12979

package programmers.기지국_설치;

public class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int range = w * 2 + 1;
        for (int station : stations) {
            answer += getNeedStations(station - w, now, range);
            now = station + w + 1;
        }
        if (n - now < 0) {
            return answer;
        }
        if (now == n) {
            return answer + 1;
        }
        return answer + getNeedStations(n, now, range);
    }

    private int getNeedStations(int endStation, int startEmptyStation, int range) {
        if (endStation - startEmptyStation < 0) {
            return 0;
        }
        int result = (endStation - startEmptyStation) / range;
        if ((endStation - startEmptyStation) % range != 0) {
            return result + 1;
        }
        return result;
    }

}
