// prob: https://www.acmicpc.net/problem/7568

package backjoon.back7568;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back7568Test {

    public static Stream<Arguments> getNormalTestCases() {
        return Stream.of(
            Arguments.of(
                new ArrayList<>(List.of(
                    Person.of(0, 55, 185),
                    Person.of(1, 55, 183),
                    Person.of(2, 88, 186),
                    Person.of(3, 60, 175),
                    Person.of(4, 46, 155)
                )), List.of(2, 2, 1, 2, 5)
            ),
            Arguments.of(
                new ArrayList<>(List.of(
                    Person.of(0, 55, 181),
                    Person.of(1, 56, 181),
                    Person.of(2, 54, 182),
                    Person.of(3, 57, 181),
                    Person.of(4, 53, 182),
                    Person.of(5, 52, 182)
                )), List.of(1, 1, 1, 1, 1, 1)
            ),
            Arguments.of(
                new ArrayList<>(List.of(
                    Person.of(0, 53, 181),
                    Person.of(1, 54, 181),
                    Person.of(2, 57, 183),
                    Person.of(3, 55, 181),
                    Person.of(4, 58, 182)
                )), List.of(3, 3, 1, 3, 1)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalTestCases")
    void createGrades(final List<Person> people, final List<Integer> answer) {
        Back7568 back7568 = new Back7568();
        List<Integer> result = back7568.createGrades(people);
        assertThat(result).isEqualTo(answer);
    }

}