// prob: https://school.programmers.co.kr/learn/courses/30/lessons/64062

package programmers.징검다리_건너기;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            updateBulk(deque, stone, i - k);
            deque.addLast(Node.newInstance(i, stone));
            if (i >= k - 1) {
                answer = Math.min(answer, deque.peekFirst().stone);
            }
        }
        return answer;
    }

    private void updateBulk(Deque<Node> deque, int stone, int underIdx) {
        if (!deque.isEmpty() && (deque.peekFirst().idx <= underIdx)) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && deque.peekLast().stone <= stone) {
            deque.removeLast();
        }
    }

    private static class Node {

        private final int idx;
        private final int stone;

        private Node(int idx, int stone) {
            this.idx = idx;
            this.stone = stone;
        }

        public static Node newInstance(int idx, int stone) {
            return new Node(idx, stone);
        }
    }

}
