def solve(dist, minspeed):
    lhstravel = 0
    rhstravel = 0
    timeused = 0
    currspeed = 1
    while True:
        lhstravel += currspeed
        timeused += 1
        if (lhstravel + rhstravel >= dist):
            return timeused
        if currspeed >= minspeed:
            rhstravel += currspeed
            timeused += 1
            if (lhstravel + rhstravel) >= dist:
                return timeused
        
        currspeed += 1

fin = open('race.in', 'r')
fout = open('race.out', 'w')
line = fin.readline().split()
k = int(line[0])
n = int(line[1])
for i in range(n):
    minspeed = int(fin.readline())
    fout.write(f"{solve(k, minspeed)}\n")

fin.close()
fout.close()