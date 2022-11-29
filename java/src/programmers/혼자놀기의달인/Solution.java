// prob: https://school.programmers.co.kr/learn/courses/30/lessons/131130

package programmers.혼자놀기의달인;

public class Solution {

    public int solution(int[] cards) {
        int answer = 0;
        for (int i = 0; i < cards.length; i++) {
            boolean[] visited = new boolean[cards.length];
            int countGroupA = countGroup(cards, visited, i);
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    continue;
                }
                int countGroupB = countGroup(cards, visited, j);
                answer = Math.max(answer, countGroupA * countGroupB);
            }
        }
        return answer;
    }

    private int countGroup(final int[] cards, final boolean[] visited, final int start) {
        int count = 0;
        int current = start;
        while (!visited[current]) {
            visited[current] = true;
            current = cards[current] - 1;
            count++;
        }
        return count;
    }
}
