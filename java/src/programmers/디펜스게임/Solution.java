// prob: https://school.programmers.co.kr/learn/courses/30/lessons/142085

package programmers.디펜스게임;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int solution(int n, int k, int[] enemy) {
        int remainedPeople = n;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int round = 0; round < enemy.length; round++) {
            if (round < k || queue.isEmpty()) {
                queue.add(enemy[round]);
                continue;
            }
            int preEnemy = queue.peek();
            if (preEnemy < enemy[round]) {
                queue.remove();
                queue.add(enemy[round]);
                remainedPeople -= preEnemy;
            } else {
                remainedPeople -= enemy[round];
            }
            if (remainedPeople < 0) {
                return round;
            }
        }
        return enemy.length;
    }
}
