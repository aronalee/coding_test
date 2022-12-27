// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12938

package programmers.최고의_집합;

public class Solution {

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        addNumbers(answer, 0, s, n);
        return answer;
    }

    private void addNumbers(int[] numbers, int idx, int s, int n) {
        if (n == 0) {
            return;
        }
        int number = s / n;
        numbers[idx] = number;
        addNumbers(numbers, idx + 1, s - number, n - 1);
    }

}
