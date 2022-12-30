// prob: https://school.programmers.co.kr/learn/courses/30/lessons/148653

package programmers.마법의_엘리베이터;

public class Solution {

    private int answer = Integer.MAX_VALUE;

    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
        int pow = Integer.toString(storey).length();
        recursion(storey, 0, pow - 1);
        return answer;
    }

    public void recursion(final int storey, final int count, final int pow) {
        if (pow == 0) {
            answer = Math.min(answer, count + Math.min(storey, 10 - storey + 1));
            return;
        }
        int digit = (int) (storey / Math.pow(10, pow));
        for (final int subDigit : new int[]{digit, digit + 1}) {
            int nextStorey = (int) Math.abs((storey - subDigit * Math.pow(10, pow)));
            if (subDigit == 10) {
                recursion(nextStorey, count + 1, pow - 1);
                continue;
            }
            if (subDigit > 5) {
                recursion((int) (Math.pow(10, pow + 1) - storey),
                    count + 1, pow);
                continue;
            }
            recursion(nextStorey, count + subDigit, pow - 1);
        }
    }
}
