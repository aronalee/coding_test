package backjoon.back2621;

import java.util.List;

public class Back2621 {

    private static final int COUNT_CARDS = 5;
    private final List<Integer> numbers;
    private final List<Character> cardColors;
    private final int[] countNumbers = new int[10];
    private final int[] countColors = new int[4];

    public Back2621(final List<Integer> numbers, final List<Character> cardColors) {
        this.numbers = numbers;
        this.cardColors = cardColors;
    }

    public int getAnswer() {
        initCounts();
        int answer = 0;
        answer = Math.max(answer, getCase1());
        answer = Math.max(answer, getCase2());
        answer = Math.max(answer, getCase3());
        answer = Math.max(answer, getCase4());
        answer = Math.max(answer, getCase5());
        answer = Math.max(answer, getCase6());
        answer = Math.max(answer, getCase7());
        answer = Math.max(answer, getCase8());
        answer = Math.max(answer, getCase9());
        return answer;
    }

    private void initCounts() {
        // R B Y G
        for (final Character color : cardColors) {
            int idx = -1;
            if (color == 'R') {
                idx = 0;
            } else if (color == 'B') {
                idx = 1;
            } else if (color == 'Y') {
                idx = 2;
            } else if (color == 'G') {
                idx = 3;
            }
            countColors[idx]++;
        }
        for (final Integer number : numbers) {
            countNumbers[number]++;
        }
    }

    private int getCase1() {
        for (final int countColor : countColors) {
            if (countColor == COUNT_CARDS && isContinues()) {
                return getMaxNumber() + 900;
            }
        }
        return 0;
    }

    private int getCase2() {
        for (int number = 0; number < countNumbers.length; number++) {
            int countNumber = countNumbers[number];
            if (countNumber == COUNT_CARDS - 1) {
                return number + 800;
            }
        }
        return 0;
    }

    private int getCase3() {
        int count3Number = 0;
        int count2Number = 0;
        for (int number = 0; number < countNumbers.length; number++) {
            int count = countNumbers[number];
            if (count == 3) {
                count3Number = number;
            } else if (count == 2) {
                count2Number = number;
            }
        }
        if (count3Number == 0 || count2Number == 0) {
            return 0;
        }
        return count3Number * 10 + count2Number + 700;
    }


    private int getCase4() {
        for (final int countColor : countColors) {
            if (countColor == COUNT_CARDS) {
                return getMaxNumber() + 600;
            }
        }
        return 0;
    }

    private int getCase5() {
        if (isContinues()) {
            return getMaxNumber() + 500;
        }
        return 0;
    }

    private int getCase6() {
        for (int number = 0; number < countNumbers.length; number++) {
            int count = countNumbers[number];
            if (count == 3) {
                return number + 400;
            }
        }
        return 0;
    }

    private int getCase7() {
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = 0;
        for (int number = 0; number < countNumbers.length; number++) {
            int count = countNumbers[number];
            if (count == 2) {
                minNumber = Math.min(minNumber, number);
                maxNumber = Math.max(maxNumber, number);
            }
        }
        if (minNumber == maxNumber) {
            return 0;
        }
        return maxNumber * 10 + minNumber + 300;
    }


    private int getCase8() {
        for (int number = 0; number < countNumbers.length; number++) {
            int count = countNumbers[number];
            if (count == 2) {
                return number + 200;
            }
        }
        return 0;
    }

    private int getCase9() {
        return getMaxNumber() + 100;
    }

    private boolean isContinues() {
        int pivort = 0;
        for (int number = 0; number < countNumbers.length; number++) {
            int count = countNumbers[number];
            if (count == 0) {
                continue;
            }
            if (count > 1) {
                return false;
            }
            if (count == 1) {
                if (pivort == 0) {
                    pivort = number;
                    continue;
                }
                if (number - pivort > 1) {
                    return false;
                }
                pivort = number;
            }
        }
        return true;
    }


    private int getMaxNumber() {
        int maxNumber = 0;
        for (final Integer number : numbers) {
            maxNumber = Math.max(maxNumber, number);
        }
        return maxNumber;
    }

}
