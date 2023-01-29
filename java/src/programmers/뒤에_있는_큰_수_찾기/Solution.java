// prob: https://school.programmers.co.kr/learn/courses/30/lessons/154539

package programmers.뒤에_있는_큰_수_찾기;

public class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = numbers.clone();
        int maxValue = numbers[numbers.length - 1];
        answer[numbers.length - 1] = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            answer[i] = -1;
            maxValue = Math.max(maxValue, numbers[i]);
            if (maxValue == numbers[i]) {
                continue;
            }
            for (int j = i + 1; j < answer.length; j++) {
                if (numbers[i] == numbers[j]) {
                    answer[i] = answer[j];
                    break;
                }
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
        }
        return answer;
    }

}
