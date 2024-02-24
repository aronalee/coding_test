// prob: https://www.acmicpc.net/problem/20950

package backjoon.back20950;

public class Colour {

    private final int red;
    private final int green;
    private final int blue;

    private Colour(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Colour of(int red, int green, int blue) {
        return new Colour(red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
