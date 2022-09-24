// prob: https://www.acmicpc.net/problem/1940

package backjoon.back1940;

import java.io.*;
import java.util.StringTokenizer;

class Back1940 {
    private final int cost;
    private final int[] materials;

    public Back1940(int cost, int[] materials) {
        this.cost = cost;
        this.materials = materials;
    }

    public int countArmors() {
        int count = 0;
        boolean[] idArray = new boolean[cost];
        for (int material : materials) {
            if (material >= this.cost)
                continue;
            idArray[material] = true;
        }
        for (int i = 1; i < Math.ceil(idArray.length / 2.0); i++) {
            if (idArray[i] && idArray[this.cost - i])
                count++;
        }
        return count;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int countMaterial = Integer.parseInt(reader.readLine());
        int cost = Integer.parseInt(reader.readLine());
        int[] materials = new int[countMaterial];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < countMaterial; i++)
            materials[i] = Integer.parseInt(tokenizer.nextToken());
        Back1940 back1940 = new Back1940(cost, materials);
        int count = back1940.countArmors();
        writer.write("" + count);
        writer.flush();
    }
}
