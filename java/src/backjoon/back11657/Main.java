// prob: https://www.acmicpc.net/problem/11657

package backjoon.back11657;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    private final int src;
    private final int dst;
    private final int time;

    public Edge(int src, int dst, int time) {
        this.src = src;
        this.dst = dst;
        this.time = time;
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }

    public int getTime() {
        return time;
    }
}

class CycleException extends Exception {

}

class Back11657 {
    private final Edge[] edges;
    private final int countNode;

    public Back11657(Edge[] edges, int countNode) {
        this.edges = edges;
        this.countNode = countNode;
    }

    private long[] bellman_ford() throws CycleException {
        long[] times = new long[countNode + 1];
        Arrays.fill(times, Long.MAX_VALUE);
        times[1] = 0;
        for (int i = 1; i < countNode; i++) {
            for (Edge edge : edges) {
                if (times[edge.getSrc()] == Long.MAX_VALUE)
                    continue;
                long subTime = times[edge.getSrc()] + edge.getTime();
                if (times[edge.getDst()] > subTime) {
                    times[edge.getDst()] = subTime;
                }
            }
        }
        for (Edge edge : edges) {
            if (times[edge.getSrc()] == Long.MAX_VALUE) {
                continue;
            }
            if (times[edge.getDst()] > times[edge.getSrc()] + edge.getTime()) {
                throw new CycleException();
            }
        }
        return times;
    }

    public List<Long> getTimes() throws CycleException {
        long[] results = bellman_ford();
        List<Long> list = new ArrayList<>();
        for (int i = 2; i < results.length; i++) {
            list.add((results[i] != Long.MAX_VALUE) ? results[i] : -1);
        }
        return list;
    }
}


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int distance = Integer.parseInt(tmp[2]);
            edges[i] = new Edge(src, dst, distance);
        }
        try {
            Back11657 back11657 = new Back11657(edges, n);
            List<Long> times = back11657.getTimes();
            for (Long time : times) {
                writer.write(time + "\n");
            }
        } catch (CycleException e) {
            writer.write("-1\n");
        }
        writer.flush();
    }
}