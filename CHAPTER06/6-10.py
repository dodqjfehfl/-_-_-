n=int(input())

array=[]
for i in range(n):
    array.append(int(input()))

array=sorted(array, reverse=True)

for i in range(n):
    print(array[i], end=' ')

#3
#15
#27
#21