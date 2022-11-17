// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12936

package programmers.줄서는방법;

import java.util.Arrays;

class Solution {

    private long factorial(int n) {
        if (n < 2) {
            return 1;
        }
        long result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    public int[] solution(final int n, final long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n + 1];
        long order = k;
        int countRemainderNumber = n;
        long totalOrder = factorial(n);
        for (int idx = 0; idx < answer.length; idx++) {
            long range = totalOrder / countRemainderNumber;
            int countNumber = 1;
            for (int number = 1; number < visited.length; number++) {
                if (visited[number]) {
                    continue;
                }
                if (getTopByRange(range, countNumber) < order) {
                    countNumber++;
                    continue;
                }
                visited[number] = true;
                answer[idx] = number;
                order -= getBottomByRange(range, countNumber);
                countRemainderNumber--;
                break;
            }
            totalOrder /= (n - idx);
        }
        return answer;
    }

    private long getBottomByRange(final long range, final int countNumber) {
        return range * (countNumber - 1);
    }

    private long getTopByRange(final long range, final int countNumber) {
        return range * countNumber;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        printFactorialN(s, 3);
        printFactorialN(s, 4);
        printFactorialN(s, 5);
    }

    private static void printFactorialN(Solution s, int n) {
        long factorial = factorial(n);
        for (long i = 1; i <= factorial; i++) {
            System.out.println(Arrays.toString(s.solution(n, i)));
        }
    }

    private static long factorial(int n) {
        if (n < 2) {
            return 1;
        }
        long result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }

}
