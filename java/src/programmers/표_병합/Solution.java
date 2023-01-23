// prob: https://school.programmers.co.kr/learn/courses/30/lessons/150366

package programmers.표_병합;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private static final String EMPTY = "";
    private final Node[][] cell = new Node[51][51];

    public String[] solution(String[] commands) {
        initAttr();
        List<String> log = new LinkedList<>();
        for (String command : commands) {
            String[] splitCommand = command.split(" ");
            parser(log, splitCommand);
        }
        return log.toArray(new String[0]);
    }

    private void parser(List<String> log, String[] splitCommand) {
        switch (splitCommand[0]) {
            case "UPDATE" -> {
                if (splitCommand.length == 3) {
                    update(splitCommand[1], splitCommand[2]);
                    break;
                }
                int r = Integer.parseInt(splitCommand[1]);
                int c = Integer.parseInt(splitCommand[2]);
                String value = splitCommand[3];
                update(r, c, value);
            }
            case "MERGE" -> {
                int r1 = Integer.parseInt(splitCommand[1]);
                int c1 = Integer.parseInt(splitCommand[2]);
                int r2 = Integer.parseInt(splitCommand[3]);
                int c2 = Integer.parseInt(splitCommand[4]);
                merge(r1, c1, r2, c2);
            }
            case "UNMERGE" -> {
                int r = Integer.parseInt(splitCommand[1]);
                int c = Integer.parseInt(splitCommand[2]);
                unmerge(r, c);
            }
            case "PRINT" -> {
                int r = Integer.parseInt(splitCommand[1]);
                int c = Integer.parseInt(splitCommand[2]);
                log.add(print(r, c));
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private void initAttr() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++) {
                cell[i][j] = new Node();
            }
        }
    }

    private void update(final int r, final int c, String value) {
        Node node = getNode(r, c);
        node.value = value;
    }

    private void update(final String beforeValue, final String afterValue) {
        for (Node[] nodes : cell) {
            for (Node node : nodes) {
                if (!node.value.equals(beforeValue)) {
                    continue;
                }
                node.value = afterValue;
            }
        }
    }

    private void merge(final int r1, final int c1, final int r2, final int c2) {
        Node node1 = getNode(r1, c1);
        Node node2 = getNode(r2, c2);
        if (node1 == node2) {
            return;
        }
        node2.next = node1;
        for (Node[] nodes : cell) {
            for (Node node : nodes) {
                if (node.next != node2) {
                    continue;
                }
                node.next = node1;
            }
        }
        if (node1.value.equals(EMPTY) && !node2.value.equals(EMPTY)) {
            node1.value = node2.value;
        }
        node2.value = EMPTY;
    }

    private void unmerge(final int r, final int c) {
        Node root = getNode(r, c);
        for (Node[] nodes : cell) {
            for (Node node : nodes) {
                if (node.next != root) {
                    continue;
                }
                node.next = null;
            }
        }
        if (cell[r][c] != root) {
            cell[r][c].value = root.value;
            root.value = EMPTY;
        }
        root.next = null;
    }

    private String print(final int r, final int c) {
        if (getNode(r, c).value.equals(EMPTY)) {
            return "EMPTY";
        }
        return getNode(r, c).value;
    }

    private Node getNode(final int r, final int c) {
        return getNode(cell[r][c]);
    }

    private Node getNode(final Node node) {
        if (node.next == null) {
            return node;
        }
        Node root = getNode(node.next);
        return node.next = root;
    }

    private static class Node {

        private Node next;
        private String value = EMPTY;

    }
}
