// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12923

package programmers.숫자블록;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private static final long MAX_BLOCK_NO = 10_000_000;

    public int[] solution(long begin, long end) {
        List<Long> numbers = new LinkedList<>();
        for (long number = begin; number <= end; number++) {
            numbers.add(createBlockNumber(number));
        }
        return convertAnswerByList(numbers);
    }

    private long createBlockNumber(long number) {
        if (number == 1) {
            return 0;
        }
        for (long factor = 2; factor <= Math.sqrt(number); factor++) {
            if (number / factor > MAX_BLOCK_NO) {
                continue;
            }
            if (number % factor == 0) {
                return number / factor;
            }
        }
        return 1;
    }

    private int[] convertAnswerByList(List<Long> list) {
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Math.toIntExact(list.get(i));
        }
        return answer;
    }

}
