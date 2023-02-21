// prob: https://www.acmicpc.net/problem/14502

package backjoon.back14502;

import static backjoon.back14502.AreaStatus.BLOCK;
import static backjoon.back14502.AreaStatus.EMPTY;
import static backjoon.back14502.AreaStatus.VIRUS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back14502Test {

    private static Stream<Arguments> backTestCases() {
        return Stream.of(
            Arguments.of(
                new AreaStatus[][]{
                    {VIRUS, EMPTY, EMPTY, EMPTY, BLOCK, BLOCK, EMPTY},
                    {EMPTY, EMPTY, BLOCK, EMPTY, BLOCK, VIRUS, EMPTY},
                    {EMPTY, BLOCK, BLOCK, EMPTY, BLOCK, EMPTY, EMPTY},
                    {EMPTY, BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BLOCK, BLOCK},
                    {EMPTY, BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                }, 27, "백준 기본 테스트1"
            ),
            Arguments.of(
                new AreaStatus[][]{
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {BLOCK, BLOCK, BLOCK, EMPTY, EMPTY, VIRUS},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                }, 9, "백준 기본 테스트2"
            ),
            Arguments.of(
                new AreaStatus[][]{
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                }, 3, "백준 기본 테스트3"
            )
        );
    }

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(
                new AreaStatus[][]{
                    {EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY}
                }, 6, "바이러스가 하나도 없는 상태"
            ),
            Arguments.of(
                new AreaStatus[][]{
                    {VIRUS, VIRUS, VIRUS},
                    {VIRUS, VIRUS, VIRUS},
                    {EMPTY, EMPTY, EMPTY}
                }, 0, "빈공간 3개만 있고 나머진 바이러스로 채워진 상태"
            ),
            Arguments.of(
                new AreaStatus[][]{
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {VIRUS, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, VIRUS},
                }, 1, "바이러스가 양 끝에 있고 벽이 없어 모든 영역에 바이러스가 전파되어 벽 끝의 한 영역만 보호할 수 있는 상태"
            )
        );
    }

    @DisplayName("전체 테스트")
    @MethodSource({"backTestCases", "customTestCases"})
    @ParameterizedTest(name = "{index}. {2}")
    void getMaxSafetyArea(AreaStatus[][] map, int answer, String parmTestName) {
        Back14502 back14502 = new Back14502();
        int N = map.length;
        int M = map[0].length;
        int result = back14502.getMaxSafetyArea(map, N, M);
        assertThat(result).isEqualTo(answer);
    }
}