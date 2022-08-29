# prob: https://school.programmers.co.kr/learn/courses/30/lessons/42890

from itertools import combinations


def check_super_key(key, relation):
    s = set()
    for row in relation:
        fields = str([row[attr] for attr in key])
        if fields in s:
            return False
        s.add(fields)
    return True


def check_candidate_key(candidate_keys, super_key):
    for candidate_key in candidate_keys:
        if candidate_key.issubset(super_key):
            return False
    return True


def create_super_keys(relation):
    super_keys = []
    keys = [i for i in range(len(relation[0]))]
    for i in range(1, len(keys) + 1):
        for key in combinations(keys, i):
            if check_super_key(key, relation):
                super_keys.append(set(key))
    return super_keys


def create_candidate_keys(super_keys):
    candidate_keys = []
    for super_key in super_keys:
        if check_candidate_key(candidate_keys, super_key):
            candidate_keys.append(super_key)
    return candidate_keys


def solution(relation):
    super_keys = create_super_keys(relation)
    candidate_keys = create_candidate_keys(super_keys)
    answer = len(candidate_keys)
    return answer
