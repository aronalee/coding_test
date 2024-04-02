// prob: https://www.acmicpc.net/problem/5904

package backjoon.back5904;

public class Back5904 {
    public char findWordAboutSequence(int n) {
        return findWordAboutPosition(n, 3, 1);
    }

    private char findWordAboutPosition(int positionIdx, int lengthLeft, int depth) {
        int lengthTotal = 2 * lengthLeft + depth + 3;
        if (positionIdx <= 3) {
            return convertPositionToChar(positionIdx);
        }
        if (lengthTotal < positionIdx) {
            return findWordAboutPosition(positionIdx, lengthTotal, depth + 1);
        }
        int lengthMid = lengthLeft + depth + 3;
        if (lengthLeft < positionIdx && positionIdx <= lengthMid) {
            return convertPositionToChar(positionIdx - lengthLeft);
        }
        return findWordAboutPosition(positionIdx - lengthMid, 3, 1);
    }

    private char convertPositionToChar(int n) {
        if (n == 1) {
            return 'm';
        }
        return 'o';
    }
}
