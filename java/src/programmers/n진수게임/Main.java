// prob: https://school.programmers.co.kr/learn/courses/30/lessons/17687

package programmers.n진수게임;

class Solution {

    public String solution(int n, int t, int m, int p) {
        return createString(n, t, m, p);
    }

    private String createString(final int n, final int t, final int m, final int p) {
        StringBuilder builder = new StringBuilder();
        int turn = 0;
        int number = 0;
        while (true) {
            char[] numberOfTPosition = Integer.toString(number, n).toUpperCase().toCharArray();
            for (final char c : numberOfTPosition) {
                if (turn == p - 1) {
                    builder.append(c);
                }
                if (builder.length() < t) {
                    turn = (turn + 1) % m;
                    continue;
                }
                return builder.toString();
            }
            number++;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 4, 2, 1));
        System.out.println(s.solution(16, 16, 2, 1));
        System.out.println(s.solution(16, 16, 2, 2));
    }
}
