// prob: https://www.acmicpc.net/problem/20207

package backjoon.back20207;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int scheduleTotal = Integer.parseInt(reader.readLine());
        int[] duplicateScheduleCount = new int[367];
        for (int i = 0; i < scheduleTotal; i++) {
            String[] schedule = reader.readLine().split(" ");
            int start = Integer.parseInt(schedule[0]);
            int end = Integer.parseInt(schedule[1]);
            for (int j = start; j <= end; j++) {
                duplicateScheduleCount[j]++;
            }
        }
        Back20207 back20207 = new Back20207(duplicateScheduleCount);
        int coatingArea = back20207.computeCoatingArea();
        writer.write(coatingArea + "\n");
        writer.flush();
    }

}
