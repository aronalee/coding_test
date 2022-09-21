# prob: https://school.programmers.co.kr/learn/courses/30/lessons/42626

import heapq


def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    min_food = heapq.heappop(scoville)
    if min_food >= K:
        return 0
    while len(scoville) > 0 and min_food < K:
        food = heapq.heappop(scoville)
        min_food = heapq.heappushpop(scoville, min_food + food * 2)
        answer += 1
    return answer if min_food >= K else -1
