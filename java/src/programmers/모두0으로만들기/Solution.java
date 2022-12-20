// prob: https://school.programmers.co.kr/learn/courses/30/lessons/76503

package programmers.모두0으로만들기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tree {

    private final List<List<Integer>> adjList;
    private final List<Node> nodes;
    private long countOps = 0;

    public Tree(final List<List<Integer>> adjList, final List<Node> nodes) {
        this.adjList = adjList;
        this.nodes = nodes;
    }

    public long countMinOp() {
        if (!isAddAllZero()) {
            return -1;
        }
        countOps = 0;
        List<Node> leafs = getLeafs();
        bfs(leafs);
        return countOps;
    }

    private boolean isAddAllZero() {
        long sum = 0;
        for (final Node node : nodes) {
            sum += node.weight;
        }
        return sum == 0;
    }

    private List<Node> getLeafs() {
        List<Node> leafs = new ArrayList<>();
        for (final Node node : nodes) {
            if (node.isTop()) {
                leafs.add(node);
            }
        }
        return leafs;
    }

    private void bfs(List<Node> leafs) {
        Queue<Node> queue = new LinkedList<>(leafs);
        boolean[] visited = new boolean[nodes.size()];
        while (!queue.isEmpty()) {
            Node child = queue.remove();
            visited[child.id] = true;
            countOps += Math.abs(child.weight);
            for (final Integer parentId : adjList.get(child.id)) {
                if (visited[parentId]) {
                    continue;
                }
                Node parent = nodes.get(parentId);
                parent.upDepth();
                parent.addWeight(child.weight);
                if (parent.isTop()) {
                    queue.add(parent);
                    break;
                }
            }
        }
    }

    static class Node {

        private final int id;
        private long weight;
        private int depth = 0;

        public Node(final int id, final long weight) {
            this.id = id;
            this.weight = weight;
        }

        private void addWeight(final long weight) {
            this.weight += weight;
        }

        public void downDepth() {
            this.depth++;
        }

        public void upDepth() {
            this.depth--;
        }

        public boolean isTop() {
            return depth == 1;
        }
    }

}

public class Solution {

    public long solution(int[] a, int[][] edges) {
        long answer;
        int nodesLength = a.length;
        List<List<Integer>> adjList = createAdjList(edges, nodesLength);
        List<Tree.Node> nodes = createNodes(a, edges);
        Tree tree = new Tree(adjList, nodes);
        answer = tree.countMinOp();
        return answer;
    }

    private List<List<Integer>> createAdjList(final int[][] edges, final int nodesLength) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodesLength; i++) {
            adjList.add(new ArrayList<>());
        }
        for (final int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        return adjList;
    }

    private List<Tree.Node> createNodes(final int[] weights, final int[][] edges) {
        List<Tree.Node> nodes = new ArrayList<>();
        for (int id = 0; id < weights.length; id++) {
            int weight = weights[id];
            nodes.add(new Tree.Node(id, weight));
        }
        for (final int[] edge : edges) {
            Tree.Node node1 = nodes.get(edge[0]);
            Tree.Node node2 = nodes.get(edge[1]);
            node1.downDepth();
            node2.downDepth();
        }
        return nodes;
    }

}
