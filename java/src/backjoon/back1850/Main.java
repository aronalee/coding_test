// prob: https://www.acmicpc.net/problem/1850

package backjoon.back1850;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static long getGCD(long x, long y) {
        long n1 = Math.max(x, y);
        long n2 = Math.min(x, y);
        long tmp = n1 % n2;
        while (tmp != 0) {
            n1 = n2;
            n2 = tmp;
            tmp = n1 % n2;
        }
        return n2;
    }

    private static String convertOnes(long number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append('1');
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        long n1 = Long.parseLong(tmp[0]);
        long n2 = Long.parseLong(tmp[1]);
        long gcd = getGCD(n1, n2);
        String result = convertOnes(gcd);
        writer.write(result);
        writer.flush();
    }
}
