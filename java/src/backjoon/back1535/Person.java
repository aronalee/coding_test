// prob: https://www.acmicpc.net/problem/1535

package backjoon.back1535;

public class Person {
    private final int lostHp;
    private final int happy;

    private Person(int lostHp, int happy) {
        this.lostHp = lostHp;
        this.happy = happy;
    }

    public static Person of(int lostHp, int happy) {
        return new Person(lostHp, happy);
    }

    public int getLostHp() {
        return lostHp;
    }

    public int getHappy() {
        return happy;
    }
}
