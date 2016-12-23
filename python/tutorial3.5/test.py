print(list(range(2, 10)))


def f(a, l=[]):
    l.append(a)
    return l

print(f(1))
print(f(2))
print(f(3))


def f2(a, l=None):
    if l is None:
        l = []
    l.append(a)
    return l

print(f2(1))
print(f2(2))
print(f2(3))