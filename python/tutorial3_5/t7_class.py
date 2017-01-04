# 类

# 一个定义于某模块中的函数的全局作用域是该模块的命名空间，而不是该函数的别名被定义或调用的位置
# global 语句用以指明某个特定的变量为全局作用域，并重新绑定它。nonlocal 语句用以指明某个特定的变量为封闭作用域，并重新绑定它。


def scope_test():
    def do_local():
        spam = 'local spam'

    def do_nonlocal():
        nonlocal spam
        spam = 'nonlocal spam'

    def do_global():
        global spam
        spam = 'global spam'
    spam = 'test spam'
    do_local()
    print('After local assignment: {0}' . format(spam))  # After local assignment: test spam
    do_nonlocal()
    print('After nonlocal assignment: {0}' . format(spam))  # After nonlocal assignment: nonlocal spam
    do_global()
    print('After global assignment: {0}' . format(spam))  # After global assignment: nonlocal spam

scope_test()
print('In global scope: {0}' . format(spam))  # In global scope: global spam

# 方法对象 & 函数对象
# 通常，以 n 个参数的列表去调用一个方法就相当于将方法的对象插入到参数列表的最前面后，以这个列表去调用相应的函数。
# 以一个参数列表调用方法对象时，它被重新拆封，用实例对象和原始的参数列表构造一个新的参数列表，然后函数对象调用这个新的参数列表。
# 实例变量用于对每一个实例都是唯一的数据，类变量用于类的所有实例共享的属性和方法。

# 类对象，支持两种操作：属性引用和实例化


class Complex:
    """
    a simple class example
    """
    r = ''
    i = ''

    def __init__(self, realpart, imagpart):
        self.r = realpart
        self.i = imagpart

x = Complex(3, 4)
print('The value of r, i is {0}, {1}，and doc string is {docStr}' . format(x.r, x.i, docStr=x.__doc__))

# 一般，方法的第一个参数被命名为 self，并且可以通过 self 参数调用其它的方法


class Bag:

    data = []

    def __init__(self):
        self.data = []

    def add(self, x):
        self.data.append(x)
        return self

    def add_twice(self, x):
        self.add(x)
        self.add(x)

x = Bag()
x.add(1)
x.add_twice(2)
print(x.data, Bag.data)  # [1, 2, 2] []

# 继承
# python 有两个用于继承的函数：
#    函数 isinstance() 用于检查实例类型：isinstance(obj, int) 只有在 obj.__class__ 是 int 或者其他从 int 继承的类型
#    函数 issubclass() 用于检查类继承：issubclass(bool, int) 为 true，因为 boll 是 int 的子类


class Egg(Bag):

    def __init__(self):
        Bag.__init__(self)


s = Egg()
s.add_twice(3)
print(s.data)  # [3, 3]

# 多继承
# python 同样支持多继承的形式，属性的搜索是从父类继承的深度优先，从左向右


class MultiExtend(Complex, Bag):
    pass










