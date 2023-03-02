// prob: https://school.programmers.co.kr/learn/courses/30/lessons/17684

package programmers._3차_압축;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    private static Queue<String> createMsgQueue(String msg) {
        Queue<String> queue = new LinkedList<>();
        for (char c : msg.toCharArray()) {
            queue.add(Character.toString(c));
        }
        return queue;
    }

    private static Map<String, Integer> createIndexTable() {
        Map<String, Integer> strToIdx = new HashMap<>();
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            strToIdx.put(Character.toString(alphabet), alphabet - 'A' + 1);
        }
        return strToIdx;
    }

    public int[] solution(String msg) {
        List<Integer> compressedStr = new LinkedList<>();
        Queue<String> queue = createMsgQueue(msg);
        Map<String, Integer> indexTable = createIndexTable();
        int lastIndex = 26;
        while (!queue.isEmpty()) {
            String str = createLongestIndexingStr(queue, indexTable);
            compressedStr.add(indexTable.get(str));
            if (queue.isEmpty()) {
                continue;
            }
            indexTable.put(str + queue.peek(), lastIndex + 1);
            lastIndex++;
        }
        return convertArray(compressedStr);
    }

    private String createLongestIndexingStr(Queue<String> queue,
        Map<String, Integer> indexTable) {
        StringBuilder builder = new StringBuilder(queue.remove());
        while (!queue.isEmpty() && indexTable.containsKey(builder + queue.peek())) {
            builder.append(queue.remove());
        }
        return builder.toString();
    }

    private int[] convertArray(List<Integer> compressedStr) {
        int[] answer = new int[compressedStr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = compressedStr.get(i);
        }
        return answer;
    }
}
