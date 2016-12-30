print(list(range(2, 10)))


def f(a, l=[]):
    l.append(a)
    return l


def f2(a, l=None):
    if l is None:
        l = []
    l.append(a)
    return l