// prob: https://www.acmicpc.net/problem/1535

package backjoon.back1535;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back1535Test {

    public static Stream<Arguments> provideBack1535TestCases() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Person.of(1, 20), Person.of(21, 30),
                                Person.of(79, 25)), 50),
                Arguments.of(List.of(Person.of(100, 20)), 0),
                Arguments.of(List.of(
                        Person.of(100, 49), Person.of(15, 40),
                        Person.of(1, 1), Person.of(2, 2), Person.of(3, 3),
                        Person.of(4, 4), Person.of(6, 5), Person.of(5, 4)), 59),
                Arguments.of(List.of(
                        Person.of(100, 20), Person.of(50, 30),
                        Person.of(20, 40), Person.of(13, 50)), 120),
                Arguments.of(List.of(
                        Person.of(100, 34), Person.of(26, 56),
                        Person.of(13, 21), Person.of(17, 1),
                        Person.of(24, 24), Person.of(33, 34),
                        Person.of(100, 100), Person.of(99, 99)), 135),
                Arguments.of(IntStream.range(0, 12)
                        .mapToObj(i -> Person.of(1, 100)).toList(), 1200)
        );
    }

    @MethodSource("provideBack1535TestCases")
    @ParameterizedTest
    void givenPeople_whenFindMaxHappy_thenMaxHappy(List<Person> people, int maxHappy) {
        // given
        Back1535 back1535 = new Back1535();

        // when
        int actualMaxHappy = back1535.findMaxHappy(people);

        // then
        assertThat(actualMaxHappy)
                .isEqualTo(maxHappy);
    }

}