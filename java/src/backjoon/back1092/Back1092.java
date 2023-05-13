// prob: https://www.acmicpc.net/problem/1092

package backjoon.back1092;

import java.util.Collections;
import java.util.List;

public class Back1092 {

    public int getAnswer(List<Integer> cranes, List<Integer> boxes) {
        Collections.sort(boxes);
        int answer = 0;
        while (boxes.size() > 0) {
            int beforeSize = boxes.size();
            for (Integer crane : cranes) {
                int removeBoxNo = searchRemoveBoxNo(boxes, crane);
                removeBoxAboutNo(boxes, crane, removeBoxNo);
            }
            int afterSize = boxes.size();
            if (beforeSize == afterSize) {
                return -1;
            }
            answer++;
        }
        return answer;
    }

    /**
     * binary search 를 이용하여 박스들중에 크레인이 견딜 수 있는 최대 무게를 가진 박스를 찾는다. 단 선택된 박스가 견딜수 없는 경우도 존재한다.
     *
     * @param boxes 박스 목록
     * @param crane 박스를 담당할 크레인
     * @return mid 박스 번호
     */
    private int searchRemoveBoxNo(List<Integer> boxes, Integer crane) {
        int left = 0;
        int right = boxes.size() - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (boxes.get(mid) < crane) {
                left = mid + 1;
                continue;
            }
            if (boxes.get(mid) > crane) {
                right = mid - 1;
                continue;
            }
            break;
        }
        mid = (left + right) / 2;
        return mid;
    }

    /**
     * 크레인이 담당한 박스의 무게가 적절한지를 판단하고 박스를 제거한다.
     *
     * @param boxes       박스 목록
     * @param crane       박스를 담당할 크레인
     * @param removeBoxNo 삭제할 박스 번호
     */
    private void removeBoxAboutNo(List<Integer> boxes, Integer crane, int removeBoxNo) {
        if (boxes.size() == 0 || boxes.get(removeBoxNo) > crane) {
            return;
        }
        boxes.remove(removeBoxNo);
    }
}
