// prob: https://www.acmicpc.net/problem/3107

package backjoon.back3107;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String zippedIPv6 = reader.readLine();
        Back3107 back3107 = new Back3107();
        String unzippedIPv6 = back3107.unzippingIPV6(zippedIPv6);
        writer.write(unzippedIPv6);
        writer.flush();
    }
}
