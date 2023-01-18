// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12987

package programmers.숫자_게임;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        int[] cloneA = Arrays.copyOf(A, A.length);
        int[] cloneB = Arrays.copyOf(B, B.length);
        Arrays.sort(cloneA);
        Arrays.sort(cloneB);
        int score = 0;
        int idxA = 0;
        int idxB = 0;
        while (idxA < A.length && idxB < B.length) {
            if (cloneA[idxA] < cloneB[idxB]) {
                idxA++;
                idxB++;
                score++;
                continue;
            }
            idxB++;
        }
        return score;
    }
}
