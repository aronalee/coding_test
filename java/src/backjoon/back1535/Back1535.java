// prob: https://www.acmicpc.net/problem/1535

package backjoon.back1535;

import java.util.Arrays;
import java.util.List;

public class Back1535 {
    private static final int MAX_HP = 100;
    private static final int EMPTY = Integer.MIN_VALUE;

    public int findMaxHappy(List<Person> people) {
        int[][] maxHappyInHp = new int[people.size()][MAX_HP + 1];
        for (int[] hp : maxHappyInHp) {
            Arrays.fill(hp, EMPTY);
        }
        dp(maxHappyInHp, people, people.size() - 1, MAX_HP);
        return maxHappyInHp[people.size() - 1][MAX_HP];
    }

    private int dp(int[][] maxHappyInHp, List<Person> people, int peopleIdx, int hpIdx) {
        if (hpIdx <= 0) {
            return EMPTY;
        }
        if (peopleIdx < 0) {
            return 0;
        }
        if (maxHappyInHp[peopleIdx][hpIdx] != EMPTY) {
            return maxHappyInHp[peopleIdx][hpIdx];
        }
        int lostHp = people.get(peopleIdx).getLostHp();
        int happy = people.get(peopleIdx).getHappy();
        maxHappyInHp[peopleIdx][hpIdx] = Math.max(
                dp(maxHappyInHp, people, peopleIdx - 1, hpIdx - lostHp) + happy,
                dp(maxHappyInHp, people, peopleIdx - 1, hpIdx)
        );
        return maxHappyInHp[peopleIdx][hpIdx];
    }
}
