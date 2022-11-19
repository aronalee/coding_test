// prob: https://school.programmers.co.kr/learn/courses/30/lessons/92335
package programmers.k진수에서_소수_개수_구하기;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    private final Pattern primePattern = Pattern.compile(
        "((?=0)[1-9]+)|((?=0)[1-9]+(?<=0))|([1-9]+(?<=0))|([1-9]+)");

    public int solution(int n, int k) {
        int answer = 0;
        String numberOfKDigit = convertKNotation(n, k);
        Matcher matcher = primePattern.matcher(numberOfKDigit);
        while (matcher.find()) {
            String value = matcher.group();
            if (isPrime(Long.parseLong(value))) {
                answer++;
            }
        }
        return answer;
    }

    private String convertKNotation(final int n, final int k) {
        StringBuilder builder = new StringBuilder();
        int number = n;
        while (number > 0) {
            builder.append(number % k);
            number /= k;
        }
        return builder.reverse().toString();
    }

    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(437674, 3));
        System.out.println(s.solution(110011, 10));
        System.out.println(s.solution(211, 10));
    }

}
