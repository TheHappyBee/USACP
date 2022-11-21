n = int(input())
str = input()
count = 0
list = str.split()
for i in range(0, n):
    list[i] = int(list[i])
for i in range(0, n): # i pinpoints the left interval bound
    for j in range(i, n): # j pinpoints the right interval bound
        average = 0.0
        for k in range(i, j+1): # calculates the average of the interval
            average += list[k]
        average /= (j-i+1) 
        for k in range(i, j+1): # checks whether or not the average exists as a number within the interval
            if list[k] == average:
                count += 1
                break
print(count)