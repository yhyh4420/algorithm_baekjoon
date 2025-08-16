def solution(board):
    def win(ch):
        # 가로
        for i in range(3):
            if set(board[i]) == {ch}:
                return True
        # 세로
        for i in range(3):
            if {board[0][i], board[1][i], board[2][i]} == {ch}:
                return True
        # 대각
        if {board[0][0], board[1][1], board[2][2]} == {ch}:
            return True
        if {board[0][2], board[1][1], board[2][0]} == {ch}:
            return True
        return False

    xcount = 0
    ocount = 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == "X":
                xcount += 1
            elif board[i][j] == "O":
                ocount += 1

    # 1) 개수 규칙
    if not (ocount == xcount or ocount == xcount + 1):
        return 0

    owin = win('O')
    xwin = win('X')

    # 2) 승리 규칙
    if owin and xwin:
        return 0
    if owin and ocount != xcount + 1:
        return 0
    if xwin and ocount != xcount:
        return 0

    return 1
