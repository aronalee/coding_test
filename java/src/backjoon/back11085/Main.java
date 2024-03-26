// prob: https://www.acmicpc.net/problem/11085

package backjoon.back11085;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int p = Integer.parseInt(inputs[0]);
        int w = Integer.parseInt(inputs[1]);
        inputs = reader.readLine().split(" ");
        int backCapital = Integer.parseInt(inputs[0]);
        int cubeCapital = Integer.parseInt(inputs[1]);
        List<Edge> edges = readEdges(w);
        edges.sort((o1, o2) -> o2.getWidth() - o1.getWidth());
        Back11085 back11085 = new Back11085(edges);
        int widthMax = back11085.findMaxWidth(p, backCapital, cubeCapital);
        writer.write(widthMax + "\n");
        writer.flush();
    }

    private static List<Edge> readEdges(int w) throws IOException {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            String[] inputs = reader.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int width = Integer.parseInt(inputs[2]);
            edges.add(new Edge(from, to, width));
        }
        return edges;
    }

}
