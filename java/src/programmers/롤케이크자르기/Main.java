// prob: https://school.programmers.co.kr/learn/courses/30/lessons/132265

package programmers.롤케이크자르기;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer;
        int n = topping.length;
        int[] countToppingForward = new int[n];
        int[] countToppingBackward = new int[n];
        Set<Integer> forwardSet = new HashSet<>();
        Set<Integer> backwardSet = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            int forwardTopping = topping[i];
            int backwardTopping = topping[topping.length - i - 1];
            forwardSet.add(forwardTopping);
            backwardSet.add(backwardTopping);
            countToppingForward[i] = forwardSet.size();
            countToppingBackward[topping.length - i - 1] = backwardSet.size();
        }
        int count = 0;
        for (int i = 0; i < countToppingForward.length - 1; i++) {
            if (countToppingForward[i] == countToppingBackward[i + 1]) {
                count++;
            }
        }
        answer = count;
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(s.solution(new int[]{1, 2, 3, 1, 4}));
    }
}
