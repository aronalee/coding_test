// prob: https://www.acmicpc.net/problem/19585

package backjoon.back19585;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int c = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        Trie colorTrie = new Trie();
        Set<String> nicknameSet = new HashSet<>();
        for (int i = 0; i < c; i++) {
            String color = reader.readLine();
            colorTrie.insert(color);
        }
        for (int i = 0; i < n; i++) {
            String nickname = reader.readLine();
            nicknameSet.add(nickname);
        }
        Back19585 back19585 = new Back19585(colorTrie, nicknameSet);
        int teamNameTotal = Integer.parseInt(reader.readLine());
        for (int i = 0; i < teamNameTotal; i++) {
            String teamName = reader.readLine();
            writer.write(back19585.isWinTeamName(teamName) ? "Yes" : "No");
            writer.write("\n");
        }
        writer.flush();
    }
}
