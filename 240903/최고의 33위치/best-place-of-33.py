n = int(input())

arr = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    arr.append(tmp)

ans = 0
for i in range(0, n-2):
    for j in range(0, n-2):
        tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2] 
        if tmp > ans: ans = tmp

print(ans)