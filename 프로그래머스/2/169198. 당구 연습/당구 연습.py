def solution(m, n, startX, startY, balls):
    def min_dist(ballX, ballY):
        minimum = float('inf')
        candidates = [
            (-ballX, ballY),
            (2*m - ballX, ballY),
            (ballX, -ballY),
            (ballX, 2*n - ballY)
        ]
        for x, y in candidates:
            if startX == ballX:
                if ballY < startY and y == -ballY:
                    continue
                if ballY > startY and y == 2*n - ballY:
                    continue
            if startY == ballY:
                if ballX < startX and x == -ballX:
                    continue
                if ballX > startX and x == 2*m - ballX:
                    continue
            d = (startX - x) ** 2 + (startY - y) ** 2
            if d < minimum:
                minimum = d
        return minimum

    answer = []
    for ball in balls:
        x,y = ball[0], ball[1]
        answer.append(min_dist(x,y))
    return answer