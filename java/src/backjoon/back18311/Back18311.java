// prob: https://www.acmicpc.net/problem/18311

package backjoon.back18311;

import java.util.List;

public class Back18311 {

    private final List<Course> courseForwards;
    private final List<Course> courseRevers;
    private final long lengthTotal;

    public Back18311(List<Course> courseForwards, List<Course> courseRevers, long lengthTotal) {
        this.courseForwards = courseForwards;
        this.courseRevers = courseRevers;
        this.lengthTotal = lengthTotal;
    }

    public int findCurrentCoursesId(long runningTotal) {
        long runningLength = runningTotal % lengthTotal;
        long runningCount = runningTotal / lengthTotal;
        if (runningCount % 2 == 0) {
            return findCurrentCoursesId(courseForwards, runningLength, 0, courseForwards.size() - 1);
        }
        return findCurrentCoursesId(courseRevers, runningLength, 0, courseRevers.size() - 1);
    }


    private int findCurrentCoursesId(List<Course> courses, long runningLength, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("not found courses id");
        }
        int mid = (start + end) / 2;
        Course course = courses.get(mid);
        if (course.getEnd() > runningLength && course.getStart() <= runningLength) {
            return course.getId();
        }
        if (course.getEnd() <= runningLength) {
            return findCurrentCoursesId(courses, runningLength, mid + 1, end);
        }
        return findCurrentCoursesId(courses, runningLength, start, mid - 1);
    }
}
