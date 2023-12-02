// prob: https://www.acmicpc.net/problem/12871

package backjoon;

public class Back12871 {

    public boolean isContainStrings(String s1, String s2) {
        return isContainStrInCompareStr(s1, s2) || isContainStrInCompareStr(s2, s1);
    }

    private boolean isContainStrInCompareStr(String str, String compareStr) {
        if (str.length() < compareStr.length()) {
            return false;
        }
        int lcm = getLCM(str.length(), compareStr.length());
        String expendedStr = expendStringUntilLCM(str, lcm);
        String expendedCompareStr = expendStringUntilLCM(compareStr, lcm);
        return expendedStr.equals(expendedCompareStr);
    }

    private int getLCM(int strLength1, int strLength2) {
        int gcd = getGCD(strLength1, strLength2);
        return strLength1 * strLength2 / gcd;
    }

    private int getGCD(int strLength1, int strLength2) {
        int gcd = 1;
        for (int i = 1; i <= strLength1 && i <= strLength2; i++) {
            if (strLength1 % i == 0 && strLength2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    private String expendStringUntilLCM(String str, int lcm) {
        return str.repeat(Math.max(1, lcm / str.length()));
    }
}