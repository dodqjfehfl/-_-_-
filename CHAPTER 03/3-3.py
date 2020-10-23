n, m=map(int, input().split())

answer=0

for i in range(n):
    data=list(map(int, input().split()))
    min_value=min(data)
    answer=max(answer, min_value)

print(answer)

#3 3
#3 1 2
#4 1 4
#2 2 2

#2 4
#7 3 1 8
#3 3 3 4