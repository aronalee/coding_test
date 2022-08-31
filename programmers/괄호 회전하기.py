from collections import deque


def correct_bracket(queue):
    stack = []
    for char in queue:
        if char == '(' or char == '[' or char == '{':
            stack.append(char)
            continue
        elif len(stack) > 0:
            top = stack.pop()
            if top == '(' and char == ')':
                continue
            elif top == '[' and char == ']':
                continue
            elif top == '{' and char == '}':
                continue
            return False
        return False
    return len(stack) == 0


def solution(s):
    answer = 0
    circular_queue = deque(list(s))
    max_rotate = len(circular_queue)
    while max_rotate > 0:
        answer += int(correct_bracket(circular_queue))
        circular_queue.rotate(1)
        max_rotate -= 1
    return answer
