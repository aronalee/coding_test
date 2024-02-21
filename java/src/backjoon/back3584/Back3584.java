// prob: https://www.acmicpc.net/problem/3584

package backjoon.back3584;

import java.util.Arrays;
import java.util.List;

public class Back3584 {
    private static final int EMPTY = Integer.MAX_VALUE / 2;

    public int findNearestCommonAnscestor(List<List<Integer>> adjList, int node1, int node2) {
        int[] depthOfNode1 = createDepths(adjList, node1);
        int[] depthOfNode2 = createDepths(adjList, node2);
        int ancestor = 0;
        for (int i = 0; i < depthOfNode1.length; i++) {
            if (depthOfNode1[i] == EMPTY) {
                continue;
            }
            if (depthOfNode1[i] + depthOfNode2[i] < depthOfNode1[ancestor] + depthOfNode2[ancestor]) {
                ancestor = i;
            }
        }
        return ancestor;
    }

    private int[] createDepths(List<List<Integer>> adjList, int node) {
        int[] depths = new int[adjList.size() + 1];
        Arrays.fill(depths, EMPTY);
        depths[node] = 0;
        dfs(depths, adjList, node, 0);
        return depths;
    }

    private void dfs(int[] depths, List<List<Integer>> adjList, int node, int depth) {
        depths[node] = depth;
        if (adjList.get(node).isEmpty()) {
            return;
        }
        adjList.get(node).forEach(child -> dfs(depths, adjList, child, depth + 1));
    }
}
