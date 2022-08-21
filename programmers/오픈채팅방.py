# prob: https://school.programmers.co.kr/learn/courses/30/lessons/42888

JOIN_ROOM = 'Enter'
LEAVE_ROOM = 'Leave'
CHANGE_NAME = 'Change'


def solution(record):
    answer = []
    # key: uid, value: nick name
    result = {}
    for command in record:
        cmd = command.split()
        if cmd[0] == JOIN_ROOM or cmd[0] == CHANGE_NAME:
            _, uid, nickname = cmd
            result[uid] = nickname
    for command in record:
        cmd = command.split()
        if cmd[0] == JOIN_ROOM:
            answer.append("{}님이 들어왔습니다.".format(result[cmd[1]]))
        elif cmd[0] == LEAVE_ROOM:
            answer.append("{}님이 나갔습니다.".format(result[cmd[1]]))

    return answer
