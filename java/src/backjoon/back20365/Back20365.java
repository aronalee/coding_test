// prob: https://www.acmicpc.net/problem/20365

package backjoon.back20365;

import java.util.List;

public class Back20365 {
    private static final String BLUE = "B";
    private static final String RED = "R";

    public int computeFilledColors(List<String> colors) {
        return Math.min(countFillBlueFirst(colors), countFilledRedFirst(colors));
    }

    private int countFilledRedFirst(List<String> colors) {
        return countColor(colors, BLUE, RED) + 1;

    }

    private int countFillBlueFirst(List<String> colors) {
        return countColor(colors, RED, BLUE) + 1;
    }

    private int countColor(List<String> colors, String colorInclude, String colorExclude) {
        String colorBefore = colors.get(0);
        int count = 0;
        if (colorBefore.equals(colorInclude)) {
            count++;
        }
        for (String color : colors) {
            if (color.equals(colorExclude) || color.equals(colorBefore)) {
                colorBefore = color;
                continue;
            }
            if (color.equals(colorInclude)) {
                colorBefore = color;
                count++;
            }
        }
        return count;
    }
}
