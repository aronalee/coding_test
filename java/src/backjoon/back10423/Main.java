// prob: https://www.acmicpc.net/problem/10423

package backjoon.back10423;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int totalCities = Integer.parseInt(input[0]);
        int totalCables = Integer.parseInt(input[1]);
        int totalPowerPlants = Integer.parseInt(input[2]);
        input = reader.readLine().split(" ");
        List<Integer> powerPlantsCities = new ArrayList<>();
        for (int i = 0; i < totalPowerPlants; i++) {
            powerPlantsCities.add(Integer.parseInt(input[i]) - 1);
        }
        List<Cable> cables = new ArrayList<>();
        for (int i = 0; i < totalCables; i++) {
            input = reader.readLine().split(" ");
            int city1 = Integer.parseInt(input[0]) - 1;
            int city2 = Integer.parseInt(input[1]) - 1;
            int weight = Integer.parseInt(input[2]);
            cables.add(Cable.of(city1, city2, weight));
        }
        Back10423 back10423 = new Back10423(totalCities, powerPlantsCities, cables);
        int result = back10423.findMinCablesLength();
        writer.write(result + "\n");
        writer.flush();
    }
}
