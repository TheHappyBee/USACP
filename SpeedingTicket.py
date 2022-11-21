# initialize file I/O
f = open('speeding.in', 'r')
# read in the first line, store n and m
n, m = map(int, f.readline().split(' '))
# speed_limits[K] will store the speed limit of the section of road
# starting at mile K and ending at mile K+1.
speed_limit = [0]
for i in range(n):
    # read in length and speed limit of segment i of the road
    x, y = map(int, f.readline().split(' '))
    for j in range(x):
        speed_limit.append(y)
# ans will store the maximum amount over the speed limit that Bessie
# traveled.
tot_length = 0
ans = 0
for i in range(m):
    # read in length and speed of segment i Bassie actually drove.
    x, y = map(int, f.readline().split(' '))
    # update maxOver if we have exceeded it
    for j in range(tot_length + 1, tot_length + x + 1):
        ans = max(ans, y - speed_limit[j])
    tot_length += x

with open('speeding.out', 'w') as out:
    out.write(str(ans))
