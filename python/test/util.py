import math
def func(prev:float):
    return prev*pow(math.e, prev-1)

def findI(start:float, bound:float):
    val = start
    i = 1
    while   val >= bound:
        val = func(val)
        i += 1
    return i,val

def findP(start:float, loopCount):
    val = start
    i = 1
    while i <= loopCount:
        val = func(val)
        i += 1
    return i-1, val

if __name__ == '__main__':
    res = findP(0.99, 26)
    print(res)