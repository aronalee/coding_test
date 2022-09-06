// prob: https://www.acmicpc.net/problem/1912

package back1912;

import java.io.*;
import java.util.Arrays;

class Back1912 {
    int[] memoization;
    int[] array;

    public int recurrsion(int idx) {
        if (idx == this.array.length - 1)
            this.memoization[idx] = this.array[idx];
        if (this.memoization[idx] != Integer.MIN_VALUE)
            return this.memoization[idx];
        this.memoization[idx] = Integer.max(recurrsion(idx + 1) + this.array[idx], this.array[idx]);
        return this.memoization[idx];
    }

    public int getMaxSum() {
        recurrsion(0);
        return Arrays.stream(this.memoization).max().orElseThrow();
    }

    public Back1912(String[] array) {
        this.array = Arrays.stream(array).mapToInt((Integer::parseInt)).toArray();
        this.memoization = Arrays.stream(this.array).map(v -> Integer.MIN_VALUE).toArray();
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        reader.readLine();
        Back1912 back1912 = new Back1912(reader.readLine().split(" "));
        writer.write(String.format("%d", back1912.getMaxSum()));
        writer.flush();
    }
}