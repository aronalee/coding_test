// prob: https://www.acmicpc.net/problem/20291

package backjoon.back20291;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<String> fileNames = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            fileNames.add(reader.readLine());
        }
        Back20219 back20219 = new Back20219();
        Map<String, Integer> extensionToCount = back20219.compressAboutFileExtensions(fileNames);
        List<String> sortedExtensions = back20219.sortingAboutFileExtensions(extensionToCount.keySet());
        for (String extension : sortedExtensions) {
            writer.write(extension + " " + extensionToCount.get(extension) + "\n");
        }
        writer.flush();
    }
}
