// prob: https://www.acmicpc.net/problem/10775

package random_depense.back10775;

import java.util.Arrays;
import java.util.List;

public class Back10775 {
    private static final int EMPTY = -1;

    public int getMaxCountParking(int gate, List<Integer> wantToParkingMaxNumbers) {
        int[] gates = new int[gate + 1];
        Arrays.fill(gates, EMPTY);
        int count = 0;
        for (int wantToParkingMaxNumber : wantToParkingMaxNumbers) {
            if (hasParkingPlane(wantToParkingMaxNumber, gates)) {
                count++;
                continue;
            }
            break;
        }
        return count;
    }

    private boolean hasParkingPlane(int maxGate, int[] gates) {
        int id = unionFind(maxGate, gates);
        return id != EMPTY;
    }

    private int unionFind(int id, int[] gates) {
        if (gates[id] != EMPTY) {
            gates[id] = unionFind(gates[id], gates);
            return gates[id];
        }
        gates[id] = id - 1;
        return gates[id];
    }
}
