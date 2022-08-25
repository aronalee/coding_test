# prob: https://school.programmers.co.kr/learn/courses/30/lessons/118667

from collections import deque


def solution(list1, list2):
    queue1 = deque(list1)
    queue2 = deque(list2)
    sum_queue1 = sum(queue1)
    sum_queue2 = sum(queue2)
    max_count = len(queue1) * 2
    count_queue1 = 0
    count_queue2 = 0
    while sum_queue1 != sum_queue2:
        if max_count < count_queue1 or max_count < count_queue2:
            return -1
        if sum_queue1 > sum_queue2:
            value = queue1.popleft()
            sum_queue1 -= value
            sum_queue2 += value
            queue2.append(value)
            count_queue1 += 1
        else:
            value = queue2.popleft()
            sum_queue2 -= value
            sum_queue1 += value
            queue1.append(value)
            count_queue2 += 1
    return count_queue1 + count_queue2
