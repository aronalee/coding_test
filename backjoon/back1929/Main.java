// prob: https://www.acmicpc.net/problem/1929

package back1929;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class Back1929 {
    private int start = 0;
    private int end = 0;

    public Back1929(int[] info) {
        this.start = info[0];
        this.end = info[1];
    }

    public Integer[] getPrimes() {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= this.end; i++) {
            if (isPrime[i]) {
                if (i >= this.start)
                    answer.add(i);
                for (int j = i + i; j <= this.end; j += i)
                    isPrime[j] = false;
            }
        }
        return answer.toArray(new Integer[0]);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Back1929 back1929 = new Back1929(
                Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray());
        Integer[] primes = back1929.getPrimes();
        for (Integer number :
                primes) {
            writer.write(number + "\n");
        }
        writer.flush();
    }
}
