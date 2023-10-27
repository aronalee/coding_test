// prob: https://www.acmicpc.net/problem/19583

package random_depense.back19583;

import java.io.*;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        LocalTime startedAt = stringToLocalTime(splitLine[0]);
        LocalTime endedAt = stringToLocalTime(splitLine[1]);
        LocalTime terminatedAt = stringToLocalTime(splitLine[2]);
        List<Log> logs = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            String[] splitLog = line.split(" ");
            LocalTime logTime = stringToLocalTime(splitLog[0]);
            String logName = splitLog[1];
            logs.add(new Log(logName, logTime));
        }
        Back19583 back19583 = new Back19583(logs);
        int result = back19583.countVisitedStudent(startedAt, endedAt, terminatedAt);
        writer.write(result + "\n");
        writer.flush();
    }

    /**
     * format: hh:mm
     *
     * @param rawTime String
     * @return LocalTime
     */
    private static LocalTime stringToLocalTime(String rawTime) {
        String[] splitTime = rawTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);
        return LocalTime.of(hour, minute);
    }
}
