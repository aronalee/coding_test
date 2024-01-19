// prob: https://www.acmicpc.net/problem/15787

package backjoon.back15787;

import java.util.HashSet;
import java.util.Set;

public class Back15787 {
    private static final int TOTAL_TRAINS = 20;
    private final int[] trains;

    public Back15787(int[] trains) {
        this.trains = trains;
    }

    public void seatDownPerson(int trainNo, int seatNo) {
        trains[trainNo] |= (1 << seatNo);

    }

    public void seatUpPerson(int trainNo, int seatNo) {
        trains[trainNo] &= ~(1 << seatNo);
    }

    public void pushSeatLeft(int trainNo) {
        trains[trainNo] <<= 1;
        trains[trainNo] &= ((1 << (TOTAL_TRAINS + 1)) - 1);
    }

    public void pullSeatRight(int trainNo) {
        trains[trainNo] >>= 1;
        trains[trainNo] &= ~1;
    }

    public int countTotalTrains() {
        Set<Integer> visited = new HashSet<>();
        for (int train : trains) {
            visited.add(train);
        }
        return visited.size();
    }
}
