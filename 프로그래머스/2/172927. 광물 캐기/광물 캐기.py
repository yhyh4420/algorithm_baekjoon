def solution(picks, minerals):
    if sum(picks)*5 < len(minerals):
        minerals = minerals[:sum(picks)*5]
    new_minerals = [[0,0,0] for _ in range((len(minerals)//5)+1)]
    for i in range(len(minerals)):
        if minerals[i] == "diamond":
            new_minerals[i//5][0] += 1
        elif minerals[i] == "iron":
            new_minerals[i//5][1] += 1
        else: new_minerals[i//5][2] += 1
    new_minerals.sort(key = lambda x : (x[0],x[1],x[2]), reverse=True)

    answer = 0
    for mineral in new_minerals:
        diamond, iron, stone = mineral
        if picks[0] != 0:
            answer += (diamond + iron + stone)
            picks[0] -= 1
        elif picks[1] != 0:
            answer += (5*diamond + iron + stone)
            picks[1] -= 1
        else:
            answer += (25*diamond + 5*iron + stone)
            picks[2] -= 1
    return answer