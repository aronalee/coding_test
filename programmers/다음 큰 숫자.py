# prob: https://school.programmers.co.kr/learn/courses/30/lessons/12911

from collections import Counter


def solution(n):
    current_count = Counter(bin(n))
    next_number = n + 1
    next_count = Counter(bin(next_number))
    while current_count.get('1') != next_count.get('1'):
        next_number += 1
        next_count = Counter(bin(next_number))
    return next_number
