// prob: https://school.programmers.co.kr/learn/courses/30/lessons/152996

package programmers.시소_짝꿍;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Solution {

    private final long[] COMPARE_LENGTHS = new long[]{2, 3, 4};

    public long solution(int[] weights) {
        Map<Integer, Long> weightToCountPeople = new HashMap<>();
        Set<Integer> uniqueWeights = new LinkedHashSet<>();
        new HashSet<>();
        for (Integer weight : weights) {
            if (!weightToCountPeople.containsKey(weight)) {
                weightToCountPeople.put(weight, 0L);
            }
            long count = weightToCountPeople.get(weight);
            weightToCountPeople.put(weight, count + 1);
            uniqueWeights.add(weight);
        }
        Set<Pair> pairOfWeight = createNoTDuplicatedPair(uniqueWeights);
        return addAllCombinations(weightToCountPeople, pairOfWeight);
    }

    private long addAllCombinations(
        Map<Integer, Long> weightToCountPeople,
        Set<Pair> pairOfWeight
    ) {
        AtomicLong answer = new AtomicLong();
        weightToCountPeople.forEach((key, value) -> {
            if (value < 2) {
                return;
            }
            answer.addAndGet(value * (value - 1) / 2);
        });
        pairOfWeight.forEach(pair -> {
            long countWeight1 = weightToCountPeople.get(pair.minValue);
            long countWeight2 = weightToCountPeople.get(pair.maxValue);
            answer.addAndGet(countWeight1 * countWeight2);
        });
        return answer.get();
    }

    private Set<Pair> createNoTDuplicatedPair(Set<Integer> uniqueWeights) {
        Set<Pair> set = new LinkedHashSet<>();
        for (int weight : uniqueWeights) {
            for (int compareWeight : uniqueWeights) {
                if (weight == compareWeight) {
                    continue;
                }
                Pair pair = new Pair(weight, compareWeight);
                if (set.contains(pair) || !hasEqualCase(weight, compareWeight)) {
                    continue;
                }
                set.add(pair);
            }
        }
        return set;
    }


    private boolean hasEqualCase(int weight1, int weight2) {
        for (long compareLength1 : COMPARE_LENGTHS) {
            long nowWeight = compareLength1 * weight1;
            for (long compareLength2 : COMPARE_LENGTHS) {
                long nextWeight = compareLength2 * weight2;
                if (nowWeight == nextWeight) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Pair {

        private final int minValue;
        private final int maxValue;

        public Pair(int minValue, int maxValue) {
            if (minValue > maxValue) {
                this.minValue = maxValue;
                this.maxValue = minValue;
                return;
            }
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return (minValue == pair.minValue && maxValue == pair.maxValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(minValue, maxValue);
        }
    }
}

