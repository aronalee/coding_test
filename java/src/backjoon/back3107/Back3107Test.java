// prob: https://www.acmicpc.net/problem/3107

package backjoon.back3107;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back3107Test {

    @CsvSource(
            value = {
                    "25:09:1985:aa:091:4846:374:bb,0025:0009:1985:00aa:0091:4846:0374:00bb",
                    "::1,0000:0000:0000:0000:0000:0000:0000:0001",
                    "1::,0001:0000:0000:0000:0000:0000:0000:0000",
                    "::,0000:0000:0000:0000:0000:0000:0000:0000",
                    "1:1:1:1:1:1:1:1,0001:0001:0001:0001:0001:0001:0001:0001",
                    "0:1:1:1::1:1,0000:0001:0001:0001:0000:0000:0001:0001",
                    "1234:1234:1234:1234:1234:1234:1234:1234,1234:1234:1234:1234:1234:1234:1234:1234",
            }
    )
    @ParameterizedTest
    void givenZippedIPv6_whenUnzippingIPv6_thenUnzippedIPv6(String zippedIPv6, String unzippedIPv6) {
        // Given
        Back3107 back3107 = new Back3107();

        // When
        String actual = back3107.unzippingIPV6(zippedIPv6);

        // Then
        assertEquals(unzippedIPv6, actual);
    }

}