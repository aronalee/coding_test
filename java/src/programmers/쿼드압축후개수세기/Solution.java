// prob: https://school.programmers.co.kr/learn/courses/30/lessons/68936

package programmers.쿼드압축후개수세기;

public class Solution {

    public int[] solution(int[][] arr) {
        int[] counter = new int[2];
        countZeroAndOneByQuardTree(arr, counter, arr.length, new int[]{0, 0});
        return counter;
    }

    private void countZeroAndOneByQuardTree(int[][] arr, int[] counter, int size, int[] point) {
        if (size == 1) {
            counter[arr[point[0]][point[1]]]++;
            return;
        }
        int value = arr[point[0]][point[1]];
        for (int y = point[0]; y < point[0] + size; y++) {
            for (int x = point[1]; x < point[1] + size; x++) {
                if (value == arr[y][x]) {
                    continue;
                }
                recursionSizeByDividedTwo(arr, counter, size, point);
                return;
            }
        }
        counter[value]++;
    }

    private void recursionSizeByDividedTwo(int[][] arr, int[] counter, int size, int[] point) {
        for (int y = point[0]; y < point[0] + size; y += size / 2) {
            for (int x = point[1]; x < point[1] + size; x += size / 2) {
                countZeroAndOneByQuardTree(arr, counter, size / 2, new int[]{y, x});
            }
        }
    }
}
