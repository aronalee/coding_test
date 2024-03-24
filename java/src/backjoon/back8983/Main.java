// prob: https://www.acmicpc.net/problem/8983

package backjoon.back8983;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int _spotOfShootCount = Integer.parseInt(input[0]);
        int spotOfAnimalCount = Integer.parseInt(input[1]);
        int shootOfBoundary = Integer.parseInt(input[2]);
        List<Point> spotsOfShoot = Arrays.stream(reader.readLine().split(" "))
                .map(s -> Point.of(0, Integer.parseInt(s))).collect(Collectors.toList());
        List<Point> spotsOfAnimals = new LinkedList<>();
        for (int i = 0; i < spotOfAnimalCount; i++) {
            String[] animal = reader.readLine().split(" ");
            int x = Integer.parseInt(animal[0]);
            int y = Integer.parseInt(animal[1]);
            spotsOfAnimals.add(Point.of(y, x));
        }
        Back8983 back8983 = new Back8983(spotsOfShoot, spotsOfAnimals, shootOfBoundary);
        int shootAnimalsCount = back8983.computeShootAnimals();
        writer.write(shootAnimalsCount + "\n");
        writer.flush();
    }
}
