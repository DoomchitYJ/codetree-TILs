n, m = map(int, input().split())

arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

ans = 0

# . . .
for i in range(n):
    for j in range(m-2):
        tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2]
        if tmp > ans:
            ans = tmp

# .
# .
# .
for j in range(m):
    for i in range(n-2):
        tmp = arr[i][j] + arr[i+1][j] + arr[i+2][j]
        if tmp > ans:
            ans = tmp

# .
# . .

for i in range(n-1):
    for j in range(n-1):
        tmp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1]
        if tmp > ans:
            ans = tmp

#   .
# . .

for i in range(n-1):
    for j in range(n-1):
        tmp = arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1]
        if tmp > ans:
            ans = tmp

# . .
#   .

for i in range(n-1):
    for j in range(n-1):
        tmp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1]
        if tmp > ans:
            ans = tmp

# . .
# .

for i in range(n-1):
    for j in range(n-1):
        tmp = arr[i][j] + arr[i+1][j] + arr[i][j+1]
        if tmp > ans:
            ans = tmp

print(ans)