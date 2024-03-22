// prob: https://www.acmicpc.net/problem/21275

package backjoon.back21275;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<List<Character>> numbersOfNDigit = Arrays.stream(reader.readLine().split(" "))
                .map(String::chars)
                .map(array -> array.mapToObj(e -> (char) e).collect(Collectors.toList()))
                .collect(Collectors.toList());
        List<Character> numberOfADigit = numbersOfNDigit.get(0);
        List<Character> numberOfBDigit = numbersOfNDigit.get(1);
        Back21275 back21275 = new Back21275(numberOfADigit, numberOfBDigit);
        try {
            long commonNumber = back21275.computeCommonNumber();
            int digitOfA = back21275.getDigitOfA();
            int digitOfB = back21275.getDigitOfB();
            writer.write(commonNumber + " " + digitOfA + " " + digitOfB);
        } catch (IllegalCallerException e) {
            if (e.getMessage().equals("not found common number")) {
                writer.write("Impossible");
            } else {
                writer.write("Multiple");
            }
        }
        writer.flush();
    }
}
