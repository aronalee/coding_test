// prob: https://www.acmicpc.net/problem/16171

package random_depnence.back16171;

public class Back16171 {
    private final String note;

    public Back16171(String note) {
        this.note = note;
    }

    public boolean hasKeyword(String keyword) {
        return note.replaceAll("[0-9]", "")
                .contains(keyword);
    }
}
