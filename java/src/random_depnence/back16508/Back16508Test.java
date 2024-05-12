// prob: https://www.acmicpc.net/problem/16508

package random_depnence.back16508;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back16508Test {


    public static Stream<Arguments> provideBack16508TestCase() {
        return Stream.of(
                Arguments.of("ANT",
                        Map.of("COMPUTERARCHITECTURE", 35000,
                                "ALGORITHM", 47000,
                                "NETWORK", 43000,
                                "OPERATINGSYSTEM", 40000), 40000),
                Arguments.of("ALMIGHTY",
                        Map.of("COMPUTERARCHITECTURE", 35000,
                                "ALGORITHM", 47000,
                                "NETWORK", 43000,
                                "OPERATINGSYSTEM", 40000), 87000),
                Arguments.of("BAKEJOON",
                        Map.of("JAVA", 25000,
                                "OOP", 10000,
                                "BINARYCHECK", 30000), 65000),
                Arguments.of("JAVA",
                        Map.of("CPLUSPLUS", 30000,
                                "PYTHON", 25000), -1),
                Arguments.of("JAAAA",
                        Map.of("JAVA", 10000,
                                "JEST", 10000,
                                "MOCHA", 10000), -1)
        );
    }

    @MethodSource("provideBack16508TestCase")
    @ParameterizedTest
    void givenBack16508TC_whenComputeMinPrice_thenExpected(String word, Map<String, Integer> bookToPrice, int expected) {
        // given
        Back16508 back16508 = new Back16508();

        // when
        int actual = back16508.computeMinPrice(word, bookToPrice);

        // then
        assertEquals(expected, actual);
    }

}