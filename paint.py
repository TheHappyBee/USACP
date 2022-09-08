with open("paint.in", "r") as f:
    a, b = map(int, f.readline().strip().split())
    c, d = map(int, f.readline().strip().split())

ans = len(set(range(a, b)) | set(range(c, d)))

with open("paint.out", "w") as f:
    f.write(str(ans)+"\n")