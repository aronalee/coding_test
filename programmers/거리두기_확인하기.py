# prob: https://school.programmers.co.kr/learn/courses/30/lessons/81302

distances_one = [[0, 1], [0, -1], [1, 0], [-1, 0]]
distances_two = [[0, 2], [0, -2], [2, 0], [-2, 0]]
PERSON = 'P'
PARTITION = 'X'
EMPTY_TABLE = 'O'


def check_place(place):
    for height in range(5):
        for width in range(5):
            if place[height][width] == PERSON:
                for [move_h, move_w] in distances_one:
                    dis_h, dis_w = height + move_h, width + move_w
                    if 0 <= dis_h < 5 and 0 <= dis_w < 5:
                        if place[dis_h][dis_w] == PERSON:
                            return 0
                for [move_h, move_w] in distances_two:
                    dis_h, dis_w = height + move_h, width + move_w
                    if 0 <= dis_h < 5 and 0 <= dis_w < 5:
                        if place[dis_h][dis_w] == PERSON \
                                and place[(dis_h + height) // 2][(dis_w + width) // 2] != PARTITION:
                            return 0
            elif place[height][width] == EMPTY_TABLE:
                count = 0
                for [move_h, move_w] in distances_one:
                    dis_h, dis_w = height - move_h, width - move_w
                    if 0 <= dis_h < 5 and 0 <= dis_w < 5 and place[dis_h][dis_w] == PERSON:
                        count += 1
                if count > 1:
                    return 0
    return 1


def solution(places):
    answer = []
    for place in places:
        answer.append(check_place(place))
    return answer
