// prob: https://school.programmers.co.kr/learn/courses/30/lessons/43164

package programmers.여행경로;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public String[] solution(String[][] tickets) {

        Map<String, List<String>> adjMaps = new HashMap<>();
        for (final String[] ticket : tickets) {
            String src = ticket[0];
            String dst = ticket[1];
            if (!adjMaps.containsKey(src)) {
                adjMaps.put(src, new LinkedList<>());
            }
            adjMaps.get(src).add(dst);
        }
        return bfs(adjMaps).toArray(new String[0]);
    }

    private List<String> bfs(final Map<String, List<String>> adjMaps) {
        Queue<Node> queue = new LinkedList<>();
        Map<String, List<String>> tickets = new HashMap<>();
        for (final String key : adjMaps.keySet()) {
            tickets.put(key, new LinkedList<>(adjMaps.get(key)));
        }
        queue.add(new Node("ICN", List.of("ICN"), tickets));
        List<String> answerRoute = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.tickets.isEmpty()) {
                answerRoute = updateRoute(answerRoute, now);
                continue;
            }
            if (!now.tickets.containsKey(now.city)) {
                continue;
            }
            for (final String city : now.tickets.get(now.city)) {
                addNode(queue, now, city);
            }
        }
        return answerRoute;
    }

    private List<String> updateRoute(List<String> answerRoute, final Node now) {
        if (answerRoute.isEmpty()) {
            return now.route;
        }
        for (int i = 0; i < now.route.size(); i++) {
            if (answerRoute.get(i).compareTo(now.route.get(i)) < 0) {
                break;
            }
            if (answerRoute.get(i).compareTo(now.route.get(i)) > 0) {
                return now.route;
            }
        }
        return answerRoute;
    }

    private void addNode(final Queue<Node> queue, final Node now, final String city) {
        List<String> nextRoutes = new LinkedList<>(now.route);
        nextRoutes.add(city);
        Map<String, List<String>> nextTickets = new HashMap<>();
        for (final String key : now.tickets.keySet()) {
            nextTickets.put(key, new LinkedList<>(now.tickets.get(key)));
        }
        nextTickets.get(now.city).remove(city);
        if (nextTickets.get(now.city).size() == 0) {
            nextTickets.remove(now.city);
        }
        queue.add(new Node(city, nextRoutes, nextTickets));
    }

    private static class Node {

        private final String city;
        private final List<String> route;
        private final Map<String, List<String>> tickets;

        public Node(final String city, final List<String> route,
            final Map<String, List<String>> tickets) {
            this.city = city;
            this.route = route;
            this.tickets = tickets;
        }
    }
}
