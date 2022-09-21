# prob: https://www.acmicpc.net/problem/7562

import sys
from collections import deque

distances = [[1, 2], [1, -2], [-1, 2], [-1, -2],
             [2, 1], [2, -1], [-2, 1], [-2, -1]]


def get_knight_count_move(size, start, end):
    visited = [[False] * size for _ in range(size)]
    queue = deque([[start, 0]])
    while len(queue) > 0:
        [y, x], count = queue.popleft()
        if [y, x] == end:
            return count
        if visited[y][x]:
            continue
        visited[y][x] = True
        for [move_y, move_x] in distances:
            dis_y, dis_x = y + move_y, x + move_x
            if not (0 <= dis_y < size and 0 <= dis_x < size):
                continue
            queue.append([[dis_y, dis_x], count + 1])
    return 0


if __name__ == '__main__':
    input = sys.stdin.readline
    count_testcase = int(input())
    output = sys.stdout
    for _ in range(count_testcase):
        size = int(input())
        start = list(map(int, input().split(' ')))
        end = list(map(int, input().split(' ')))
        output.write('{}\n'.format(get_knight_count_move(size, start, end)))
    output.flush()
