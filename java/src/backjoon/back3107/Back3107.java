// prob: https://www.acmicpc.net/problem/3107

package backjoon.back3107;

import java.util.ArrayList;
import java.util.List;

public class Back3107 {
    private static final int NOT_FOUND_IDX = -1;
    private static final int IPV6_SECTION_COUNT = 8;
    private static final int IPV6_SECTION_STRING_COUNT = 4;

    public String unzippingIPV6(String zippedIPv6) {
        List<String> sectionsOfIPv6 = unzippingSemicolon(zippedIPv6);
        List<String> unzippedIPv6 = fillZero(sectionsOfIPv6);
        return String.join(":", unzippedIPv6);
    }

    private List<String> unzippingSemicolon(String zippedIPv6) {
        List<String> sections = splitIPv6(zippedIPv6);
        int emptyIndex = sections.indexOf("");
        if (sections.size() != IPV6_SECTION_COUNT && emptyIndex != NOT_FOUND_IDX) {
            sections.remove("");
            while (sections.size() < IPV6_SECTION_COUNT) {
                sections.add(emptyIndex, "0000");
            }
        }
        return sections;
    }

    private List<String> splitIPv6(String zippedIPv6) {
        List<String> ipv6Split = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : zippedIPv6.toCharArray()) {
            if (c == ':') {
                ipv6Split.add(sb.toString());
                sb.setLength(0);
                continue;
            }
            sb.append(c);
        }
        ipv6Split.add(sb.toString());
        return ipv6Split;
    }

    private List<String> fillZero(List<String> sectionsOfIPv6) {
        List<String> filledZeroIPv6 = new ArrayList<>();
        for (String section : sectionsOfIPv6) {
            int fillZeroCount = IPV6_SECTION_STRING_COUNT - section.length();
            String filledZeroSection = "0".repeat(Math.max(0, fillZeroCount)) + section;
            filledZeroIPv6.add(filledZeroSection);
        }
        return filledZeroIPv6;
    }
}
