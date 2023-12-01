// prob: https://www.acmicpc.net/problem/12931

package random_depense.back12931;

public class Back12931 {
    private int useCondition1Count = 0;

    public int getMinimumCountInTargetArray(int[] targetArray) {
        int minCount = 0;
        for (int number : targetArray) {
            int result = getMinimumCount(number);
            minCount = Math.max(minCount, result);
        }
        return minCount + useCondition1Count;
    }

    private int getMinimumCount(int number) {
        int count = 0;
        while (number != 0) {
            if (number % 2 == 1) {
                useCondition1Count++;
                number--;
                continue;
            }
            count++;
            number /= 2;
        }
        return count;
    }
}
