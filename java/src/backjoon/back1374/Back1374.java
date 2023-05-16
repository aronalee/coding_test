// prob: https://www.acmicpc.net/problem/1374

package backjoon.back1374;

import java.util.List;

public class Back1374 {

    /**
     * 강의 개수를 받아서
     *
     * @param courses mutable list, 내부 로직에서 값을 조회만 하기에 요소까지 복제할 필요는 없다.
     * @return 특정 시간에 가장 많이 겹치는 강의의 개수 == 최소로 필요한 강의실 개수
     */
    public int getMinRooms(List<Course> courses) {
        int minRooms = 0;
        courses.sort((c1, c2) -> {
            if (c1.getStartedAt() != c2.getStartedAt()) {
                return Integer.compare(c1.getStartedAt(), c2.getStartedAt());
            }
            return Integer.compare(c1.getEndedAt(), c2.getEndedAt());
        });
        for (int i = 0; i < courses.size(); i++) {
            int room = 1;
            int startedAt = courses.get(i).getStartedAt();
            int endedAt = courses.get(i).getEndedAt();
            for (int j = 0; j < courses.size(); j++) {

                if (courses.get(j).getStartedAt() >= courses.get(i).getEndedAt()) {
                    break;
                }
                room++;
            }
            minRooms = Math.max(minRooms, room);
        }
        return minRooms;
    }
}
