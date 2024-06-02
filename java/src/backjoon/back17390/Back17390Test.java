// prob: https://www.acmicpc.net/problem/17390

package backjoon.back17390;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back17390Test {


    public static Stream<Arguments> provideBack17390TC() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(List.of(2, 5, 1, 4, 3)),
                        List.of(new int[]{1, 5},
                                new int[]{2, 4},
                                new int[]{3, 3},
                                new int[]{1, 3},
                                new int[]{2, 5},
                                new int[]{4, 5},
                                new int[]{1, 1}),
                        List.of(15, 9, 3, 6, 14, 9, 1)
                )
        );
    }

    @MethodSource("provideBack17390TC")
    @ParameterizedTest
    void givenBack17390TC_whenComputeSum_thenCorrect(List<Integer> sequence, List<int[]> questions, List<Integer> answers) {
        // given
        sequence.sort(Integer::compareTo);

        Back17390 back17390 = new Back17390(sequence);
        // when
        List<Integer> results = new ArrayList<>();
        for (int[] question : questions) {
            results.add(back17390.computeSum(question[0], question[1]));
        }
        // then
        assertThat(results).containsExactlyElementsOf(answers);
    }

}