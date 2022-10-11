// prob: https://www.acmicpc.net/problem/1043

package backjoon.back1043;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Back1043 {
    private final int[] people;
    private final boolean[] isKownTruth;
    private final List<List<Integer>> parties;

    public Back1043(int[] people, boolean[] isKownTruth, List<List<Integer>> parties) {
        this.people = people;
        this.isKownTruth = isKownTruth;
        this.parties = parties;
    }

    private int find(int person) {
        if (people[person] == person)
            return people[person];
        return people[person] = find(people[person]);
    }

    private void union(int person1, int person2) {
        int root1 = find(person1);
        int root2 = find(person2);
        if (root1 != root2) {
            if (isKownTruth[root1] && !isKownTruth[root2]) {
                people[root2] = root1;
            } else if (!isKownTruth[root1] && isKownTruth[root2]) {
                people[root1] = root2;
            } else {
                int root = Math.min(root2, root1);
                int child = Math.max(root2, root1);
                people[child] = root;
            }
        }
    }

    public void unionAll() {
        for (List<Integer> party : this.parties) {
            for (int i = 1; i < party.size(); i++) {
                union(party.get(i - 1), party.get(i));
            }
        }
    }

    public int countFakeParty() {
        int count = 0;
        for (List<Integer> party : this.parties) {
            count += isKownTruth[this.find(party.get(0))] ? 0 : 1;
        }
        return count;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] people = new int[n + 1];
        Arrays.setAll(people, p -> p);
        boolean[] isKnownTruth = new boolean[n + 1];
        tmp = reader.readLine().split(" ");
        for (int i = 1; i < tmp.length; i++) {
            isKnownTruth[Integer.parseInt(tmp[i])] = true;
        }
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> party = new ArrayList<>();
            tmp = reader.readLine().split(" ");
            for (int j = 1; j < tmp.length; j++) {
                party.add(Integer.parseInt(tmp[j]));
            }
            parties.add(party);
        }
        Back1043 back1043 = new Back1043(people, isKnownTruth, parties);
        back1043.unionAll();
        int result = back1043.countFakeParty();
        writer.write(result + "\n");
        writer.flush();
    }
}
