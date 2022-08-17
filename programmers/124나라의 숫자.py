def solution(n):
    numbers = ['4', '1', '2']
    answer = ''
    while n > 0:
        quotient, rest = divmod(n, 3)
        answer = numbers[rest] + answer
        n = quotient - (1 if rest == 0 else 0)
    return answer
