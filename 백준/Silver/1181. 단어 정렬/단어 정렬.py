N = int(input())
word = []
for _ in range(N):
    word.append(input())

word_list = list(set(word))
word_list.sort()
word_list.sort(key = len)

for i in word_list:
    print(i)