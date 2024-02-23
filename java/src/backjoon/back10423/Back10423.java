// prob: https://www.acmicpc.net/problem/10423

package backjoon.back10423;

import java.util.Comparator;
import java.util.List;

public class Back10423 {

    private static final int POWER_PLANT = -1;
    private final int totalCities;
    private final List<Integer> powerPlantsCities;
    private final List<Cable> cables;
    private int[] parents;

    public Back10423(int totalCities, List<Integer> powerPlantsCities, List<Cable> cables) {
        this.totalCities = totalCities;
        this.powerPlantsCities = powerPlantsCities;
        this.cables = cables;
    }

    public int findMinCablesLength() {
        parents = new int[totalCities];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (Integer powerPlantsCity : powerPlantsCities) {
            parents[powerPlantsCity] = POWER_PLANT;
        }
        cables.sort(Comparator.comparingInt(Cable::getLength));
        int minLength = 0;
        for (Cable cable : cables) {
            int city1 = cable.getCity1();
            int city2 = cable.getCity2();
            int parent1 = findParent(city1);
            int parent2 = findParent(city2);
            unionCities(parent1, parent2);
            if (parent1 == parent2) {
                continue;
            }
            minLength += cable.getLength();
            if (isAllConnected()) {
                break;
            }
        }
        return minLength;
    }

    private void unionCities(int parent1, int parent2) {
        if (parent1 == parent2) {
            return;
        }
        if (parent1 == POWER_PLANT) {
            parents[parent2] = parent1;
            return;
        }
        parents[parent1] = parent2;
    }

    private boolean isAllConnected() {
        for (int parent : parents) {
            if (parent != POWER_PLANT) {
                return false;
            }
        }
        return true;
    }

    private int findParent(int node) {
        if (parents[node] == POWER_PLANT) {
            return POWER_PLANT;
        }
        if (parents[node] == node) {
            return node;
        }
        parents[node] = findParent(parents[node]);
        return parents[node];
    }
}
