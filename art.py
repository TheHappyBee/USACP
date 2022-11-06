class Rect:
    def __init__(self, x1=0, y1=0, x2=0, y2=0):
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2
    
    def set_dims(self, _x1, _y1):
        self.x1 = _x1
        self.y1 = _y1
        self.x2 = self.x1
        self.y2 = self.y1

    def extend(self, x, y):
        self.x2 = max(self.x2, x)
        self.y2 = max(self.y2, y)

with open("art.in") as fin:
    N = int(fin.readline())
    rects = []
    for i in range(10):
        rect = Rect()
        rect.set_dims(-1, -1)
        rects.append(rect)

    for i in range(N):
        pass

    