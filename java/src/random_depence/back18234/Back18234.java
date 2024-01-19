// prob: https://www.acmicpc.net/problem/18234

package random_depence.back18234;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Back18234 {

    public long findMaxSumCarrot(int limitTime, List<Carrot> carrots) {
        AtomicLong atomicLong = new AtomicLong(limitTime - 1);
        return carrots.stream()
                .sorted((c1, c2) -> {
                    if (c1.getNutritional() != c2.getNutritional()) {
                        return Long.compare(c2.getNutritional(), c1.getNutritional());
                    }
                    return Long.compare(c2.getSeed(), c1.getSeed());
                })
                .mapToLong(carrot -> carrot.computeTasteAfterTime(atomicLong.getAndDecrement()))
                .sum();
    }
}
