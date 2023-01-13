// prob: https://school.programmers.co.kr/learn/courses/30/lessons/81303

package programmers.표_편집;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Solution {

    private final UniqueStack<Node> deleteLog = new UniqueStack<>();
    private final List<Node> cell = new LinkedList<>();
    private Node selectedNode;

    public String solution(int n, int k, String[] cmds) {
        initCellAndSelectedNode(n, k);
        for (String cmd : cmds) {
            String[] splitCmd = cmd.split(" ");
            executeCommand(splitCmd);
        }
        return convertAnswer();
    }

    private void initCellAndSelectedNode(int n, int k) {
        Node topNode = new Node(0);
        if (k == 0) {
            selectedNode = topNode;
        }
        cell.add(topNode);
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            Node head = cell.get(cell.size() - 1);
            head.setTail(node);
            node.setHead(head);
            cell.add(node);
            if (i == k) {
                selectedNode = node;
            }
        }
    }

    private void executeCommand(String[] splitCmd) {
        String command = splitCmd[0];
        switch (command) {
            case "U" -> {
                int gap = Integer.parseInt(splitCmd[1]);
                moveUp(gap);
            }
            case "D" -> {
                int gap = Integer.parseInt(splitCmd[1]);
                moveDown(gap);
            }
            case "C" -> delete();
            case "Z" -> recovery();
            default -> throw new IllegalArgumentException();
        }
    }

    private void moveUp(int gap) {
        for (int i = 0; i < gap; i++) {
            if (selectedNode.head == null) {
                return;
            }
            selectedNode = selectedNode.head;
        }
    }

    private void moveDown(int gap) {
        for (int i = 0; i < gap; i++) {
            if (selectedNode.tail == null) {
                return;
            }
            selectedNode = selectedNode.tail;
        }
    }

    private void delete() {
        if (selectedNode.head() != null) {
            selectedNode.head().setTail(selectedNode.tail());
        }
        if (selectedNode.tail() != null) {
            selectedNode.tail().setHead(selectedNode.head());
        }
        deleteLog.push(selectedNode);
        if (selectedNode.tail() == null) {
            selectedNode = selectedNode.head();
            return;
        }
        selectedNode = selectedNode.tail();
    }

    private void recovery() {
        Node recoveryNode = deleteLog.pop();
        Node head = recoveryNode.head();
        Node tail = recoveryNode.tail();
        while (deleteLog.contain(head) && head != null) {
            head = head.head();
        }
        while (deleteLog.contain(tail) && tail != null) {
            tail = tail.tail();
        }
        recoveryNode.setHead(head);
        recoveryNode.setTail(tail);
        if (head != null) {
            head.setTail(recoveryNode);
        }
        if (tail != null) {
            tail.setHead(recoveryNode);
        }
    }

    private String convertAnswer() {
        StringBuilder builder = new StringBuilder();
        for (Node row : cell) {
            if (deleteLog.contain(row)) {
                builder.append("X");
                continue;
            }
            builder.append("O");
        }
        return builder.toString();
    }

    private static class UniqueStack<E> {

        private final Set<E> setElement = new HashSet<>();
        private final Stack<E> stack = new Stack<>();

        public boolean contain(E e) {
            return setElement.contains(e);
        }


        public void push(E e) {
            if (contain(e)) {
                return;
            }
            stack.push(e);
            setElement.add(e);
        }

        public E pop() {
            E e = stack.pop();
            setElement.remove(e);
            return e;
        }

    }

    private static class Node {

        private final int id;
        private Node head;
        private Node tail;

        public Node(int id) {
            this.id = id;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public int id() {
            return id;
        }

        public Node head() {
            return head;
        }

        public Node tail() {
            return tail;
        }
    }
}
