// prob: https://www.acmicpc.net/problem/1359

package backjoon.back1359;

public class Back1359 {

    public double computeWinPercent(int total, int select, int correct) {
        double precent = 0;
        double totalCombination = computeCombination(total, select);
        for (int k = correct; k <= select; k++) {
            if (total - select < select - k) {
                continue;
            }
            double selectedCombination = computeCombination(select, k)
                    * computeCombination(total - select, select - k);
            precent += selectedCombination / totalCombination;
        }
        return precent;
    }

    private double computeCombination(int total, int select) {
        return getFactorial(total) / (getFactorial(total - select) * getFactorial(select));
    }

    private double getFactorial(int n) {
        long value = 1;
        for (int i = n; i > 0; i--) {
            value *= i;
        }
        return value;
    }
}
