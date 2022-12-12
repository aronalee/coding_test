// prob: https://www.acmicpc.net/problem/1027

package backjoon.back1027;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Back1027 {

    private final int n;
    private final List<Integer> buildings;

    Back1027(final int n, final List<Integer> buildings) {
        this.n = n;
        this.buildings = buildings;
    }

    public int getAnswer() {
        List<Integer> counts = new ArrayList<>(n);
        List<boolean[]> isViewByBuildingNo = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            boolean[] isViewByBuilding = new boolean[n];
            Arrays.fill(isViewByBuilding, true);
            isViewByBuildingNo.add(isViewByBuilding);
        }
        for (int start = 0; start < buildings.size(); start++) {
            fillInIsViewBuildings(start, isViewByBuildingNo);
            int count = countIsViews(start, isViewByBuildingNo.get(start));
            counts.add(count);
        }
        return getMaxCount(counts);
    }

    private void fillInIsViewBuildings(final int start, List<boolean[]> isViewByBuildings) {
        long[] startPoint = new long[]{start, buildings.get(start)};
        for (int end = start + 1; end < buildings.size(); end++) {
            long[] endPoint = new long[]{end, buildings.get(end)};
            for (int i = start + 1; i < end; i++) {
                long[] nextPoint = new long[]{i, buildings.get(i)};
                if (isNotHideBuilding(startPoint, nextPoint, endPoint)) {
                    continue;
                }
                isViewByBuildings.get(start)[end] = false;
                isViewByBuildings.get(end)[start] = false;
                break;
            }
        }
    }

    private boolean isNotHideBuilding(final long[] startPoint, final long[] nextPoint,
        final long[] endPoint) {
        long ccw = getCCW(startPoint, nextPoint, endPoint);
        return ccw > 0;
    }

    private long getCCW(long[] point1, long[] point2, long[] point3) {
        return
            ((point1[0] * point2[1]) + (point2[0] * point3[1]) + (point3[0] * point1[1]))
                - ((point2[0] * point1[1]) + (point3[0] * point2[1]) + (point1[0] * point3[1]));
    }

    private int countIsViews(final int start, final boolean[] isViews) {
        int count = 0;
        for (int i = 0; i < isViews.length; i++) {
            if (i == start) {
                continue;
            }
            if (isViews[i]) {
                count++;
            }
        }
        return count;
    }

    private int getMaxCount(final List<Integer> isViewCounts) {
        int maxCount = 0;
        for (final Integer isViewCount : isViewCounts) {
            maxCount = Math.max(maxCount, isViewCount);
        }
        return maxCount;
    }
}

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String line = reader.readLine();
        List<Integer> buildings = new ArrayList<>();
        for (final String building : line.split(" ")) {
            buildings.add(Integer.parseInt(building));
        }
        Back1027 back1027 = new Back1027(n, buildings);
        int answer = back1027.getAnswer();
        writer.write(answer + "\n");
        writer.flush();
    }
}
