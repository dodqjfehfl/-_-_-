n,m,k=map(int, input().split())
data=list(map(int, input().split()))

data.sort()

count=int(m/(k+1))*k
count+=m%(k+1)

answer=0
answer+=(count)*data[-1]
answer+=(m-count)*data[-2]

print(answer)

#5 8 3
#2 4 5 4 6