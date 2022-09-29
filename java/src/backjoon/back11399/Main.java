// prob: https://www.acmicpc.net/problem/11399

package backjoon.back11399;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int location = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[location] < array[j])
                    location = j;
            }
            int tmp = array[location];
            array[location] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        String[] values = reader.readLine().split(" ");
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }
        insertSort(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] * (i + 1);
        }
        writer.write(sum + "\n");
        writer.flush();
    }
}
