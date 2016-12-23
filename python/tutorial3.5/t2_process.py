# python 流程控制功能

# if：if ... elif ... elif ... else

x = 1

if x < 0:
    x = 0
    print('Negative changed to zero')
elif x == 0:
    print('Zero')
elif x == 1:
    print('Single')
else:
    print('More')

# for：python 的 for 语句依据任意序列（链表或字符串）中的子项，按它们在序列中的顺序来迭代
# 在迭代过程中修改迭代序列不安全（只有在使用链表这样的可变序列时才会出现这样的情况）。如果你想修改迭代的序列，你可以迭代它的副本，
# 使用切割标识就可以很方便的做到这一点
words = ['cat', 'window', 'defenestrate']
for w in words[:]:
    if len(w) > 6:
        words.insert(0, w)


print(words)

# range() 生成等差级数链表
print(list(range(1, 10, 2)))

# break：与 c 语言类似，用于跳出最近一级循环
# continue：循环继续执行下一次迭代
# 循环 else 子句：它在循环迭代完整列表（对于 for ）或执行条件为 false （对于 while）时执行，但循环被 break 中职的情况下不会执行
# pass 语句什么也不做，它用于那些语法上必须要有什么语句，但程序什么也不做的场合
for n in range(2, 10):
    for x in range(2, n):
        if n % x == 0:
            print(n, 'equals', x, '*', n//x)
            break
    else:
        print(n, 'is a prime number')


# 函数
def fib(n):
    """
    :param n: 参数
    :return: list
    """

    result = []
    a, b = 0, 1
    while a < n:
        result.append(a)
        a, b = b, a + b

    return result

f = fib  # 函数重命名
print(f(100))
# 函数参数的定义有3种方式
# 默认参数值：def ask_ok(prompt, retries=4, complaint='Yes or no, please!'):...
i = 5


def f(arg=i):
    """
    :param arg:
    :return:
    """
    print(arg)

i = 6
f()
# Note：默认值只被赋值一次。这使得当默认值是可变对象时会有所不同，比如列表、字典或者大多数类的实例。
# 例如，下面的函数在后续的调用过程中会累积（前面）传递给它的参数


def f(a, l=[]):
    """
    :param a:
    :param l:
    :return:
    """
    l.append(a)
    return l

print(f(1))
print(f(2))
print(f(3))

# 如果你不想让默认值在后续调用中累积，你可以像下面一样定义函数


def f(a, l=None):
    """
    :param a:
    :param l:
    :return:
    """
    if l is None:
        l = []
    l.append(a)
    return l

print(f(1))
print(f(2))
print(f(3))

# 关键字参数：在函数调用中，关键字的参数必须跟随在位置参数的后面，传递的所有关键字参数必须与函数接受的某个参数相匹配，
# 它们的顺序并不重要，这也包括非可选参数。任何参数都不可以多次赋值。
# 引入一个**name参数，它接收一个字典，该字典包含了所有未出现在形式参数类表中的关键字参数，
# *name，它接收一个元祖，包含了所有没有出现在形式参数列表中的参数值（*name必须在**name之前）


def cheeseshop(kind, *arguments, **keywords):
    """

    :param kind:
    :param arguments:
    :param keywords:
    :return:
    """
    print("-- Do you have any", kind, "?")
    print("-- I'm sorry, we're all out of", kind)
    for arg in arguments:
        print(arg)
    print('-' * 40)
    keys = sorted(keywords.keys())
    for kw in keys:
        print(kw, ':', keywords[kw])


cheeseshop("Limburger", "It's very runny, sir.",
           "It's really very, VERY runny, sir.",
           shopkeeper="Michael Palin",
           client="John Cleese",
           sketch="Cheese Shop Sketch")

# 可变参数列表：可变参数是参数列表中的最后一个，因为他们将把所有的剩余输入参数传递给函数，任何出现在*args后的参数是关键字参数，
# 这意味着，他们只能被用作关键字，而不是位置参数。


def contact(*args, sep=','):
    """

    :param args:
    :param sep:
    :return:
    """
    return sep.join(args)

print(contact('earth', 'mars', 'venus'))

print(contact('earth', 'maps', sep='/'))


# 参数列表的分拆：* 可将列表中元素拆分出来作为参数
# ** 可将关键字参数拆分为子典

args = [3, 6]
list(range(*args))

d = {"voltage": "four million", "state": "bleedin' demised", "action": "VOOM"}
# **d

# Lambda 形式：使用 lambda 关键字可以创建短小的匿名函数。


def make_incrementor(n):
    return lambda x: x + n

f = make_incrementor(42)
print(f(0))
print(f(1))