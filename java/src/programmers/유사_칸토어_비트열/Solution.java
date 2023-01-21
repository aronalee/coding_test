// prob: https://school.programmers.co.kr/learn/courses/30/lessons/148652

package programmers.유사_칸토어_비트열;

public class Solution {

    public int solution(int n, long l, long r) {
        long countL = countTrueBitUntilN(n, l - 1);
        long countR = countTrueBitUntilN(n, r);
        return (int) (countR - countL);
    }

    private long countTrueBitUntilN(int step, long n) {
        if (n <= 5) {
            if (n >= 3) {
                return n - 1;
            }
            return n;
        }
        long sectionSize = (long) Math.pow(5, step);
        if (n < sectionSize) {
            return countTrueBitUntilN(step - 1, n);
        }
        long sectionBitCount = (long) Math.pow(4, step);
        long includeSections = n / sectionSize;
        long remainder = n % sectionSize;
        long count = includeSections * sectionBitCount;
        if (includeSections >= 3) {
            count -= sectionBitCount;
        }
        if (remainder != 0 && includeSections == 2) {
            return count;
        }
        return count + countTrueBitUntilN(step - 1, remainder);
    }
}
