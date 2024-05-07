// prob: https://www.acmicpc.net/problem/19585

package backjoon.back19585;

import java.util.List;
import java.util.Set;

public class Back19585 {
    private final Trie colorTrie;
    private final Set<String> nicknameSet;

    public Back19585(Trie colorTrie, Set<String> nicknameSet) {
        this.colorTrie = colorTrie;
        this.nicknameSet = nicknameSet;
    }

    public boolean isWinTeamName(String teamName) {
        List<Integer> endOfWordPositions = colorTrie.findEndOfWordPositions(teamName);
        for (int position : endOfWordPositions) {
            if (nicknameSet.contains(teamName.substring(position + 1))) {
                return true;
            }
        }
        return false;
    }
}
