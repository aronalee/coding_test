// prob: https://www.acmicpc.net/problem/11256

package random_depnence.back11256;

import java.util.List;

public class Back11256 {

    public int computeCountMinOfBoxes(int totalCanddies, List<Box> boxes) {
        boxes.sort((b1, b2) -> Integer.compare(b2.getSquare(), b1.getSquare()));
        int count = 0;
        for (Box box : boxes) {
            totalCanddies -= box.getSquare();
            count++;
            if (totalCanddies <= 0) {
                return count;
            }
        }
        return count;
    }
}
