// prob: https://www.acmicpc.net/problem/16472

package backjoon.back16472;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Back16472Test {


    @CsvSource(value = {
            "2,abbcaccba,4", "2,zzzzzzzzzz,10", "26,abcdefghijklmnopqustuvwxyz,26"
    })
    @ParameterizedTest
    void givenSequence_whenFindLCS_thenReturnsLCS(int n, String sequence, int expected) {
        // given
        List<Character> chars = sequence.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Back16472 back16472 = new Back16472();

        // when
        int actual = back16472.findLCS(n, chars);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}