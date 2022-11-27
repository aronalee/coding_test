// prob: https://school.programmers.co.kr/learn/courses/30/lessons/135807

package programmers.숫자카드나누기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int minValueA = getMinNumber(arrayA);
        int minValueB = getMinNumber(arrayB);
        Set<Integer> setA = convertArrayToHashSet(arrayA);
        Set<Integer> setB = convertArrayToHashSet(arrayB);
        List<Integer> commDivisorsA = createNumbersByCondition(setA, minValueA);
        List<Integer> commDivisorsB = createNumbersByCondition(setB, minValueB);
        int resultA = findDivisorByNotDividedSet(commDivisorsA, setB);
        int resultB = findDivisorByNotDividedSet(commDivisorsB, setA);
        if (resultA == -1 && resultB == -1) {
            return 0;
        } else if (resultA == -1) {
            return resultB;
        } else if (resultB == -1) {
            return resultA;
        }
        return Math.max(resultA, resultB);
    }

    private int getMinNumber(final int[] array) {
        int minValue = array[0];
        for (final int value : array) {
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }

    private List<Integer> createNumbersByCondition(final Set<Integer> set, final int number) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> divisors = createDivisors(number);
        for (final Integer divisor : divisors) {
            if (!IsDividedSetByDivisor(set, divisor, number)) {
                continue;
            }
            numbers.add(divisor);
        }
        return numbers;
    }

    private boolean IsDividedSetByDivisor(final Set<Integer> set, final int divisor,
        final int excludeNumber) {
        for (final Integer value : set) {
            if (value == excludeNumber) {
                continue;
            }
            if (value % divisor != 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> createDivisors(final int number) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }
        divisors.remove(1);
        return convertSetToReverseSortedList(divisors);
    }

    private List<Integer> convertSetToReverseSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());
        return list;
    }

    private Set<Integer> convertArrayToHashSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (final int value : array) {
            set.add(value);
        }
        return set;
    }

    private int findDivisorByNotDividedSet(List<Integer> sortedDivisors, Set<Integer> set) {
        for (final Integer divisor : sortedDivisors) {
            if (IsNotDividedArraysByDivisor(set, divisor)) {
                return divisor;
            }
        }
        return -1;
    }

    private boolean IsNotDividedArraysByDivisor(final Set<Integer> set, final Integer divisor) {
        for (final int number : set) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
