// prob: https://www.acmicpc.net/problem/17845

package backjoon.back17845;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int maxTime = Integer.parseInt(splitLine[0]);
        int k = Integer.parseInt(splitLine[1]);
        int[] courseWeight = new int[k];
        int[] courseTimes = new int[k];
        // dp[time]: 시간 time일 때 얻을 수 있는 최대 가중치
        int[] dp = new int[maxTime + 1];
        for (int i = 0; i < k; i++) {
            splitLine = reader.readLine().split(" ");
            courseWeight[i] = Integer.parseInt(splitLine[0]);
            courseTimes[i] = Integer.parseInt(splitLine[1]);
        }
        // 0번째 코스가 maxTime보다 작으면 이 값으로 초기화
        if (courseTimes[0] <= maxTime) {
            for (int time = maxTime; time - courseTimes[0] >= 0; time--) {
                dp[time] = courseWeight[0];
            }
        }
        // i번째 코스마다 dp를 갱신한다.
        for (int i = 1; i < k; i++) {
            for (int time = maxTime; time - courseTimes[i] >= 0; time--) {
                // max(dp[현재 시간], dp[현재 시간-새로운 과목의 시간]+새로운 과목의 가중치)
                // dp[현재 시간-새로운 과목의 시간] 는 항상 i-1번째 과목까지 선택하였을 때의 최대 가중치이다.
                dp[time] = Math.max(dp[time], dp[time - courseTimes[i]] + courseWeight[i]);
            }
        }
        writer.write(dp[maxTime] + "\n");
        writer.flush();
    }
}
