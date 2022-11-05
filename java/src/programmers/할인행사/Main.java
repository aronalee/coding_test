// prob: https://school.programmers.co.kr/learn/courses/30/lessons/131127

package programmers.할인행사;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int SALE_DAY = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> product2Count = new HashMap<>();
        Map<String, Integer> want2Number = createWant2Number(want, number);
        for (int day = discount.length - 1; day >= 0; day--) {
            String product = discount[day];
            if (product2Count.containsKey(product)) {
                product2Count.put(product, product2Count.get(product) + 1);
            } else {
                product2Count.put(product, 1);
            }
            if (day + SALE_DAY < discount.length) {
                String removeProduct = discount[day + SALE_DAY];
                product2Count.put(removeProduct, product2Count.get(removeProduct) - 1);
            }
            if (checkWantedProducts(product2Count, want2Number)) {
                answer++;
            }
        }
        return answer;
    }

    private Map<String, Integer> createWant2Number(String[] want, int[] number) {
        Map<String, Integer> wanted2Number = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wanted2Number.put(want[i], number[i]);
        }
        return wanted2Number;
    }

    private boolean checkWantedProducts(Map<String, Integer> product2Count, Map<String, Integer> wanted2Number) {
        int count = 0;
        for (String key : wanted2Number.keySet()) {
            if (!product2Count.containsKey(key)) {
                break;
            }
            if (wanted2Number.get(key).intValue() != product2Count.get(key).intValue()) {
                break;
            }
            count++;
        }
        return count == wanted2Number.size();
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice",
                        "apple", "pork", "banana", "pork", "rice", "pot",
                        "banana", "apple", "banana"});
        System.out.println(result);
    }
}
