// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12904

package programmers.가장_긴_팰린드롬;

public class Solution {

    public int solution(String s) {
        int answer = 1;
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start++) {
            for (int end = chars.length - 1; end > start; end--) {
                int length = createPalindromeLength(chars, start, end);
                answer = Math.max(answer, length);
            }
        }
        return answer;
    }

    private int createPalindromeLength(char[] chars, int start, int end) {
        int count = 0;
        while (start <= end) {
            if (chars[start] != chars[end]) {
                count = 1;
                break;
            }
            if (start != end) {
                count++;
            }
            count++;
            start++;
            end--;
        }
        return count;
    }
}
