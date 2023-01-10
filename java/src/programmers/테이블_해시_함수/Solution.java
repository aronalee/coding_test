// prob: https://school.programmers.co.kr/learn/courses/30/lessons/147354

package programmers.테이블_해시_함수;

import java.util.Arrays;

public class Solution {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[][] copiedData = copyOfData(data);
        sortingData(copiedData, col);
        return hashingTable(row_begin, row_end, copiedData);
    }

    private int[][] copyOfData(int[][] data) {
        int[][] cloneData = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            cloneData[i] = Arrays.copyOf(data[i], data[i].length);
        }
        return cloneData;
    }

    private void sortingData(int[][] data, int col) {
        Arrays.sort(data, (o1, o2) -> {
            int compareCol = col - 1;
            if (o1[compareCol] != o2[compareCol]) {
                return o1[compareCol] - o2[compareCol];
            }
            return o2[0] - o1[0];
        });
    }

    private int hashingTable(int row_begin, int row_end, int[][] copiedData) {
        int answer = 0;
        for (int row = row_begin - 1; row < row_end; row++) {
            int[] tuple = copiedData[row];
            int acc = 0;
            for (int value : tuple) {
                acc += value % (row + 1);
            }
            answer ^= acc;
        }
        return answer;
    }
}
