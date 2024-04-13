import sys
N = int(sys.stdin.readline())
word = []
for _ in range(N):
    word.append(sys.stdin.readline().strip())

word_list = list(set(word))
word_list.sort()
word_list.sort(key = len)

for i in word_list:
    print(i)