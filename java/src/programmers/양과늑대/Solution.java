// prob: https://school.programmers.co.kr/learn/courses/30/lessons/92343

package programmers.양과늑대;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private final List<List<Integer>> adjList = new ArrayList<>();
    private int[] info;
    private int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        initAdjList(info, edges);
        List<Integer> nextVisit = new LinkedList<>(adjList.get(0));
        dfs(new Status(1, 0), nextVisit);
        return maxSheep;
    }

    private void initAdjList(final int[] info, final int[][] edges) {
        for (final int i : info) {
            adjList.add(new ArrayList<>());
        }
        for (final int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            adjList.get(src).add(dst);
        }
    }

    private void dfs(Status status, List<Integer> nextVisit) {
        maxSheep = Math.max(maxSheep, status.sheeps);
        for (final Integer next : nextVisit) {
            Status nextStatus = status.getStatusOfAddingWolf();
            if (info[next] == 0) {
                nextStatus = status.getStatusOfAddingSheep();
            }
            if (nextStatus.sheeps <= nextStatus.wolfs) {
                continue;
            }
            dfs(nextStatus, copyAndAddNextVisit(nextVisit, next));
        }
    }

    private List<Integer> copyAndAddNextVisit(List<Integer> notVisitedList, int id) {
        List<Integer> nextVisitList = new LinkedList<>();
        for (final Integer notVisited : notVisitedList) {
            if (notVisited == id) {
                continue;
            }
            nextVisitList.add(notVisited);
        }
        nextVisitList.addAll(adjList.get(id));
        return nextVisitList;
    }

    private static class Status {

        private final int sheeps;
        private final int wolfs;

        public Status(final int sheeps, final int wolfs) {
            this.sheeps = sheeps;
            this.wolfs = wolfs;
        }

        public Status getStatusOfAddingSheep() {
            return new Status(this.sheeps + 1, this.wolfs);
        }

        public Status getStatusOfAddingWolf() {
            return new Status(this.sheeps, this.wolfs + 1);
        }
    }
}
