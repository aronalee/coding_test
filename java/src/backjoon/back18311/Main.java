// prob: https://www.acmicpc.net/problem/18311

package backjoon.back18311;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        long runningTotal = Long.parseLong(input[1]);
        input = reader.readLine().split(" ");
        List<Course> courseForwards = createCourseForwards(input);
        List<Course> courseReverses = createCourseReverses(input);
        long lengthTotal = Arrays.stream(input).mapToLong(Long::parseLong).sum();
        Back18311 back18311 = new Back18311(courseForwards, courseReverses, lengthTotal);
        int coursesId = back18311.findCurrentCoursesId(runningTotal);
        writer.write(coursesId + "\n");
        writer.flush();
    }

    private static List<Course> createCourseReverses(String[] input) {
        List<Course> courseRevers = new ArrayList<>();
        long lengthTotal = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            int id = i + 1;
            long range = Long.parseLong(input[i]);
            courseRevers.add(new Course(id, lengthTotal, lengthTotal + range));
            lengthTotal += range;
        }
        return courseRevers;
    }

    private static List<Course> createCourseForwards(String[] input) {
        List<Course> courseForwards = new ArrayList<>();
        long lengthTotal = 0;
        for (int i = 0; i < input.length; i++) {
            int id = i + 1;
            long range = Long.parseLong(input[i]);
            courseForwards.add(new Course(id, lengthTotal, lengthTotal + range));
            lengthTotal += range;
        }
        return courseForwards;

    }
}
