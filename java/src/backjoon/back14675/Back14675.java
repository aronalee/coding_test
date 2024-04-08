// prob: https://www.acmicpc.net/problem/14675

package backjoon.back14675;

import java.util.*;

public class Back14675 {
    private final List<List<Integer>> adjList;
    private final int nodeTotal;
    private Set<Integer> leafs;

    public Back14675(List<List<Integer>> adjList, int nodeTotal) {
        this.adjList = adjList;
        this.nodeTotal = nodeTotal;
    }

    public boolean isCutVertex(int excludeNode) {
        return !isLeafNode(excludeNode);
    }

    private boolean isLeafNode(int excludeNode) {
        if (this.leafs == null) {
            this.leafs = createLeafs();
        }
        return this.leafs.contains(excludeNode);
    }


    private Set<Integer> createLeafs() {
        Set<Integer> leafs = new HashSet<>();
        boolean[] visited = new boolean[nodeTotal + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (adjList.get(now).size() == 1) {
                leafs.add(now);
            }
            for (int next : adjList.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
            }
        }
        return leafs;
    }

    // always bridge
    public boolean isBridge(int excludeEdgeId) {
        return true;
    }


}
