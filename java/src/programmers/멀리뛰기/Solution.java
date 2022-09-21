// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12914

package programmers.멀리뛰기;

public class Solution {
    private int[] memoization;

    private int recurrsion(int n) {
        if (n < 0)
            return 0;
        if (memoization[n] != 0)
            return memoization[n];
        memoization[n] = (recurrsion(n - 1) + recurrsion(n - 2)) % 1234567;
        return memoization[n];
    }

    public long solution(int n) {
        int answer;
        this.memoization = new int[n + 1];
        this.memoization[1] = 1;
        if (n > 1)
            this.memoization[2] = 2;
        answer = recurrsion(n);
        return answer;
    }
}

