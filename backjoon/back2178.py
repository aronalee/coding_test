# prob: https://www.acmicpc.net/problem/2178

import sys
from collections import deque

EMPTY = sys.maxsize
DISTANCES = [[0, 1], [0, -1], [1, 0], [-1, 0]]


def solution(n: int, m: int, graph: list) -> int:
    queue = deque([])
    distance_costs = [[EMPTY for _ in range(m)] for _ in range(n)]
    adj_arr = [[False for _ in range(m)] for _ in range(n)]
    h, w = 0, 0
    queue.append([h, w])
    distance_costs[h][w] = 1
    while len(queue) != 0:
        h, w = queue.popleft()
        compare_list = []
        for [move_h, move_w] in DISTANCES:
            dis_h, dis_w = h + move_h, w + move_w
            if not (0 <= dis_h < n and 0 <= dis_w < m):
                continue
            if graph[dis_h][dis_w] != 1:
                continue
            if not adj_arr[dis_h][dis_w]:
                adj_arr[dis_h][dis_w] = True
                queue.append([dis_h, dis_w])
            if distance_costs[dis_h][dis_w] != EMPTY:
                compare_list.append(distance_costs[dis_h][dis_w])
        if len(compare_list) != 0:
            distance_costs[h][w] = min(compare_list) + 1
        else:
            distance_costs[h][w] = 1
        if h == n - 1 and w == m - 1:
            break
    return distance_costs[n - 1][m - 1]


def back2178():
    inputs = sys.stdin.readline
    outputs = sys.stdout
    n, m = list(map(int, inputs().strip().split()))
    graph = [list(map(int, list(inputs().strip()))) for _ in range(n)]
    outputs.write(str(solution(n, m, graph)))
    outputs.flush()


if __name__ == '__main__':
    back2178()
