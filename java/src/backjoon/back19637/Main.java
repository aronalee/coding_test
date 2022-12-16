// prob: https://www.acmicpc.net/problem/19637

package backjoon.back19637;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<Integer> players = new ArrayList<>();
        Map<Integer, String> scoreToStatus = new HashMap<>();
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        List<Integer> scores = new ArrayList<>();
        readStatusAndScores(scoreToStatus, scores, n);
        readPlayers(players, m);
        Back19637 back19637 = new Back19637(players, scoreToStatus, scores);
        List<String> statues = back19637.createStatuses();
        for (final String statue : statues) {
            writer.write(statue + "\n");
        }
        writer.flush();
    }

    private static void readStatusAndScores(final Map<Integer, String> scoreToStatus,
        final List<Integer> scores, final int n)
        throws IOException {
        String[] splitLine;
        for (int i = 0; i < n; i++) {
            splitLine = reader.readLine().split(" ");
            String status = splitLine[0];
            int score = Integer.parseInt(splitLine[1]);
            if (scoreToStatus.containsKey(score)) {
                continue;
            }
            scores.add(score);
            scoreToStatus.put(score, status);
        }
    }

    private static void readPlayers(final List<Integer> players, final int m) throws IOException {
        for (int i = 0; i < m; i++) {
            players.add(Integer.parseInt(reader.readLine()));
        }
    }
}
