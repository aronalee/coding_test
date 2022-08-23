# prob: https://www.acmicpc.net/problem/10610

import sys


def make_radixes(lists):
    num = [0 for _ in range(0, 10)]
    for n in lists:
        num[n] += 1
    return num


def make_max_number(radixes):
    result = ''
    for i in range(len(radixes) - 1, -1, -1):
        for j in range(0, radixes[i]):
            result += str(i)
    return int(result)


def back10610():
    numbers = list(map(int, sys.stdin.readline().replace('\n', '')))
    radixes = make_radixes(numbers)
    number = make_max_number(radixes)
    if number % 30 != 0:
        number = -1
    sys.stdout.write(str(number))
    sys.stdout.flush()


if __name__ == '__main__':
    back10610()
