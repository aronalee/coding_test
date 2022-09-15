package 점프와순간이동;


public class Solution {
    // solve1
    public int solution(int n) {
        int ans = 0;
        int countBatteryUsage = 0;
        int point = n;
        while (point > 0) {
            if (point % 2 == 1) {
                countBatteryUsage += 1;
            }
            point /= 2;
        }
        ans = countBatteryUsage;
        return ans;
    }
    // solve2
    public int solution2(int n){
        return Integer.bitCount(n);
    }
}