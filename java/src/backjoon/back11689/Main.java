package backjoon.back11689;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(reader.readLine());
        long countCoprime = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                countCoprime -= countCoprime / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            countCoprime -= countCoprime / n;
        }
        writer.write(countCoprime + "\n");
        writer.flush();
    }
}
