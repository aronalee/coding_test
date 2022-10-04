// prob :https://www.acmicpc.net/problem/1920

package backjoon.back1920;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] array;

    private static int binarySearch(int value) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < value) {
                start = mid + 1;
                continue;
            } else if (array[mid] > value) {
                end = mid - 1;
                continue;
            }
            return mid;
        }
        return -1;
    }

    private static boolean existValue(int value) {
        return binarySearch(value) != -1;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        array = new int[n];
        int i = 0;
        for (String s : reader.readLine().split(" ")) {
            array[i] = Integer.parseInt(s);
            i++;
        }
        Arrays.sort(array);
        int m = Integer.parseInt(reader.readLine());
        for (String s : reader.readLine().split(" ")) {
            writer.write(((existValue(Integer.parseInt(s))) ? 1 : 0) + "\n");
        }
        writer.flush();
    }
}
