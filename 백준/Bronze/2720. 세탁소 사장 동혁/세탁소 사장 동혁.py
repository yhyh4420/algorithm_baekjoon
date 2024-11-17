def func(C):
    q = C//25
    d = (C-q*25)//10
    n = (C-q*25-d*10)//5
    p = (C-q*25-d*10-n*5)
    print(f"{q} {d} {n} {p}")

N = int(input())
for _ in range(N):
    C = int(input())
    func(C)