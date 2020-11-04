N=int(input())
x,y=1,1
plans=input().split()

dx=[0,0,-1,1]
dy=[-1,1,0,0]
move_types=['L','R','U','D']

for plan in plans:
    for i in range(4):
        if plan==move_types[i]:
            x+=dx[i]
            y+=dy[i]
            if x<1:
                x=1
            if x>N:
                x=N
            if y<1:
                y=1
            if y>N:
                y=N

print(x, y)

#5
#R R R U D D