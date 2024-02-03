// prob: https://www.acmicpc.net/problem/5446

package backjoon.back5446;

import java.util.List;

public class Back5446 {

    public int findMinDeleteCount(List<String> willRemoveFiles, List<String> notRemoveFiles) {
        Trie trie = new Trie();
        for (String willRemoveFile : willRemoveFiles) {
            trie.insert(willRemoveFile);
        }
        for (String notRemoveFile : notRemoveFiles) {
            trie.markingCanNotDelete(notRemoveFile);
        }
        return trie.countCanDelete();
    }
}
