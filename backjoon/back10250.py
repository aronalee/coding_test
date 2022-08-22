# prob: https://www.acmicpc.net/problem/10250

import sys


def biz_logic(test_case):
    results = []
    for height, width, count_customer in test_case:
        x, y = divmod(count_customer, height)
        if y == 0:
            y = height
        else:
            x += 1
        results.append([y, x])
    return results


def back1025():
    count_case = int(sys.stdin.readline().replace('\n', ''))
    test_case = []
    for _ in range(count_case):
        test_case.append(list(map(int, sys.stdin.readline().replace('\n', '').split())))
    for [y, x] in biz_logic(test_case):
        sys.stdout.write('{}{}\n'.format(y, x) if x >= 10 else '{}0{}\n'.format(y, x))
    sys.stdout.flush()


if __name__ == '__main__':
    back1025()
