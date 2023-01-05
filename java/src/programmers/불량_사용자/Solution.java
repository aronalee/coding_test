// prob: https://school.programmers.co.kr/learn/courses/30/lessons/64064

package programmers.불량_사용자;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {

    private int countBanId;
    private List<Set<String>> banLists;
    private List<List<String>> matchedBanIds;

    public int solution(String[] userIds, String[] bannedId) {
        matchedBanIds = new ArrayList<>();
        for (String banId : bannedId) {
            List<String> candidates = new ArrayList<>();
            Pattern pattern = createPatternByBanId(banId);
            for (String userId : userIds) {
                if (pattern.matcher(userId).find()) {
                    candidates.add(userId);
                }
            }
            matchedBanIds.add(candidates);
        }
        countBanId = bannedId.length;
        banLists = new ArrayList<>();
        recursion(new HashSet<>(), 0);
        return banLists.size();
    }

    private Pattern createPatternByBanId(final String banId) {
        StringBuilder builder = new StringBuilder();
        builder.append('^');
        for (char c : banId.toCharArray()) {
            if (c == '*') {
                builder.append("[a-z0-9]");
                continue;
            }
            builder.append(c);
        }
        builder.append('$');
        return Pattern.compile(builder.toString());
    }

    private void recursion(final Set<String> currentSet, final int idx) {
        if (idx == countBanId) {
            if (banLists.isEmpty()) {
                banLists.add(currentSet);
                return;
            }
            for (Set<String> candidateBanList : banLists) {
                if (candidateBanList.containsAll(currentSet)) {
                    return;
                }
            }
            banLists.add(currentSet);
            return;
        }
        for (String id : matchedBanIds.get(idx)) {
            if (currentSet.contains(id)) {
                continue;
            }
            Set<String> duplicateSet = new java.util.HashSet<>(currentSet);
            duplicateSet.add(id);
            recursion(duplicateSet, idx + 1);
        }
    }
}
