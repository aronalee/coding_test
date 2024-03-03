// prob: https://www.acmicpc.net/problem/1421

package backjoon.back1421;

import java.util.List;

public class Back1421 {

    public long computeMaxPrice(List<Long> woods, long cutCost, long sellingOfOneWood) {
        long maxPrice = 0;
        long maxWood = woods.stream().mapToLong(Long::longValue).max().orElse(0);
        for (long dividedSize = 1; dividedSize <= maxWood; dividedSize++) {
            long price = 0;
            for (Long wood : woods) {
                long priceOfOneWood = (wood / dividedSize) * sellingOfOneWood * dividedSize;
                if (wood % dividedSize == 0) {
                    priceOfOneWood -= (wood / dividedSize - 1) * cutCost;
                } else {
                    priceOfOneWood -= (wood / dividedSize) * cutCost;
                }
                if (priceOfOneWood < 0) {
                    continue;
                }
                price += priceOfOneWood;
            }
            maxPrice = Math.max(maxPrice, price);
        }
        return maxPrice;
    }
}
