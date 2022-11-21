f= open("blocks.in","r")
o = open("blocks.out","w")
lines = f.read().split('\n')
N = int(lines[0])
ans = [0]*26

for n in range(N):
     list = lines[n+1].split(' ')
     list[0] = [*list[0]]
     list[1] = [*list[1]]
     final = list[0].symmetric_difference(list[1])
     for item in final:
          ans[ord(item)-97]+=1
for item in ans:
     o.write(str(item)+'\n')
o.close()
