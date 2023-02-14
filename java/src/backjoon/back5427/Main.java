// prob: https://www.acmicpc.net/problem/5427

package backjoon.back5427;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Back5427 back5427 = new Back5427();
        int totalTestCses = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < totalTestCses; testCase++) {
            String[] splitLine = reader.readLine().split(" ");
            int width = Integer.parseInt(splitLine[0]);
            int height = Integer.parseInt(splitLine[1]);

            BuildingStatus[][] buildingStatuses = new BuildingStatus[height][width];
            List<int[]> burnPoints = new ArrayList<>();
            int[] personPoint = new int[]{0, 0};
            for (int y = 0; y < height; y++) {
                splitLine = reader.readLine().split("");
                for (int x = 0; x < splitLine.length; x++) {
                    switch (splitLine[x]) {
                        case "#": {
                            buildingStatuses[y][x] = BuildingStatus.BLOCK;
                            break;
                        }
                        case "*": {
                            buildingStatuses[y][x] = BuildingStatus.FIRE;
                            burnPoints.add(new int[]{y, x});
                            break;
                        }
                        case "@": {
                            personPoint = new int[]{y, x};
                            buildingStatuses[y][x] = BuildingStatus.PERSON;
                            break;
                        }
                        case ".":
                            buildingStatuses[y][x] = BuildingStatus.EMPTY;
                    }
                }
            }
            int distance = back5427.getMinTime(buildingStatuses, burnPoints, personPoint);
            if (distance == -1) {
                writer.write("IMPOSSIBLE\n");
                continue;
            }
            writer.write(distance + "\n");
        }
        writer.flush();
    }
}
