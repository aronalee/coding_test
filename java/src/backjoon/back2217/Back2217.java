// prob: https://www.acmicpc.net/problem/2217

package backjoon.back2217;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Back2217 {

    private final List<Long> ropes;

    public Back2217(final List<Long> ropes) {
        this.ropes = ropes;
    }

    public long getAnswer() {
        List<Long> sortedLope = new ArrayList<>(List.copyOf(ropes));
        Collections.sort(sortedLope);
        long answer = 0;
        for (int i = 0; i < sortedLope.size(); i++) {
            answer = Math.max(answer, sortedLope.get(i) * (sortedLope.size() - i));
        }
        return answer;
    }
}
