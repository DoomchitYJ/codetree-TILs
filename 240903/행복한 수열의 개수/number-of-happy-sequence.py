n, m = map(int, input().split())

arr = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    arr.append(tmp)

ans = 0

# 가로
for i in range(n):
    cnt = 1
    for j in range(n-1):
        if arr[i][j] == arr[i][j+1]:
            cnt += 1
        else:
            cnt = 1
        if cnt >= m:
            ans += 1
            cnt = 1
            break
            
# 세로
for i in range(n):
    cnt = 1
    for j in range(n-1):
        if arr[j][i] == arr[j+1][i]:
            cnt += 1
        else:
            cnt = 1
        if cnt >= m:
            ans += 1
            cnt = 1
            break

print(ans)