// prob https://www.acmicpc.net/problem/1038

package backjoon.back1038;

import java.util.ArrayList;
import java.util.List;

public class Back1038 {


    public String getDescNumberAboutN(int n) {
        if (n <= 10) {
            return Integer.toString(n);
        }
        if (n >= 1023) {
            throw new IllegalArgumentException("Over N");
        }
        List<Integer> numberOfDigit = findDescNumberOfN(n);
        return convertNumber(numberOfDigit);
    }

    private List<Integer> findDescNumberOfN(int n) {
        int count = 10;
        List<Integer> numberOfDigit = new ArrayList<>(List.of(1, 0));
        while (count < n) {
            count++;
            int lastIdx = numberOfDigit.size() - 1;
            int lastDigit = numberOfDigit.get(lastIdx);
            int nextDigit = numberOfDigit.get(lastIdx - 1);
            if (lastDigit + 1 < nextDigit) {
                numberOfDigit.set(numberOfDigit.size() - 1, lastDigit + 1);
                continue;
            }
            balancingNumberOfDigit(numberOfDigit);
        }
        return numberOfDigit;
    }

    private void balancingNumberOfDigit(List<Integer> numberOfDigit) {
        int up = 1;
        up = carryNumber(numberOfDigit, up);
        if (up == 1) {
            if (numberOfDigit.get(0) == 9) {
                numberOfDigit.set(0, numberOfDigit.get(1) + 1);
                numberOfDigit.add(0, numberOfDigit.size());
                return;
            }
            numberOfDigit.set(0, numberOfDigit.get(0) + 1);
        }
    }

    private int carryNumber(List<Integer> numberOfDigit, int up) {
        int lastIdx = numberOfDigit.size() - 1;
        numberOfDigit.set(lastIdx, 0);
        for (int idx = lastIdx - 1; idx > 0; idx--) {
            int now = numberOfDigit.get(idx);
            int next = numberOfDigit.get(idx - 1);
            if (now + 1 < next) {
                numberOfDigit.set(idx, now + 1);
                up = 0;
                break;
            }
            int pre = numberOfDigit.get(idx + 1);
            numberOfDigit.set(idx, pre + 1);
        }
        return up;
    }

    private String convertNumber(List<Integer> numberOfDigit) {
        StringBuilder builder = new StringBuilder();
        for (Integer number : numberOfDigit) {
            builder.append(number);
        }
        return builder.toString();
    }
}
