def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    startTime = h1*3600 + m1*60 + s1
    endTime = h2*3600 + m2*60 + s2
    
    if startTime == 0 or startTime == 12*3600:
        answer += 1
    
    while startTime < endTime:
        hAngle = startTime*(1/120)%360
        mAngle = startTime*(1/10)%360
        sAngle = startTime*(6)%360
        
        hNextAngle = 360 if (startTime+1)*(1/120)%360 == 0 else (startTime+1)*(1/120)%360
        mNextAngle = 360 if (startTime+1)*(1/10)%360 == 0 else (startTime+1)*(1/10)%360
        sNextAngle = 360 if (startTime+1)*(6)%360 == 0 else (startTime+1)*(6)%360
        
        if sAngle < hAngle and sNextAngle >= hNextAngle:
            answer += 1
        if sAngle < mAngle and sNextAngle >= mNextAngle:
            answer += 1
        if hNextAngle == mNextAngle and mNextAngle == sNextAngle:
            answer -= 1
        startTime += 1
    return answer