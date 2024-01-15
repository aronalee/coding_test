// prob: https://www.acmicpc.net/problem/1495

package backjoon.back1495;

import java.util.Arrays;
import java.util.List;

public class Back1495 {
    public static final byte EMPTY = -2;
    private static final byte NOT_VISITED = -1;
    private static final byte CAN_VOLUME = 1;
    private final List<Integer> controlVolumes;
    private int[][] isVisitedVolume;
    private int startVolume;

    public Back1495(List<Integer> controlVolumes) {
        this.controlVolumes = controlVolumes;
    }

    public int findMaxVolume(int startVolume, int limitVolume) {
        this.startVolume = startVolume;
        isVisitedVolume = new int[controlVolumes.size()][limitVolume + 1];
        for (int[] array : isVisitedVolume) {
            Arrays.fill(array, NOT_VISITED);
        }
        int maxVolume = EMPTY;
        for (int volume = 0; volume <= limitVolume; volume++) {
            if (hasVisitedVolume(volume, controlVolumes.size() - 1) != CAN_VOLUME) {
                continue;
            }
            maxVolume = Math.max(maxVolume, volume);
        }
        return maxVolume;
    }

    private int hasVisitedVolume(int nowVolume, int volumeIdx) {
        if (volumeIdx == -1) {
            if (nowVolume == startVolume) {
                return CAN_VOLUME;
            }
            return EMPTY;
        }
        if (volumeIdx < 0 || volumeIdx >= controlVolumes.size()
                || nowVolume < 0 || nowVolume >= isVisitedVolume[volumeIdx].length
                || isVisitedVolume[volumeIdx][nowVolume] == EMPTY) {
            return EMPTY;
        }
        if (isVisitedVolume[volumeIdx][nowVolume] == CAN_VOLUME) {
            return CAN_VOLUME;
        }
        int hasVisitedAboutPlusVolume = hasVisitedVolume(nowVolume + controlVolumes.get(volumeIdx), volumeIdx - 1);
        int hasVisitedAboutMinusVolume = hasVisitedVolume(nowVolume - controlVolumes.get(volumeIdx), volumeIdx - 1);
        if (hasVisitedAboutMinusVolume == CAN_VOLUME || hasVisitedAboutPlusVolume == CAN_VOLUME) {
            isVisitedVolume[volumeIdx][nowVolume] = CAN_VOLUME;
            return CAN_VOLUME;
        }
        isVisitedVolume[volumeIdx][nowVolume] = EMPTY;
        return EMPTY;
    }
}
