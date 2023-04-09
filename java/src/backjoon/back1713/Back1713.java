// prob: https://www.acmicpc.net/problem/1713

package backjoon.back1713;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Back1713 {

    private static void addVote(int n, List<Frame> frames, int time, int vote) {
        for (Frame frame : frames) {
            if (frame.id != vote) {
                continue;
            }
            frame.totalVote++;
            return;
        }
        if (frames.size() < n) {
            frames.add(Frame.of(vote, time));
            return;
        }
        removeFrame(frames);
        frames.add(Frame.of(vote, time));
    }

    private static void removeFrame(List<Frame> frames) {
        frames.sort((v1, v2) -> {
            if (v1.totalVote != v2.totalVote) {
                return v1.totalVote - v2.totalVote;
            }
            return v1.time - v2.time;
        });
        frames.remove(0);
    }

    public List<Integer> getAnswer(int n, String[] votes) {
        List<Frame> frames = new ArrayList<>();
        for (int time = 0; time < votes.length; time++) {
            int vote = Integer.parseInt(votes[time]);
            addVote(n, frames, time, vote);
        }
        frames.sort(Comparator.comparingInt(v -> v.id));
        List<Integer> answers = new LinkedList<>();
        for (Frame frame : frames) {
            answers.add(frame.id);
        }
        return answers;
    }

    private static class Frame {

        private final int id;
        private final int time;


        private int totalVote = 1;

        public Frame(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public static Frame of(int id, int time) {
            return new Frame(id, time);
        }
    }

}
