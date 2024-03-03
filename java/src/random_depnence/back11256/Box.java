// prob: https://www.acmicpc.net/problem/11256

package random_depnence.back11256;

public class Box {
    private final int row;
    private final int column;

    public Box(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getSquare() {
        return row * column;
    }


}

