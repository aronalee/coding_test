// prob: https://www.acmicpc.net/problem/12919

package random_depnence.back12919;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back12919Test {


    @CsvSource(value = {
            "A,BABA,true", "BAAAAABAA,BAABAAAAAB,true", "A,ABAB,false", "B,BBBBBBB,true"
    })
    @ParameterizedTest
    void givenWords_whenIsMakeTarget_thenExpected(String startWord, String targetWord, boolean expected) {
        // given
        Back12919 back12919 = new Back12919();

        // when & then
        assertEquals(expected, back12919.isMakeTarget(startWord, targetWord));

    }

}