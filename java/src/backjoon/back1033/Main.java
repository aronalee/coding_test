// prob: https://www.acmicpc.net/problem/1033

package backjoon.back1033;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Node {
    private final int id;
    private final long p;
    private final long q;

    public Node(int id, long p, long q) {
        this.id = id;
        this.p = p;
        this.q = q;
    }

    public int id() {
        return id;
    }

    public long p() {
        return p;
    }

    public long q() {
        return q;
    }
}


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<List<Node>> adjList = new ArrayList<>();

    private static long getGCD(long number1, long number2) {
        long n1 = Math.max(number1, number2);
        long n2 = Math.min(number1, number2);
        long tmp = n1 % n2;
        while (tmp != 0) {
            n1 = n2;
            n2 = tmp;
            tmp = n1 % n2;
        }
        return n2;
    }

    private static long getLCM(long number1, long number2, long gcd) {
        return number1 * number2 / gcd;
    }

    private static void calculateMaterialRates(int node, boolean[] visited, long[] materials) {
        visited[node] = true;
        for (Node child : adjList.get(node)) {
            if (visited[child.id()])
                continue;
            materials[child.id()] = materials[node] * child.q() / child.p();
            calculateMaterialRates(child.id(), visited, materials);
        }
    }

    private static long[] createTotalMaterials(int size, long lcm) {
        long[] materials = new long[size];
        materials[0] = lcm;
        calculateMaterialRates(0, new boolean[size], materials);
        long totalGCD = materials[0];
        for (int i = 1; i < materials.length; i++) {
            totalGCD = getGCD(totalGCD, materials[i]);
        }
        for (int i = 0; i < materials.length; i++) {
            materials[i] /= totalGCD;
        }
        return materials;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        long lcm = 1;
        for (int i = 0; i < n - 1; i++) {
            String[] tmp = reader.readLine().split(" ");
            int material1 = Integer.parseInt(tmp[0]);
            int material2 = Integer.parseInt(tmp[1]);
            int p = Integer.parseInt(tmp[2]);
            int q = Integer.parseInt(tmp[3]);
            adjList.get(material1).add(new Node(material2, p, q));
            adjList.get(material2).add(new Node(material1, q, p));
            lcm *= getLCM(p, q, getGCD(p, q));
        }
        long[] materials = createTotalMaterials(n, lcm);
        for (long material : materials) {
            writer.write(material + " ");
        }
        writer.flush();
    }
}
