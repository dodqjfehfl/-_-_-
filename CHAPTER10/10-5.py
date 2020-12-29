def find_patent(parent, x):
    if parent[x]!=x:
        parent[x]=find_patent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a=find_patent(parent, a)
    b=find_patent(parent, b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

v,e=map(int, input().split())
parent=[0]*(v+1)

edges=[]
result=0

for i in range(1, v+1):
    parent[i]=i

for _ in range(e):
    a, b, cost=map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

for edge in edges:
    cost, a, b=edge
    if find_patent(parent, a)!=find_patent(parent,b):
        union_parent(parent, a, b)
        result+=cost

print(result)

# 7 9
# 1 2 29
# 1 5 75
# 2 3 35
# 2 6 34
# 3 4 7
# 4 6 23
# 4 7 13
# 5 6 53
# 6 7 25

# 159