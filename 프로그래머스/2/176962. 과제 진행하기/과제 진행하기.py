def solution(plans):
    def transformMinute(time):
        h,m = map(int, time.split(":"))
        return h*60 + m
    for plan in plans:
        plan[1] = transformMinute(plan[1])
        plan[2] = int(plan[2])
    plans.sort(key=lambda x:x[1])
    stack = []
    answer = []
    for i in range(len(plans)-1):
        subject, start, time = plans[i]
        nextStart = plans[i+1][1]
        remainTime = nextStart-start
        if remainTime >= time:
            answer.append(subject)
            remainTime -= time
            
            while stack and remainTime > 0:
                pauseName, pauseTime = stack.pop()
                if pauseTime <= remainTime:
                    answer.append(pauseName)
                    remainTime-=pauseTime
                else:
                    stack.append((pauseName, pauseTime-remainTime))
                    break
        else:
            stack.append((subject, time-remainTime))
            
    answer.append(plans[-1][0])
    while stack:
        name = stack.pop()[0]
        answer.append(name)
    return answer