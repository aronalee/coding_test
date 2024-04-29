// prob: https://www.acmicpc.net/problem/15721

package backjoon;

public class Back15721 {

    private static final int SYMBOL_BYUNG = 0;

    private static boolean isTargetPerson(int target, int symbol, int countByung, int countDegi) {
        return symbol == 0 ? countByung == target : countDegi == target;
    }

    public int findPerson(int peopleTotal, int target, int symbol) {
        int round = 1;
        int personCurrent = 0;
        int countByung = 0;
        int countDegi = 0;
        while (symbol == SYMBOL_BYUNG ? countByung < target : countDegi < target) {
            for (int i = 0; i < 2; i++) {
                countByung++;
                if (isTargetPerson(target, symbol, countByung, countDegi)) {
                    return personCurrent;
                }
                personCurrent = movePerson(peopleTotal, personCurrent);
                countDegi++;
                if (isTargetPerson(target, symbol, countByung, countDegi)) {
                    return personCurrent;
                }
                personCurrent = movePerson(peopleTotal, personCurrent);
            }
            for (int i = 0; i <= round; i++) {
                countByung++;
                if (isTargetPerson(target, symbol, countByung, countDegi)) {
                    return personCurrent;
                }
                personCurrent = movePerson(peopleTotal, personCurrent);
            }
            for (int i = 0; i <= round; i++) {
                countDegi++;
                if (isTargetPerson(target, symbol, countByung, countDegi)) {
                    return personCurrent;
                }
                personCurrent = movePerson(peopleTotal, personCurrent);
            }
            round++;
        }
        return personCurrent;
    }

    private int movePerson(int peopleTotal, int personCurrent) {
        return (personCurrent + 1) % peopleTotal;
    }
}
