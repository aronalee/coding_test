// prob: https://www.acmicpc.net/problem/5427

package backjoon.back5427;

import static backjoon.back5427.BuildingStatus.BLOCK;
import static backjoon.back5427.BuildingStatus.EMPTY;
import static backjoon.back5427.BuildingStatus.FIRE;
import static backjoon.back5427.BuildingStatus.PERSON;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back5427Test {

    public static Stream<Arguments> getNormalTestCases() {
        return Stream.of(
            Arguments.of(new BuildingStatus[][]{
                {BLOCK, BLOCK, BLOCK, BLOCK},
                {BLOCK, FIRE, PERSON, EMPTY},
                {BLOCK, BLOCK, BLOCK, BLOCK},
            }, 2),
            Arguments.of(new BuildingStatus[][]{
                {BLOCK, BLOCK, BLOCK, EMPTY, BLOCK, BLOCK, BLOCK},
                {BLOCK, FIRE, BLOCK, EMPTY, BLOCK, FIRE, BLOCK},
                {BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BLOCK},
                {BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BLOCK},
                {BLOCK, EMPTY, EMPTY, PERSON, EMPTY, EMPTY, BLOCK},
                {BLOCK, BLOCK, BLOCK, BLOCK, BLOCK, BLOCK, BLOCK},
            }, 5),
            Arguments.of(new BuildingStatus[][]{
                {BLOCK, BLOCK, BLOCK, EMPTY, BLOCK, BLOCK, BLOCK},
                {BLOCK, FIRE, BLOCK, EMPTY, BLOCK, FIRE, BLOCK},
                {BLOCK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BLOCK},
                {BLOCK, EMPTY, EMPTY, FIRE, EMPTY, EMPTY, BLOCK},
                {BLOCK, EMPTY, EMPTY, PERSON, EMPTY, EMPTY, BLOCK},
                {BLOCK, BLOCK, BLOCK, BLOCK, BLOCK, BLOCK, BLOCK},
            }, -1),
            Arguments.of(new BuildingStatus[][]{
                {FIRE, FIRE, FIRE, FIRE, FIRE, FIRE, FIRE},
                {FIRE, FIRE, FIRE, FIRE, FIRE, FIRE, FIRE},
                {FIRE, FIRE, FIRE, FIRE, FIRE, FIRE, FIRE},
                {FIRE, FIRE, FIRE, FIRE, FIRE, FIRE, FIRE},
                {FIRE, FIRE, FIRE, FIRE, FIRE, FIRE, FIRE},
                {FIRE, FIRE, FIRE, PERSON, FIRE, FIRE, FIRE},
            }, 1),
            Arguments.of(new BuildingStatus[][]{
                {BLOCK, BLOCK, BLOCK, BLOCK},
                {BLOCK, BLOCK, PERSON, BLOCK},
                {BLOCK, BLOCK, BLOCK, BLOCK},
            }, -1),
            Arguments.of(new BuildingStatus[][]{
                {PERSON},
            }, 1), Arguments.of(new BuildingStatus[][]{
                {FIRE, FIRE, BLOCK, EMPTY, BLOCK, FIRE, FIRE},
                {FIRE, FIRE, BLOCK, EMPTY, BLOCK, FIRE, FIRE},
                {FIRE, FIRE, BLOCK, PERSON, BLOCK, FIRE, FIRE},
                {FIRE, FIRE, BLOCK, EMPTY, BLOCK, FIRE, FIRE},
                {FIRE, FIRE, BLOCK, EMPTY, BLOCK, FIRE, FIRE},
                {FIRE, FIRE, BLOCK, EMPTY, BLOCK, FIRE, FIRE},
            }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalTestCases")
    void getMinTime(BuildingStatus[][] buildingStatuses, int answer) {
        // Give
        List<int[]> burnPoints = new ArrayList<>();
        int[] person = new int[]{0, 0};
        for (int y = 0; y < buildingStatuses.length; y++) {
            for (int x = 0; x < buildingStatuses[y].length; x++) {
                if (buildingStatuses[y][x] == BuildingStatus.FIRE) {
                    burnPoints.add(new int[]{y, x});
                    continue;
                }
                if (buildingStatuses[y][x] == BuildingStatus.PERSON) {
                    person = new int[]{y, x};
                }
            }
        }
        Back5427 back5427 = new Back5427();

        // When
        int result = back5427.getMinTime(buildingStatuses, burnPoints, person);

        // Then
        assertThat(result).isEqualTo(answer);
    }
}