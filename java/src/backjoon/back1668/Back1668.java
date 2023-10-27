// prob: https://www.acmicpc.net/problem/1668

package backjoon.back1668;

import java.util.List;

public class Back1668 {
    public int getVisibleCountAboutLeft(List<Integer> heights) {
        int current = 0;
        int count = 0;
        for (Integer height : heights) {
            if (current >= height) {
                continue;
            }
            count++;
            current = height;
        }
        return count;

    }

    public int getVisibleCountAboutRight(List<Integer> heights) {
        int current = 0;
        int count = 0;
        for (int i = heights.size() - 1; i >= 0; i--) {
            int height = heights.get(i);
            if (current >= height) {
                continue;
            }
            count++;
            current = height;
        }
        return count;
    }
}
