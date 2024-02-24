// prob: https://www.acmicpc.net/problem/20950

package backjoon.back20950;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalColors = Integer.parseInt(reader.readLine());
        List<Colour> colours = new ArrayList<>();
        for (int i = 0; i < totalColors; i++) {
            colours.add(readColour());
        }
        Colour goalColour = readColour();
        Back20950 back20950 = new Back20950();
        Colour colour = back20950.findClosestColour(colours, goalColour);
        int result = back20950.computeDifference(colour, goalColour);
        writer.write(result + "\n");
        writer.flush();
    }

    private static Colour readColour() throws IOException {
        String[] inputColor = reader.readLine().split(" ");
        int red = Integer.parseInt(inputColor[0]);
        int green = Integer.parseInt(inputColor[1]);
        int blue = Integer.parseInt(inputColor[2]);
        return Colour.of(red, green, blue);
    }
}
