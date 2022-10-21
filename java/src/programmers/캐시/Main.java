// prob: https://school.programmers.co.kr/learn/courses/30/lessons/17680

package programmers.캐시;

import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

class Node {
    private final String value;
    private int hitCount = 1;

    public Node(String value) {
        this.value = value;
    }

    public void hit() {
        hitCount++;
    }

    public String getValue() {
        return value;
    }
}


class LRUCache {
    private final Map<String, Node> map = new Hashtable<>();
    private final Deque<Node> list = new LinkedList<>();
    private final int size;
    private int time = 0;

    public LRUCache(int size) {
        this.size = size;
    }

    public int getTime() {
        return time;
    }

    private void add(String key, String value) {
        if (this.size == 0)
            return;
        if (map.size() >= size) {
            Node removeObj = list.removeLast();
            map.remove(removeObj.getValue().toLowerCase());
        }
        Node node = new Node(value);
        map.put(key, node);
        list.addFirst(node);
    }

    private void miss(String key, String value) {
        add(key, value);
        time += 5;
    }

    private void hit(String str) {
        Node node = map.get(str);
        node.hit();
        list.remove(node);
        list.addFirst(node);
        time += 1;
    }

    public void find(String str) {
        String key = str.toLowerCase();
        if (!map.containsKey(key)) {
            miss(key, str);
            return;
        }
        hit(key);
    }
}

class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer;
        LRUCache lruCache = new LRUCache(cacheSize);
        for (String city : cities) {
            lruCache.find(city);
        }
        answer = lruCache.getTime();
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(3, new String[]{
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        });
        System.out.println(result);
    }
}
