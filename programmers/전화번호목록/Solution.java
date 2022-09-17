// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42577

package 전화번호목록;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    private final HashSet<String> set = new HashSet<>();

    public boolean solution(String[] phone_book) {
        set.addAll(Arrays.asList(phone_book));
        for (String phone : phone_book) {
            if (existPrefix(phone)) return false;
        }
        return true;
    }

    private boolean existPrefix(String phone) {
        StringBuilder prefixBuilder = new StringBuilder();
        for (int i = 0; i < phone.length() - 1; i++) {
            prefixBuilder.append(phone.charAt(i));
            String prefix = prefixBuilder.toString();
            if (prefix.length() < phone.length()
                    && set.contains(prefix)) {
                return true;
            }
        }
        return false;
    }
}
