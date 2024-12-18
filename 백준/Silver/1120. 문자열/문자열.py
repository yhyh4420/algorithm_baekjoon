A,B = map(str,input().split())

def check_diff(A,B):
    answer_list = []
    for i in range(len(B) - len(A)+1):
        answer = 0
        for j in range(len(A)):
            if A[j] != B[i+j]:
                answer += 1
        answer_list.append(answer)
    return min(answer_list)

print(check_diff(A,B))