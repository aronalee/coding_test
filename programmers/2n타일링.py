# prob: https://school.programmers.co.kr/learn/courses/30/lessons/12900

def solution(n):
    memoization = [1, 2, 3]
    if n <= len(memoization):
        return memoization[n - 1]
    answer = 0
    for idx in range(3, n):
        memoization[idx % 3] = (memoization[idx % 3 - 1] + memoization[idx % 3 - 2]) % 1_000_000_007
        answer = memoization[idx % 3]
    return answer
