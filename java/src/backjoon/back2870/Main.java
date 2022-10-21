// prob: https://www.acmicpc.net/problem/2870
package backjoon.back2870;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\d+");
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            String[] problems = new String[n];
            for (int i = 0; i < n; i++) {
                problems[i] = reader.readLine();
            }
            List<BigInteger> answers = new LinkedList<>();
            for (String problem : problems) {
                Matcher matcher = pattern.matcher(problem);
                while (matcher.find()) {
                    answers.add(new BigInteger(matcher.group()));
                }
            }
            answers.sort(BigInteger::compareTo);
            for (BigInteger answer : answers) {
                writer.write(answer + "\n");
            }
            writer.flush();
        }
    }
}
