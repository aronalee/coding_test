// https://www.acmicpc.net/problem/20924

package backjoon.back20924;

public class GigaNodeInfo {
    private final int length;
    private final int gigaNodeId;

    public GigaNodeInfo(int length, int gigaNodeId) {
        this.length = length;
        this.gigaNodeId = gigaNodeId;
    }

    public int getLength() {
        return length;
    }

    public int getGigaNodeId() {
        return gigaNodeId;
    }
}
