// prob: https://www.acmicpc.net/problem/17472

package backjoon.back17472;

import java.io.*;
import java.util.*;


class Edge {
    private final Integer[] src;
    private final Integer[] dst;
    private final int distance;

    public Edge(Integer[] src, Integer[] dst, int distance) {
        this.src = src;
        this.dst = dst;
        this.distance = distance;
    }

    public Integer[] getSrc() {
        return src;
    }

    public Integer[] getDst() {
        return dst;
    }

    public int getDistance() {
        return distance;
    }
}

class Back17472 {
    private static final int[][] distances = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private final int[][] map;
    private final int maxY;
    private final int maxX;
    private int[] parents;

    public Back17472(int[][] map, int maxY, int maxX) {
        this.map = map;
        this.maxY = maxY;
        this.maxX = maxX;
    }

    private boolean checkInMap(Integer[] point) {
        int moveY = point[0];
        int moveX = point[1];
        return moveY >= 0 && moveY < maxY && moveX >= 0 && moveX < maxX;
    }

    private List<Integer[]> fillInLandNo(int landNo, Integer[] src, boolean[][] visited) {
        List<Integer[]> land = new LinkedList<>();
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(src);
        visited[src[0]][src[1]] = true;
        map[src[0]][src[1]] = landNo;
        while (!queue.isEmpty()) {
            Integer[] now = queue.remove();
            land.add(now);
            for (int[] distance : distances) {
                int moveY = distance[0] + now[0];
                int moveX = distance[1] + now[1];
                Integer[] next = new Integer[]{moveY, moveX};
                if (!checkInMap(next) || visited[moveY][moveX] || map[moveY][moveX] == 0)
                    continue;
                visited[moveY][moveX] = true;
                map[moveY][moveX] = landNo;
                queue.add(new Integer[]{moveY, moveX});
            }
        }
        return land;
    }

    public List<List<Integer[]>> findLands() {
        boolean[][] visited = new boolean[maxY][maxX];
        List<List<Integer[]>> lands = new LinkedList<>();
        int landNo = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0 || visited[i][j])
                    continue;
                lands.add(fillInLandNo(landNo, new Integer[]{i, j}, visited));
                landNo++;
            }
        }
        return lands;
    }

    public List<Edge> creatEdges(List<List<Integer[]>> lands) {
        List<Edge> list = new LinkedList<>();
        for (List<Integer[]> land : lands) {
            for (Integer[] now : land) {
                for (int[] distance : distances) {
                    int count = 0;
                    Integer[] next = new Integer[]{distance[0] + now[0], distance[1] + now[1]};
                    while (checkInMap(next) && map[next[0]][next[1]] == 0) {
                        next[0] += distance[0];
                        next[1] += distance[1];
                        count++;
                    }
                    if (count < 2 || !checkInMap(next))
                        continue;
                    list.add(new Edge(now, next, count));
                }
            }
        }
        return list;
    }

    private int find(int node) {
        if (parents[node] == node)
            return node;
        return parents[node] = find(parents[node]);
    }

    private void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
            parents[node1] = node2;
        }
    }

    public List<Edge> createMST(int countLands, List<Edge> edges) {
        parents = new int[countLands + 1];
        Arrays.setAll(parents, v -> v);
        List<Edge> mst = new LinkedList<>();
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
        queue.addAll(edges);
        int useEdge = 0;
        while (useEdge < countLands - 1 && !queue.isEmpty()) {
            Edge now = queue.remove();
            Integer[] src = now.getSrc();
            Integer[] dst = now.getDst();
            if (find(map[src[0]][src[1]]) == find(map[dst[0]][dst[1]])) {
                continue;
            }
            union(map[src[0]][src[1]], map[dst[0]][dst[1]]);
            mst.add(now);
            useEdge++;
        }
        int parent = find(1);
        for (int i = 1; i < parents.length; i++) {
            if (parent != find(i)) {
                mst.clear();
                break;
            }
        }
        return mst;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            tmp = reader.readLine().split(" ");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        Back17472 back17472 = new Back17472(map, n, m);
        List<List<Integer[]>> lands = back17472.findLands();
        List<Edge> edges = back17472.creatEdges(lands);
        List<Edge> mst = back17472.createMST(lands.size(), edges);
        int result = -1;
        if (mst.size() > 0) {
            result = 0;
            for (Edge edge : mst) {
                result += edge.getDistance();
            }
        }
        writer.write(result + "");
        writer.flush();
    }
}
