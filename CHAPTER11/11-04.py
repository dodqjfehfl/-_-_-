n = int(input())
data = list(map(int, input().split()))
data.sort()

answer = 1

for x in data:
    if answer < x:
        break
    answer += x

print(answer)

# 5
# 3 2 1 1 9

# 8
