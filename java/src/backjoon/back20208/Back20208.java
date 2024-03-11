// prob: https://www.acmicpc.net/problem/20208

package backjoon.back20208;

public class Back20208 {

    private final int[][] adjMatrix;

    private final int hpOfFilledMintMilk;
    private int houseId;

    public Back20208(int[][] adjMatrix, int hpOfFilledMintMilk) {
        this.adjMatrix = adjMatrix;
        this.hpOfFilledMintMilk = hpOfFilledMintMilk;
    }

    public int computeMaxCountOfMintMilk(int houseId, int theFirstHp) {
        this.houseId = houseId;
        boolean[] visited = new boolean[adjMatrix.length];
        visited[houseId] = true;
        return dfs(houseId, theFirstHp, visited, 0);
    }

    private int dfs(int nowId, int hp, boolean[] visited, int countOfMintMilk) {
        int maxCountOfMintMilk = 0;
        if (hp >= adjMatrix[nowId][houseId]) {
            maxCountOfMintMilk = Math.max(maxCountOfMintMilk, countOfMintMilk);
        }
        for (int nextId = 0; nextId < adjMatrix.length; nextId++) {
            if (nextId == nowId) {
                continue;
            }
            int nextHp = hp - adjMatrix[nowId][nextId];
            if (visited[nextId] || nextHp < 0) {
                continue;
            }
            visited[nextId] = true;
            maxCountOfMintMilk = Math.max(maxCountOfMintMilk, dfs(nextId, nextHp + hpOfFilledMintMilk, visited, countOfMintMilk + 1));
            visited[nextId] = false;
        }
        return maxCountOfMintMilk;
    }

}
