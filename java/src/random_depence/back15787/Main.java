// prob: https://www.acmicpc.net/problem/15787

package random_depence.back15787;

import java.io.*;
import java.util.InputMismatchException;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Back15787 back15787 = new Back15787(new int[n]);
        for (int line = 0; line < m; line++) {
            String[] lineInput = reader.readLine().split(" ");
            int command = Integer.parseInt(lineInput[0]);
            int trainNo = Integer.parseInt(lineInput[1]) - 1;
            int seatNo;
            switch (command) {
                case 1:
                    seatNo = Integer.parseInt(lineInput[2]);
                    back15787.seatDownPerson(trainNo, seatNo);
                    break;
                case 2:
                    seatNo = Integer.parseInt(lineInput[2]);
                    back15787.seatUpPerson(trainNo, seatNo);
                    break;
                case 3:
                    back15787.pushSeatLeft(trainNo);
                    break;
                case 4:
                    back15787.pullSeatRight(trainNo);
                    break;
                default:
                    throw new InputMismatchException("command is 1, 2, 3, 4");
            }
        }

        int permitTrains = back15787.countTotalTrains();
        writer.write(permitTrains + "\n");
        writer.flush();
    }

}
