// prob: https://www.acmicpc.net/problem/18234

package backjoon.back18234;

public class Carrot {
    private final long seed;
    private final long nutritional;

    private Carrot(long seed, long nutritional) {
        this.seed = seed;
        this.nutritional = nutritional;
    }

    public static Carrot of(long seed, long nutritional) {
        return new Carrot(seed, nutritional);
    }

    public long getSeed() {
        return seed;
    }

    public long getNutritional() {
        return nutritional;
    }

    public long computeTasteAfterTime(long time) {
        return nutritional * time + seed;
    }
}
