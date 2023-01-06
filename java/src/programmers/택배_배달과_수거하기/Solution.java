// prob: https://school.programmers.co.kr/learn/courses/30/lessons/150369

package programmers.택배_배달과_수거하기;

public class Solution {

    private long sum = 0;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        sum = sumArray(deliveries) + sumArray(pickups);
        int lastHome = n - 1;
        while (sum > 0) {
            int longestDeliveryHome = findLongestHome(deliveries, lastHome);
            int longestPickUpHome = findLongestHome(pickups, lastHome);
            updateArray(deliveries, longestDeliveryHome, cap);
            updateArray(pickups, longestPickUpHome, cap);
            int longestHome = Math.max(longestDeliveryHome, longestPickUpHome);
            lastHome = longestHome;
            answer += (longestHome + 1) * 2L;
        }
        return answer;
    }

    private long sumArray(final int[] array) {
        long acc = 0;
        for (int value : array) {
            acc += value;
        }
        return acc;
    }

    private int findLongestHome(final int[] info, final int lastHome) {
        for (int idx = lastHome; idx >= 0; idx--) {
            if (info[idx] > 0) {
                return idx;
            }
        }
        return 0;
    }

    private void updateArray(final int[] array, final int lastHome, int cap) {
        for (int home = lastHome; home >= 0; home--) {
            if (cap == 0) {
                return;
            }
            if (array[home] >= cap) {
                array[home] -= cap;
                sum -= cap;
                return;
            }
            cap -= array[home];
            sum -= array[home];
            array[home] = 0;
        }
    }

}
