// prob: https://www.acmicpc.net/problem/19583

package random_depense.back19583;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Back19583 {
    private final List<Log> logs;

    public Back19583(List<Log> logs) {
        this.logs = logs;
    }

    public int countVisitedStudent(LocalTime startedAt, LocalTime endedAt, LocalTime terminatedAt) {
        Set<String> enteredStudents = new HashSet<>();
        Set<String> enterAndExitStudents = new HashSet<>();
        int countEnterAndExitStudents = 0;
        for (Log log : logs) {
            if (log.getTime().isBefore(startedAt) || log.getTime().equals(startedAt)) {
                enteredStudents.add(log.getName());
                continue;
            }
            if (!enteredStudents.contains(log.getName()) ||
                    !betweenEndedAtAndTerminatedAt(endedAt, terminatedAt, log.getTime())) {
                continue;
            }
            if (!enterAndExitStudents.contains(log.getName())) {
                countEnterAndExitStudents++;
            }
            enterAndExitStudents.add(log.getName());
        }
        return countEnterAndExitStudents;
    }

    private boolean betweenEndedAtAndTerminatedAt(LocalTime endedAt, LocalTime terminatedAt, LocalTime time) {
        return time.equals(endedAt) || time.equals(terminatedAt) || (time.isAfter(endedAt) && time.isBefore(terminatedAt));
    }
}
