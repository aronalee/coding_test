// prob: https://www.acmicpc.net/problem/11047

package backjoon.back11047;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int getMinCountCoins(int[] coins, int goalWeight) {
        int idx = coins.length - 1;
        int count = 0;
        while (goalWeight > 0) {
            count += goalWeight / coins[idx];
            goalWeight %= coins[idx];
            idx--;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }
        writer.write(getMinCountCoins(coins, k) + "\n");
        writer.flush();
    }
}
