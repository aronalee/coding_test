package backjoon.back1976;

import java.io.*;
import java.util.Arrays;

// union-find
public class Main2 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] adjMatrix;

    private static int find(int[] routes, int k) {
        if (routes[k] == k)
            return k;
        return routes[k] = find(routes, routes[k]);
    }

    private static void union(int[] routes, int x, int y) {
        int rootX = find(routes, x);
        int rootY = find(routes, y);
        if (rootX != rootY) {
            int root = Math.min(rootX, rootY);
            int child = Math.max(rootX, rootY);
            routes[child] = root;
        }
    }

    private static void union_find(int[] routes) {
        for (int src = 1; src < adjMatrix.length; src++) {
            for (int dst = 1; dst < adjMatrix[src].length; dst++) {
                if (src == dst || adjMatrix[src][dst] == 0) {
                    continue;
                }
                union(routes, src, dst);
            }
        }
    }

    private static boolean checkVisitedAll(int[] routes, int[] plans) {
        boolean visitedAll = true;
        int root = find(routes, plans[0]);
        for (int i = 1; i < plans.length; i++) {
            if (root != find(routes, plans[i])) {
                visitedAll = false;
                break;
            }
        }
        return visitedAll;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        adjMatrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = reader.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                adjMatrix[i][j + 1] = Integer.parseInt(tmp[j]);
            }
        }
        String[] tmp = reader.readLine().split(" ");
        int[] plans = new int[m];
        for (int i = 0; i < tmp.length; i++) {
            plans[i] = Integer.parseInt(tmp[i]);
        }
        int[] routes = new int[n + 1];
        Arrays.setAll(routes, p -> p);
        union_find(routes);
        writer.write(checkVisitedAll(routes, plans) ? "YES" : "NO");
        writer.flush();
    }
}
