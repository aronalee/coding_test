// prob: https://www.acmicpc.net/problem/2343

package backjoon.back2343;

import java.io.*;

class Back2343 {
    private final int maxSize;
    private final int minSize;
    private final int[] courses;

    public Back2343(int maxSize, int minSize, int[] courses) {
        this.maxSize = maxSize;
        this.minSize = minSize;
        this.courses = courses;
    }

    private int divideBySize(int size) {
        int count = 1;
        int sum = 0;
        for (int course : courses) {
            if (sum + course > size) {
                count++;
                sum = 0;
            }
            sum += course;
        }
        return count;
    }

    public int getMinBlueraySize(int maxCount) {
        int start = minSize;
        int end = maxSize;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int countBlueray = divideBySize(mid);
            if (countBlueray > maxCount) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int getMaxValue(int[] array) {
        int maxValue = 0;
        for (int value : array) {
            maxValue = Math.max(value, maxValue);
        }
        return maxValue;
    }

    private static int sum(int[] array) {
        int value = 0;
        for (int v : array) {
            value += v;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[] courses = new int[n];
        int i = 0;
        for (String s : reader.readLine().split(" ")) {
            courses[i] = Integer.parseInt(s);
            i++;
        }
        Back2343 back2343 = new Back2343(sum(courses), getMaxValue(courses), courses);
        int size = back2343.getMinBlueraySize(m);
        writer.write(size + "\n");
        writer.flush();
    }
}
