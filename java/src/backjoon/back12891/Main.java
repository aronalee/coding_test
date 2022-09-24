// prob: https://www.acmicpc.net/problem/12891

package backjoon.back12891;

import java.io.*;
import java.util.StringTokenizer;

class Back12891 {
    private final int[] condition;
    private final char[] dna;
    private final int subStrLength;

    public Back12891(int[] condition, char[] dna, int subStrLength) {
        this.condition = condition;
        this.dna = dna;
        this.subStrLength = subStrLength;
    }

    private void add(int[] subStrCondition, int ch) {
        int idx = 0;
        switch (ch) {
            case 'A':
                idx = 0;
                break;
            case 'C':
                idx = 1;
                break;
            case 'G':
                idx = 2;
                break;
            case 'T':
                idx = 3;
                break;
        }
        subStrCondition[idx]++;
    }

    private void remove(int[] subStrCondition, int ch) {
        int idx = 0;
        switch (ch) {
            case 'A':
                idx = 0;
                break;
            case 'C':
                idx = 1;
                break;
            case 'G':
                idx = 2;
                break;
            case 'T':
                idx = 3;
                break;
        }
        subStrCondition[idx]--;
    }

    private int[] initSubstrCondition() {
        int[] subSetCondition = new int[4];
        for (int i = 0; i < subStrLength; i++) {
            add(subSetCondition, dna[i]);
        }
        return subSetCondition;
    }

    private boolean matchCondition(int[] subStringCondition) {
        int count = 0;
        for (int i = 0; i < this.condition.length; i++) {
            count += subStringCondition[i] >= this.condition[i] ? 1 : 0;
        }
        return count == this.condition.length;
    }

    public int countSubStr() {
        int[] subStrCondition = this.initSubstrCondition();
        int count = matchCondition(subStrCondition) ? 1 : 0;
        for (int i = subStrLength; i < this.dna.length; i++) {
            remove(subStrCondition, dna[i - subStrLength]);
            add(subStrCondition, dna[i]);
            if (matchCondition(subStrCondition))
                count++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] set = reader.readLine().split(" ");
        int subStrLength = Integer.parseInt(set[1]);
        char[] dna = reader.readLine().toCharArray();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] condition = new int[4];
        for (int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Back12891 back12891 = new Back12891(condition, dna, subStrLength);
        int count = back12891.countSubStr();
        writer.write(count + "");
        writer.flush();
    }
}
