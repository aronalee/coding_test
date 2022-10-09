// prob: https://www.acmicpc.net/problem/1934

package backjoon.back1934;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int getGCD(int number1, int number2) {
        int maxNum = Math.max(number1, number2);
        number1 = Math.min(number1, number2);
        number2 = maxNum;
        int tmp = number1 % number2;
        while (tmp != 0) {
            tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;
        }
        return number1;
    }

    private static int getLCM(int number1, int number2, int gcd) {
        return (number1 * number2) / gcd;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tmp = reader.readLine().split(" ");
            int number1 = Integer.parseInt(tmp[0]);
            int number2 = Integer.parseInt(tmp[1]);
            int gcd = getGCD(number1, number2);
            writer.write(getLCM(number1, number2, gcd) + "\n");
        }
        writer.flush();
    }
}
