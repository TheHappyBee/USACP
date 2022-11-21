with open('square.in', 'r') as fin:
    # Track the bottom, top, left and rightmost points
    # that need to be covered
    smallestX, largestX, smallestY, largestY = 10, 0, 10, 0

    input = [list(map(int, line.strip().split(' '))) for line in fin.readlines()]
    for i in range(len(input)):
        xLow = input[i][0]
        yLow = input[i][1]
        xHigh = input[i][2]
        yHigh = input[i][3]

        if xLow < smallestX:
            smallestX = xLow
        if xHigh > largestX:
            largestX = xHigh
        if yLow < smallestY:
            smallestY = yLow
        if yHigh > largestY:
            largestY = yHigh

    # Compute the desired side length of the square
    desiredXSideLength = largestX - smallestX
    desiredYSideLength = largestY - smallestY
    desiredSideLength = max(desiredXSideLength, desiredYSideLength)

    with open('square.out', 'w') as fout:
        fout.write(f"{desiredSideLength * desiredSideLength}")

