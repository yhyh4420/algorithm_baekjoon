 # 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
a = list(map(int, input().split()))
answer = [1, 1, 2, 2, 2, 8]
for i in range(len(a)):
    print(answer[i] - a[i], end = ' ')