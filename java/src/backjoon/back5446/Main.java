// prob: https://www.acmicpc.net/problem/5446

package backjoon.back5446;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalTestCases = Integer.parseInt(reader.readLine());
        List<TestCase> testCases = new LinkedList<>();
        for (int testCase = 0; testCase < totalTestCases; testCase++) {
            int willRemoveFilesCount = Integer.parseInt(reader.readLine());
            List<String> willRemoveFiles = new LinkedList<>();
            for (int i = 0; i < willRemoveFilesCount; i++) {
                willRemoveFiles.add(reader.readLine());
            }
            int notRemoveFilesCount = Integer.parseInt(reader.readLine());
            List<String> notRemoveFiles = new LinkedList<>();
            for (int i = 0; i < notRemoveFilesCount; i++) {
                notRemoveFiles.add(reader.readLine());
            }
            testCases.add(new TestCase(willRemoveFiles, notRemoveFiles));
        }
        Back5446 back5446 = new Back5446();
        for (TestCase testCase : testCases) {
            int removeCount = back5446.findMinDeleteCount(testCase.willRemoveFiles, testCase.notRemoveFiles);
            writer.write(removeCount + "\n");
        }
        writer.flush();


    }

    private static class TestCase {
        private final List<String> willRemoveFiles;
        private final List<String> notRemoveFiles;

        public TestCase(List<String> willRemoveFiles, List<String> notRemoveFiles) {
            this.willRemoveFiles = willRemoveFiles;
            this.notRemoveFiles = notRemoveFiles;
        }
    }
}
