// prob: https://school.programmers.co.kr/learn/courses/30/lessons/152995

package programmers.인사고과;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int solution(int[][] scores) {
        List<Node> nodes = new ArrayList<>();
        Node pivortNode = new Node(scores[0][0], scores[0][1]);
        for (int[] score : scores) {
            nodes.add(new Node(score[0], score[1]));
        }
        nodes.sort((v1, v2) -> {
            if (v1.workAttitude != v2.workAttitude) {
                return v2.workAttitude - v1.workAttitude;
            }
            return v1.fellowScore - v2.fellowScore;
        });
        return findRank(nodes, pivortNode);
    }

    private int findRank(List<Node> nodes, Node pivortNode) {
        int maxFellowScore = 0;
        int rank = 1;
        for (Node node : nodes) {
            if (pivortNode.workAttitude < node.workAttitude
                && pivortNode.fellowScore < node.fellowScore) {
                return -1;
            }
            if (maxFellowScore > node.fellowScore) {
                continue;
            }
            if (pivortNode.getTotalScore() < node.getTotalScore()) {
                rank++;
            }
            maxFellowScore = node.fellowScore;
        }
        return rank;
    }

    private static class Node {

        private final int workAttitude;
        private final int fellowScore;

        public Node(int workAttitude, int fellowScore) {
            this.workAttitude = workAttitude;
            this.fellowScore = fellowScore;
        }

        public int getTotalScore() {
            return this.workAttitude + this.fellowScore;
        }
    }
}
