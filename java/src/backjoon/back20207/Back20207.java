// prob: https://www.acmicpc.net/problem/20207

package backjoon.back20207;

public class Back20207 {

    private final int[] duplicateScheduleCount;


    public Back20207(int[] duplicateScheduleCount) {
        this.duplicateScheduleCount = duplicateScheduleCount;
    }

    public int computeCoatingArea() {
        int area = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for (int day = 0; day < duplicateScheduleCount.length; day++) {
            if (duplicateScheduleCount[day] == 0) {
                if (maxWidth > 0) {
                    area += maxWidth * maxHeight;
                }
                maxWidth = 0;
                maxHeight = 0;
                continue;
            }
            maxWidth++;
            maxHeight = Math.max(maxHeight, duplicateScheduleCount[day]);
        }
        return area;
    }

}
