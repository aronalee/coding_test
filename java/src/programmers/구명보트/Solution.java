// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42885

package programmers.구명보트;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.sort(people);
        for (int person :
                people) {
            queue.offerLast(person);
        }
        while (queue.size() > 0) {
            if (queue.size() % 2 != 0)
                queue.pollLast();
            else {
                int maxValue = queue.pollLast();
                int minValue = queue.pollFirst();
                if (maxValue + minValue > limit)
                    queue.offerFirst(minValue);
            }
            answer++;
        }
        return answer;
    }
}