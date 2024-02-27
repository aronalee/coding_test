// prob: https://www.acmicpc.net/problem/19539

package backjoon.back19539;

import java.util.List;

public class Back19539 {
    public boolean isAbleToMakeTree(List<Integer> wantTreeHeight) {
        int sumHeights = wantTreeHeight.stream().mapToInt(Integer::intValue).sum();
        int countCanUseTwo = wantTreeHeight.stream().mapToInt(treeHeight -> treeHeight / 2).sum();
        if (sumHeights % 3 != 0) {
            return false;
        }
        return countCanUseTwo >= sumHeights / 3;
    }
}
