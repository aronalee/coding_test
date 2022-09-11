// prob: https://school.programmers.co.kr/learn/courses/30/lessons/70129

package 이진변환반복하기;

class Solution {
    private int countZero = 0;

    private String convertBin(String s) {
        int countOne = 0;
        for (char c :
                s.toCharArray()) {
            switch (c) {
                case '1' -> countOne += 1;
                case '0' -> this.countZero += 1;
            }
        }
        return Integer.toBinaryString(countOne);
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int countConverting = 0;
        while (!s.equals("1")) {
            s = this.convertBin(s);
            countConverting++;
        }
        answer[0] = countConverting;
        answer[1] = this.countZero;
        return answer;
    }
}
