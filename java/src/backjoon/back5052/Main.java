// prob: https://www.acmicpc.net/problem/5052

package backjoon.back5052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Trie {

    private final Trie[] next = new Trie[10];
    private boolean isEnd;

    public void addPhone(int[] phone) {
        Trie now = this;
        for (int number : phone) {
            if (now.next[number] == null) {
                now.next[number] = new Trie();
            }
            now = now.next[number];
        }
        now.isEnd = true;
    }

    public boolean havePrefixPhone(int[] phone) {
        Trie now = this;
        for (int i = 0; i < phone.length - 1; i++) {
            int number = phone[i];
            if (now.next[number].isEnd) {
                return true;
            }
            now = now.next[number];
        }
        return false;
    }
}

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < cases; i++) {
            int numberLength = Integer.parseInt(reader.readLine());
            List<int[]> phones = new ArrayList<>(numberLength);
            for (int j = 0; j < numberLength; j++) {
                String[] splitLine = reader.readLine().split("");
                int[] phone = new int[splitLine.length];
                for (int k = 0; k < phone.length; k++) {
                    phone[k] = Integer.parseInt(splitLine[k]);
                }
                phones.add(phone);
            }
            boolean isConsistent = checkConsistent(phones);
            if (isConsistent) {
                writer.write("YES\n");
                continue;
            }
            writer.write("NO\n");
        }
        writer.flush();
    }

    private static boolean checkConsistent(final List<int[]> phones) {
        Trie trie = createTrie(phones);
        for (final int[] phone : phones) {
            if (!trie.havePrefixPhone(phone)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static Trie createTrie(final List<int[]> phones) {
        Trie trie = new Trie();
        for (final int[] phone : phones) {
            trie.addPhone(phone);
        }
        return trie;
    }
}
