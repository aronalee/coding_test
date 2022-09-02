# prob: https://school.programmers.co.kr/learn/courses/30/lessons/64065

import re


def solution(s):
    count_map = {}
    for number in re.findall('\d+', s):
        if number not in count_map:
            count_map[number] = 1
        else:
            count_map[number] += 1
    answer = []
    for (element, _) in sorted(count_map.items(), key=lambda value: value[1], reverse=True):
        answer.append(int(element))
    return answer

