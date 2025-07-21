'''
로그시간으로 풀어야 할 것 같다.
max(diff) 주어지면 start=1, end=max(diff), mid=start+end/2 해서 이진탐색으로 풀고

'''

def solution(diffs, times, limit):
    def time(level):
        result = 0
        for idx, diff in enumerate(diffs):
            if diff <= level:
                result += times[idx]
            else:
                result += ((diff-level) * (times[idx-1]+times[idx]) + times[idx])
        return result
    start, end = 1, max(diffs)
    while start < end:
        mid = (start+end)//2
        if time(mid) <= limit:
            end = mid
        else: start = mid+1
    return start