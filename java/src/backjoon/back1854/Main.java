// prob: https://www.acmicpc.net/problem/1854

package backjoon.back1854;

import java.io.*;
import java.util.*;

class Node {
    private final int id;
    private final int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }
}

class Back1854 {
    private final List<List<Node>> adjList;

    public Back1854(List<List<Node>> adjList) {
        this.adjList = adjList;
    }

    public List<Integer> getKthDistances(int k) {
        List<Queue<Integer>> distances = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            distances.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        queue.add(new Node(1, 0));
        distances.get(1).add(0);
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (Node next : adjList.get(now.getId())) {
                int subDistance = now.getDistance() + next.getDistance();
                Queue<Integer> nextDistances = distances.get(next.getId());
                if (nextDistances.size() >= k && nextDistances.peek() > subDistance) {
                    nextDistances.remove();
                    nextDistances.add(subDistance);
                    queue.add(new Node(next.getId(), subDistance));
                    continue;
                }
                if (nextDistances.size() < k) {
                    distances.get(next.getId()).add(subDistance);
                    queue.add(new Node(next.getId(), subDistance));
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < distances.size(); i++) {
            Queue<Integer> subDistances = distances.get(i);
            if (subDistances.size() != k) {
                answer.add(-1);
                continue;
            }
            answer.add(subDistances.peek());
        }
        return answer;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int distance = Integer.parseInt(tmp[2]);
            adjList.get(src).add(new Node(dst, distance));
        }
        Back1854 back1854 = new Back1854(adjList);
        List<Integer> list = back1854.getKthDistances(k);
        for (Integer number : list) {
            writer.write(number + "\n");
        }
        writer.flush();
    }
}
