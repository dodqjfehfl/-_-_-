data = input()

answer = int(data[0])

for i in range(1, len(data)):
    num = int(data[i])
    if num <= 1 or answer <= 1:
        answer += num
    else:
        answer *= num
print(answer)

# 02984

# 576

# 567

# 210

# 아이디어는 알지만 문법이 어색함
