# prob: https://school.programmers.co.kr/learn/courses/30/lessons/12902
import math


def solution(n):
    if n % 2 != 0:
        return 0
    memoization = [0, 3, 11]
    if n == 2:
        return memoization[1]
    elif n == 4:
        return memoization[2]
    answer = 0
    for idx in range(0, math.floor(n / 2) - 2):
        memoization[idx % 3] = (memoization[idx % 3 - 1] * 4 - memoization[
            idx % 3 - 2]) % 1_000_000_007
        answer = memoization[idx % 3]
    return answer
