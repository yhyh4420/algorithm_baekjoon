def solution(players, m, k):
    answer = 0
    servers = [0] * 24
    for i, player in enumerate(players):
        server_add = player//m
        server_now = servers[i]
        if server_add > server_now:
            answer += (server_add-server_now)
            for j in range(i, min(24, i+k)):
                servers[j] += (server_add-server_now)
    return answer