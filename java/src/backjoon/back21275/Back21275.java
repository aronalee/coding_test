// prob: https://www.acmicpc.net/problem/21275

package backjoon.back21275;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Back21275 {
    private static final List<Character> numberOfDigit =
            Stream.concat(IntStream.rangeClosed('0', '9').mapToObj(e -> (char) e),
                            IntStream.rangeClosed('a', 'z').mapToObj(e -> (char) e))
                    .collect(Collectors.toUnmodifiableList());
    private static final int DIGIT_MIN = 2;
    private static final int DIGIT_MAX
            = 36;
    private static final long EMPTY = -1;
    private final List<Character> numberOfADigit;
    private final List<Character> numberOfBDigit;
    private int digitOfA;
    private int digitOfB;

    public Back21275(List<Character> numberOfADigit, List<Character> numberOfBDigit) {
        this.numberOfADigit = numberOfADigit;
        this.numberOfBDigit = numberOfBDigit;
    }

    public long computeCommonNumber() {
        long commonNumber = EMPTY;
        List<Long> numbersAOf10Digit = createNumberAbout10Digits(numberOfADigit);
        List<Long> numbersBOf10Digit = createNumberAbout10Digits(numberOfBDigit);
        for (int digitOfA = 0; digitOfA < numbersAOf10Digit.size(); digitOfA++) {
            for (int digitOfB = 0; digitOfB < numbersBOf10Digit.size(); digitOfB++) {
                if (Objects.equals(numbersAOf10Digit.get(digitOfA), numbersBOf10Digit.get(digitOfB))) {
                    if (numbersAOf10Digit.get(digitOfA) == EMPTY || numbersBOf10Digit.get(digitOfB) == EMPTY || digitOfA == digitOfB) {
                        continue;
                    }
                    if (commonNumber != EMPTY) {
                        throw new IllegalCallerException("common number has two values");
                    }
                    this.digitOfA = digitOfA;
                    this.digitOfB = digitOfB;
                    commonNumber = numbersAOf10Digit.get(digitOfA);
                }
            }
        }
        if (commonNumber == EMPTY) {
            throw new IllegalCallerException("not found common number");
        }
        return commonNumber;
    }

    private List<Long> createNumberAbout10Digits(List<Character> number) {
        return IntStream.rangeClosed(0, DIGIT_MAX)
                .mapToLong(digit -> {
                    if (digit < DIGIT_MIN) {
                        return EMPTY;
                    }
                    try {
                        return convertNDigitTo10Digit(number, digit);
                    } catch (ArithmeticException e) {
                        return EMPTY;
                    }
                }).boxed().collect(Collectors.toUnmodifiableList());
    }

    private long convertNDigitTo10Digit(List<Character> numberOfADigit, int digit) {
        long result = 0;
        for (int i = numberOfADigit.size() - 1; i >= 0; i--) {
            long valueOfOneDigit = convert10Digit(numberOfADigit.get(i));
            if (valueOfOneDigit >= digit) {
                throw new ArithmeticException("digit is bigger than value");
            }
            long valueOfPowDigit = (long) (valueOfOneDigit * Math.pow(digit, numberOfADigit.size() - i - 1));
            result = Math.addExact(result, valueOfPowDigit);
        }
        return result;
    }

    private long convert10Digit(Character character) {
        for (int idx = 0; idx < numberOfDigit.size(); idx++) {
            if (numberOfDigit.get(idx).equals(character)) {
                return idx;
            }
        }
        throw new IllegalArgumentException("not found character");
    }

    public int getDigitOfA() {
        return this.digitOfA;
    }

    public int getDigitOfB() {
        return this.digitOfB;
    }
}
