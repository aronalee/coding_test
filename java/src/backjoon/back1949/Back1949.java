// prob: https://www.acmicpc.net/problem/1949

package backjoon.back1949;

import java.util.List;

public class Back1949 {
    private final List<Integer> towns;
    private final List<List<Integer>> tree;
    private int[][] memoization;

    public Back1949(List<Integer> towns, List<List<Integer>> tree) {
        this.towns = towns;
        this.tree = tree;
    }

    public int sumGoodTownPeople() {
        int root = 0;
        memoization = new int[towns.size()][2];
        fillMemoization(root, new boolean[towns.size()]);
        return Math.max(memoization[root][0], memoization[root][1]);
    }

    private void fillMemoization(int town, boolean[] visited) {
        visited[town] = true;
        memoization[town][1] = towns.get(town);
        memoization[town][0] = 0;
        for (Integer nextTown : tree.get(town)) {
            if (visited[nextTown]) {
                continue;
            }
            fillMemoization(nextTown, visited);
            memoization[town][0] += Math.max(memoization[nextTown][0], memoization[nextTown][1]);
            memoization[town][1] += memoization[nextTown][0];
        }
    }


}
