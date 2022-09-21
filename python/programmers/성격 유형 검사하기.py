# prob: https://school.programmers.co.kr/learn/courses/30/lessons/118666

def solution(survey, choices):
    answer = ''
    scores = {
        'R': 0,
        'T': 0,
        'C': 0,
        'F': 0,
        'J': 0,
        'M': 0,
        'A': 0,
        'N': 0,
    }
    for types, choice in zip(survey, choices):
        if choice > 4:
            scores[types[1]] += choice - 4
        elif choice < 4:
            scores[types[0]] += 4 - choice
    for [type1, type2] in ['RT', 'CF', 'JM', 'AN']:
        if scores[type1] < scores[type2]:
            answer += type2
        else:
            answer += type1
    return answer
