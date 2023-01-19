// prob: https://school.programmers.co.kr/learn/courses/30/lessons/67258

package programmers.보석_쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public int[] solution(String[] gems) {
        int typeGems = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> gemToCountGem = new HashMap<>();
        int[] range = new int[]{0, gems.length - 1};
        int minSize = gems.length - 1;
        int endIdx = 0;
        addGem(gemToCountGem, gems[0]);
        for (int startIdx = 0; startIdx < gems.length; startIdx++) {
            if (gemToCountGem.size() < typeGems) {
                endIdx = updateEndIdx(endIdx, startIdx);
                endIdx = moveEndIdxUntilContainAllGemType(gems, typeGems, gemToCountGem, endIdx);
                if (gemToCountGem.size() < typeGems) {
                    break;
                }
            }
            if (minSize > endIdx - startIdx) {
                range[0] = startIdx;
                range[1] = endIdx;
                minSize = endIdx - startIdx;
            }
            removeGem(gemToCountGem, gems[startIdx]);
        }
        range[0]++;
        range[1]++;
        return range;
    }

    private void addGem(Map<String, Integer> gemToCountGem, String gem) {
        if (!gemToCountGem.containsKey(gem)) {
            gemToCountGem.put(gem, 0);
        }
        int count = gemToCountGem.get(gem);
        gemToCountGem.put(gem, count + 1);
    }

    private int updateEndIdx(int endIdx, int startIdx) {
        endIdx++;
        if (endIdx < startIdx) {
            endIdx = startIdx + 1;
        }
        return endIdx;
    }

    private int moveEndIdxUntilContainAllGemType(String[] gems, int typeGems,
        Map<String, Integer> gemToCountGem, int endIdx) {
        while (gemToCountGem.size() < typeGems && endIdx < gems.length) {
            addGem(gemToCountGem, gems[endIdx]);
            endIdx++;
        }
        endIdx--;
        return endIdx;
    }

    private void removeGem(Map<String, Integer> gemToCountGem, String gem) {
        int count = gemToCountGem.get(gem) - 1;
        if (count == 0) {
            gemToCountGem.remove(gem);
            return;
        }
        gemToCountGem.put(gem, count);
    }

}

