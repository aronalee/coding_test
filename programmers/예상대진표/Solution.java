package 예상대진표;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int countGames = n / 2;
        while (!(Math.abs(a - b) < 1
                && ((a > countGames && b > countGames) || (a <= countGames && b <= countGames)))) {
            a = (a % 2 == 0 ? a : (a + 1)) / 2;
            b = (b % 2 == 0 ? b : (b + 1)) / 2;
            countGames /= 2;
            answer++;
        }
        return answer;
    }
}

