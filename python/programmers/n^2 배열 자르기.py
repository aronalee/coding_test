# prob: https://school.programmers.co.kr/learn/courses/30/lessons/87390

def calculate_number(size, idx):
    d, m = divmod(idx, size)
    return (d if d >= m else m) + 1


def solution(size, left, right):
    answer = []
    for idx in range(left, right + 1):
        answer.append(calculate_number(size, idx))
    return answer
