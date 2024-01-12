// prob: https://www.acmicpc.net/problem/9242

package backjoon.back9242;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final char[][][] numbersOfArray = new char[][][]{
            {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', ' ', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}},
            {{' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}},
            {{'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}, {'*', ' ', ' '}, {'*', '*', '*'}},
            {{'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}},
            {{'*', ' ', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}},
            {{'*', '*', '*'}, {'*', ' ', ' '}, {'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}},
            {{'*', '*', '*'}, {'*', ' ', ' '}, {'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}},
            {{'*', '*', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}},
            {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}},
            {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}},
    };

    public static void main(String[] args) throws IOException {
        char[][] map = new char[5][];
        for (int i = 0; i < 5; i++) {
            String[] input = reader.readLine().split("");
            map[i] = new char[input.length];
            for (int j = 0; j < input.length; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }
        try {
            List<char[][]> arraysAboutNumber = createArraysAboutNumber(map);
            int numericNumber = covertNumericNumber(arraysAboutNumber);
            Back9242 back9242 = new Back9242();
            if (back9242.isBoom(numericNumber)) {
                writer.write("BOOM!!");
            } else {
                writer.write("BEER!!");
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            writer.write("BOOM!!");
        }
        writer.flush();
    }

    private static List<char[][]> createArraysAboutNumber(char[][] map) {
        List<char[][]> numberAboutArrays = new ArrayList<>();
        for (int i = 0; i < map[0].length; i += 4) {
            char[][] number = extractNumber(map, i);
            numberAboutArrays.add(number);
        }
        return numberAboutArrays;
    }

    private static char[][] extractNumber(char[][] map, int srcIndex) {
        char[][] number = new char[5][3];
        for (int y = 0; y < 5; y++) {
            System.arraycopy(map[y], srcIndex, number[y], 0, 3);
        }
        return number;
    }

    private static int covertNumericNumber(List<char[][]> arraysAboutNumber) {
        int numericNumber = 0;
        for (int i = 0; i < arraysAboutNumber.size(); i++) {
            int number = convertArrayToNumber(arraysAboutNumber.get(i));
            numericNumber += (int) (number * (Math.pow(10, (arraysAboutNumber.size() - 1 - i))));
        }
        return numericNumber;
    }

    private static int convertArrayToNumber(char[][] arrayNumber) {
        for (int number = 0; number < numbersOfArray.length; number++) {
            if (!isSame(arrayNumber, numbersOfArray[number])) {
                continue;
            }
            return number;
        }
        throw new IllegalArgumentException("not validate arrayNumber");
    }

    private static boolean isSame(char[][] arrayNumber, char[][] cmpArrayNumber) {
        for (int i = 0; i < arrayNumber.length; i++) {
            for (int j = 0; j < arrayNumber[i].length; j++) {
                if (arrayNumber[i][j] != cmpArrayNumber[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
