with open('buckets.in', 'r') as fin:
    s = [list(line) for line in fin.readlines()]
    barn_i = barn_j = rock_i = rock_j = lake_i = lake_j = 0
    for i in range(len(s)):
        line = s[i]
        for j in range(10):
            if (line[j] == 'B'):
                barn_i = i 
                barn_j = j
            if (line[j] == 'R'):
                rock_i = i
                rock_j = j
            if (line[j] == 'L'):
                lake_i = i
                lake_j = j
    
    with open('buckets.out', 'w') as fout:
        dist_br = abs(barn_i - rock_i) + abs(barn_j - rock_j)
        dist_bl = abs(barn_i - lake_i) + abs(barn_j - lake_j)
        dist_rl = abs(rock_i - lake_i) + abs(rock_j - lake_j)

        # Check for special case where rock is between barn and lake
        if ((barn_i == lake_i) or (barn_j == lake_j) and (dist_bl == dist_br + dist_rl)):
            fout.write(f"{dist_bl+1}\n")
        else:
            fout.write(f"{dist_bl-1}\n")