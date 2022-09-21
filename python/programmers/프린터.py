# prob: https://school.programmers.co.kr/learn/courses/30/lessons/42587

from collections import deque


def solution(priorities, location):
    queue = deque([[order, priority] for order, priority in enumerate(priorities)])
    wanted_docs = priorities[location]
    count = 0
    while True:
        order, docs = queue.popleft()
        top_priority_docs = 0
        for [_, priority] in queue:
            if top_priority_docs < priority:
                top_priority_docs = priority
        if docs < top_priority_docs:
            queue.append([order, docs])
        else:
            count += 1
            if order == location and docs == wanted_docs:
                break
    return count
