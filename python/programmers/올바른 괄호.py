# prob: https://school.programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):
    count = 0
    for char in s:
        if count < 0:
            return False
        if char == '(':
            count += 1
        else:
            count -= 1
    return count == 0
