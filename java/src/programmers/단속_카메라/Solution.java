// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42884

package programmers.단속_카메라;

import java.util.Arrays;

public class Solution {

    public int solution(int[][] routes) {
        int answer = 0;
        int[][] sortedRoutes = createSortedRoutes(routes);
        int endPosition = Integer.MIN_VALUE;
        for (int[] route : sortedRoutes) {
            int start = route[0];
            int end = route[1];
            if (endPosition >= start) {
                if (endPosition > end) {
                    endPosition = end;
                }
                continue;
            }
            endPosition = end;
            answer++;
        }
        return answer;
    }

    private int[][] createSortedRoutes(int[][] routes) {
        int[][] cloneRoutes = Arrays.copyOf(routes, routes.length);
        for (int i = 0; i < cloneRoutes.length; i++) {
            cloneRoutes[i] = Arrays.copyOf(routes[i], routes[i].length);
        }
        Arrays.sort(cloneRoutes, (v1, v2) -> {
            if (v1[0] != v2[0]) {
                return v1[0] - v2[0];
            }
            return v1[1] - v2[1];
        });
        return cloneRoutes;
    }

}
