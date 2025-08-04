from collections import defaultdict

def solution(participant, completion):
    participantDict = defaultdict(int)
    for p in participant:
        participantDict[p] += 1
    for c in completion:
        participantDict[c] -= 1
    for key in participantDict:
        if participantDict[key] == 1:
            return key