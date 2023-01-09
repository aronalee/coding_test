// prob: https://school.programmers.co.kr/learn/courses/30/lessons/118669

package programmers.등산코스_정하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

    private final Set<Integer> gatesSet = new HashSet<>();
    private final Set<Integer> summitSet = new HashSet<>();
    private final List<List<int[]>> adjList = new ArrayList<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        initAttrs(n, paths, gates, summits);
        return dijstraStartGates(gates);
    }

    private void initAttrs(int n, int[][] paths, int[] gates, int[] summits) {
        for (int gate1 : gates) {
            gatesSet.add(gate1);
        }
        for (int summit1 : summits) {
            summitSet.add(summit1);
        }
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            int node1 = path[0];
            int node2 = path[1];
            int time = path[2];
            adjList.get(node1).add(new int[]{node2, time});
            adjList.get(node2).add(new int[]{node1, time});
        }
    }

    private int[] dijstraStartGates(final int[] gates) {
        int[] intensities = new int[adjList.size()];
        boolean[] visited = new boolean[adjList.size()];
        Arrays.fill(intensities, Integer.MAX_VALUE);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(v -> v[1]));
        for (int gate : gates) {
            intensities[gate] = 0;
            queue.add(new int[]{gate, 0});
        }
        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int nowId = now[0];
            int nowIntensity = now[1];
            visited[nowId] = true;
            intensities[nowId] = Math.min(intensities[nowId], nowIntensity);
            if (summitSet.contains(nowId)) {
                continue;
            }
            for (int[] next : adjList.get(nowId)) {
                int nextId = next[0];
                int nextIntensity = next[1];
                if (visited[nextId] || gatesSet.contains(nextId)) {
                    continue;
                }
                queue.add(new int[]{nextId, Math.max(nowIntensity, nextIntensity)});
            }
        }
        return getMinIntensityInfo(intensities);
    }

    private int[] getMinIntensityInfo(int[] intensities) {
        int minId = 0;
        int minIntensity = Integer.MAX_VALUE;
        for (int id = intensities.length - 1; id >= 0; id--) {
            if (!summitSet.contains(id)) {
                continue;
            }
            int intensity = intensities[id];
            if (minIntensity >= intensity) {
                minIntensity = intensity;
                minId = id;
            }
        }
        return new int[]{minId, minIntensity};
    }

}
