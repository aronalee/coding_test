# prob: https://www.acmicpc.net/problem/1697

import sys
from collections import deque


def solution(n, k):
    if n >= k:
        return n - k
    INIT = 100_000
    MAX_SIZE = 2 * (k + 1)
    point_of_min_step = [INIT] * MAX_SIZE
    queue = deque([])
    queue.append([n, -100, 0])
    while len(queue) > 0:
        current, before, second = queue.popleft()
        if current > k * 2:
            continue
        if point_of_min_step[current] != INIT:
            continue
        point_of_min_step[current] = second
        if current == k:
            break
        if current + 1 <= k and current + 1 != before:
            queue.append([current + 1, current, second + 1])
        if current - 1 > 0 and current - 1 != before:
            queue.append([current - 1, current, second + 1])
        if current * 2 <= MAX_SIZE:
            queue.append([current * 2, current, second + 1])
    return point_of_min_step[k]


if __name__ == '__main__':
    input = sys.stdin.readline
    n, k = [int(value) for value in input().replace('\n', '').split()]
    print(solution(n, k))
