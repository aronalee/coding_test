// prob: https://school.programmers.co.kr/learn/courses/30/lessons/131704

package programmers.택배상자;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {

    public int solution(int[] order) {
        int answer;
        List<Integer> truck = new LinkedList<>();
        Stack<Integer> subContainer = new Stack<>();
        Queue<Integer> mainContainer = new LinkedList<>();
        for (int i = 1; i < order.length + 1; i++) {
            mainContainer.add(i);
        }
        int idx = 0;
        while (!mainContainer.isEmpty() ||
            (!subContainer.isEmpty() && subContainer.peek() == order[idx])) {
            if (!subContainer.isEmpty() && subContainer.peek() == order[idx]) {
                truck.add(subContainer.pop());
                idx++;
                continue;
            }
            int newProduct = mainContainer.remove();
            if (newProduct == order[idx]) {
                truck.add(newProduct);
                idx++;
                continue;
            }
            subContainer.add(newProduct);
        }
        answer = truck.size();
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(s.solution(new int[]{5, 4, 3, 2, 1}));
    }
}
