// prob: https://www.acmicpc.net/problem/1213

package backjoon.back1213;

public class Back1213 {


    /**
     * 문자열을 입력받아 사전순으로 가장 작은 팰린드롬 문자열을 만든다.
     *
     * @param str 정렬되어 있지 않는 무작위의 문자열
     * @return 팰린드롬 문자열
     */
    public String getPalindrome(String str) {
        int[] countChars = createCountChars(str);
        int oddIndex = getPrimeOddIdx(countChars);
        return createPalindrome(countChars, oddIndex);
    }

    /**
     * 문자열에서 대문자열 알파뱃의 개수를 센다.
     *
     * @param str 문자열
     * @return 대문자열 알파벳 개수, 0이 'A', 25가 'Z'
     */
    private int[] createCountChars(String str) {
        int[] countChars = new int[26];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            countChars[c - 'A']++;
        }
        return countChars;
    }

    /**
     * countChar에서 count가 유일하게 홀수인 idx를 찾는다. 홀수인 idx가 2개 이상이면 IllegalArgumentException을 던진다.
     *
     * @param countChars 문자열에 들어있는 알파벳 개수
     * @return 홀수인 idx, 없으면 -1
     */
    private int getPrimeOddIdx(int[] countChars) {
        int countOdd = 0;
        int oddIndex = -1;
        for (int i = 0; i < countChars.length; i++) {
            int countChar = countChars[i];
            if (countChar % 2 == 0) {
                continue;
            }
            countOdd++;
            oddIndex = i;
        }
        if (countOdd > 1) {
            throw new IllegalArgumentException();
        }
        return oddIndex;
    }

    /**
     * 팰린드롬 문자열 생성
     *
     * @param countChars 문자열에 들어있는 알파벳 개수
     * @param oddIndex   홀수인 idx, 없으면 -1
     * @return 팰린드롬 문자열
     */
    private String createPalindrome(int[] countChars, int oddIndex) {
        StringBuilder palindrome = new StringBuilder();
        if (oddIndex != -1) {
            palindrome.append((char) (oddIndex + 'A'));
        }
        for (int i = countChars.length - 1; i >= 0; i--) {
            while (countChars[i] > 0) {
                String c = Character.toString((char) (i + 'A'));
                palindrome = new StringBuilder(c + palindrome + c);
                countChars[i] -= 2;
            }
        }
        return palindrome.toString();
    }
}
