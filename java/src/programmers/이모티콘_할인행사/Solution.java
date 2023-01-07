// prob: https://school.programmers.co.kr/learn/courses/30/lessons/150368

package programmers.이모티콘_할인행사;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private final int[] DISCOUNT_RATES = new int[]{10, 20, 30, 40};
    private final int[] answer = new int[2];
    private int[][] users;
    private int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        generateRates(new LinkedList<>());
        return answer;
    }

    private void generateRates(final List<Integer> rates) {
        if (rates.size() == emoticons.length) {
            evaluateRates(rates);
            return;
        }
        for (int discount_rate : DISCOUNT_RATES) {
            rates.add(discount_rate);
            generateRates(rates);
            rates.remove(rates.size() - 1);
        }
    }

    private void evaluateRates(final List<Integer> rates) {
        int[] expectPrices = new int[users.length];
        int idx = 0;
        for (int rate : rates) {
            int price = emoticons[idx];
            int discountedPrice = (price - price * rate / 100);
            for (int id = 0; id < users.length; id++) {
                int[] user = users[id];
                int wantedRate = user[0];
                if (wantedRate > rate) {
                    continue;
                }
                expectPrices[id] += discountedPrice;
            }
            idx++;
        }
        compareAndReplaceAnswer(expectPrices);
    }

    private void compareAndReplaceAnswer(final int[] expectPrices) {
        int countSubscribe = 0;
        int totalPayments = 0;
        for (int id = 0; id < users.length; id++) {
            int limitPrice = users[id][1];
            if (expectPrices[id] < limitPrice) {
                totalPayments += expectPrices[id];
                continue;
            }
            countSubscribe++;
        }
        if (answer[0] < countSubscribe) {
            answer[0] = countSubscribe;
            answer[1] = totalPayments;
            return;
        }
        if (answer[0] == countSubscribe && answer[1] < totalPayments) {
            answer[1] = totalPayments;
        }
    }
}
