n, m = map(int, input().split())

arr = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    arr.append(tmp)

ans = 0

# 가로
for i in range(n):
    prev = arr[i][0]
    cnt = 1
    for j in range(1, n):
        if arr[i][j] == prev:
            cnt += 1
            if cnt == m:
                ans += 1
                break
        else:
            prev = arr[i][j]
            cnt = 1

# 세로
for i in range(n):
    prev = arr[0][i]
    cnt = 1
    for j in range(1, n):
        if arr[j][i] == prev:
            cnt += 1
            if cnt == m:
                ans += 1
                break
        else:
            prev = arr[j][i]
            cnt = 1

print(ans)