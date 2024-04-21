// prob: https://www.acmicpc.net/problem/20365

package backjoon.back20365;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Back20365Test {

    @CsvSource({
            "BBRBRBBR, 4",
            "RRBRBRRB, 4",
            "RRRRRRRR, 1",
            "BBBBBBBB, 1",
            "BRBRBRBR, 5",
            "BBBBRRRR, 2",
            "BBRRBBRRBBRRBBRR,5",
            "R, 1",
            "B, 1"
    })
    @ParameterizedTest
    void givenBack20365TestCase_whenComputeFilledColors_thenCorrect(String colors, int expected) {
        Back20365 back20365 = new Back20365();
        int actual = back20365.computeFilledColors(Arrays.stream(colors.split("")).toList());
        assertThat(actual).isEqualTo(expected);

    }
}