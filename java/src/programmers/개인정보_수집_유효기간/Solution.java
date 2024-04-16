// prob: https://school.programmers.co.kr/learn/courses/30/lessons/150370

package programmers.개인정보_수집_유효기간;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public int[] solution(String todayRaw, String[] termsRaw, String[] privaciesRaw) {
        final LocalDate today = LocalDate.parse(todayRaw, dateFormatter);
        Map<Character, Integer> termNameToDueMonth = createTermNameToDueMonth(termsRaw);
        return createPrivacyList(privaciesRaw).stream().filter(privacy -> {
            int dueMonth = termNameToDueMonth.get(privacy.termName);
            LocalDate permittedDate = privacy.permittedDate.plusMonths(dueMonth);
            return today.isAfter(permittedDate) || today.isEqual(permittedDate);
        }).map(privacy -> privacy.idx).sorted().mapToInt(value -> value).toArray();
    }

    private Map<Character, Integer> createTermNameToDueMonth(String[] termsRaw) {
        HashMap<Character, Integer> termNameToDueMonth = new HashMap<>();
        Arrays.stream(termsRaw).forEach(termRaw -> {
            String[] termSplit = termRaw.split(" ");
            termNameToDueMonth.put(termSplit[0].charAt(0), Integer.parseInt(termSplit[1]));
        });
        return termNameToDueMonth;
    }

    private List<Privacy> createPrivacyList(String[] privaciesRaw) {
        List<Privacy> privacies = new ArrayList<>();
        for (int idx = 0; idx < privaciesRaw.length; idx++) {
            String[] privacySplit = privaciesRaw[idx].split(" ");
            LocalDate date = LocalDate.parse(privacySplit[0], dateFormatter);
            char termName = privacySplit[1].charAt(0);
            privacies.add(new Privacy(idx + 1, termName, date));
        }
        return privacies;
    }

    private static class Privacy {

        private final int idx;
        private final char termName;
        private final LocalDate permittedDate;

        public Privacy(int idx, char termName, LocalDate permittedDate) {
            this.idx = idx;
            this.termName = termName;
            this.permittedDate = permittedDate;
        }
    }
}
